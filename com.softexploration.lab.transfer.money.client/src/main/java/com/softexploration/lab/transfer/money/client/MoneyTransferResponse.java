package com.softexploration.lab.transfer.money.client;

import javax.jms.Connection;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MoneyTransferResponse implements Runnable {

	public void run() {

		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					System.getProperty("broker.url", "tcp://localhost:61616"));

			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			MessageConsumer consumer = session.createConsumer(session
					.createQueue(System.getProperty(
							"transfer.response.destination",
							"transfer.response.destination")));

			Message message = consumer.receive();

			if (message instanceof MapMessage) {
				MapMessage mapMessage = (MapMessage) message;
				int code = mapMessage.getIntProperty("code");
				String msg = mapMessage.getStringProperty("msg");
				System.out.println("code [" + code + "], msg [" + msg + "]");
			}

			consumer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}