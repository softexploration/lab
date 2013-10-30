package com.softexploration.lab.transfer.money.listener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.softexploration.lab.transfer.money.service.TransferService;

/**
 * 
 * Money transfer listener
 * 
 */
public class TransferListener implements MessageListener {

	private TransferService transferService;
	private JmsTemplate jmsTemplate;

	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public synchronized void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				// retrieve amount from message
				Double amount = Double.parseDouble(textMessage.getText());

				// make a transfer
				transferService.transfer(amount);

				// reply
				replyTo(message.getJMSReplyTo(), 0, "OK");
			} catch (Throwable th) {
				th.printStackTrace();
				try {
					// reply
					replyTo(message.getJMSReplyTo(), -1, th.getMessage());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Reply to a destination with a certain status code and status message
	 * 
	 * @param destination
	 *            - where to reply to
	 * @param code
	 *            - 0 for success, non-zero otherwise
	 * @param message
	 *            - message regarding operation status
	 */
	private void replyTo(Destination destination, final int code,
			final String message) {
		if (destination != null) {
			jmsTemplate.send(destination, new MessageCreator() {
				public Message createMessage(Session session)
						throws JMSException {
					MapMessage mapMessage = session.createMapMessage();
					mapMessage.setIntProperty("code", code);
					mapMessage.setStringProperty("msg", message);
					return mapMessage;
				}
			});
		}
	}
}
