package com.powergen.customerservice.jms.registration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * JMS service class
 * @author Srinivas Kondapaneni
 *
 */
@Component("queueSender")
public class JmsQueueSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	

	 public void sendMessage(final String text) {
	      
		    this.jmsTemplate.send(new MessageCreator() {
		    	
		      @Override
		      public Message createMessage(Session session) throws JMSException {
		    	  
		        Message message = session.createTextMessage(text);     
		        //set ReplyTo header of Message, pretty much like the concept of email.
		        message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
		        return message;
		      }
		    });
	 }
}
