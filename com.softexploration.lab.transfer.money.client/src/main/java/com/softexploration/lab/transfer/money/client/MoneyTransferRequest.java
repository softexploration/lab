package com.softexploration.lab.transfer.money.client;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MoneyTransferRequest implements Runnable {

	private Double amount;

	public MoneyTransferRequest(Double amount) {
		this.amount = amount;
	}

	public void run() {

		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					System.getProperty("broker.url", "tcp://localhost:61616"));

			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			MessageProducer producer = session.createProducer(session
					.createQueue(System.getProperty(
							"transfer.request.destination",
							"transfer.request.destination")));

			TextMessage message = session
					.createTextMessage(amount != null ? amount.toString()
							: null);
			message.setJMSReplyTo(session.createQueue(System.getProperty(
					"transfer.response.destination",
					"transfer.response.destination")));

			producer.send(message);

			producer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}