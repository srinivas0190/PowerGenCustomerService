package com.powergen.utilityservices.webservices.jmsmessage;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.powergen.utilityservices.service.jmsmessage.MessageReceiverService;

/**
 * @author Srinivas Kondapaneni
 * JMS listener to listen to the service messages in the activeMQ
 */
@Component("JMSListener")
public class JMSListener implements SessionAwareMessageListener<TextMessage> {

	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {

		ActiveMQTextMessage textMessage = new ActiveMQTextMessage();

		textMessage.setText("Received");

		MessageProducer producer = session.createProducer(message.getJMSReplyTo());

		producer.send(textMessage);

		if (message instanceof TextMessage) {

			String msg = ((TextMessage) message).getText();

			String[] msgAry = msg.split(" ");

			int customerId = Integer.parseInt(msgAry[0]);
			int serviceId = Integer.parseInt(msgAry[1]);

			MessageReceiverService receiverService = new MessageReceiverService();
			receiverService.setCustomerService(customerId, serviceId);
		}
	}
}
