package com.mint.financial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import com.mint.financial.processor.MyProcessor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class MintKafkaStreamProcessorApplication {
	private static final int SENDING_MESSAGE_TIMEOUT  = 10000 ;
	
	private	 Logger logger  = LoggerFactory.getLogger(MintKafkaStreamProcessorApplication.class);
	
	@Autowired
	private Processor processor;
	 
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String sendOutput(String message) {
	logger.info("sending message : "+ message + " com.ng.vela.even.card_verified");
	processor.output().send(MessageBuilder.withPayload(message).build());
	   return message ;
	   }
	
	public static void main(String[] args) {
		SpringApplication.run(MintKafkaStreamProcessorApplication.class, args);
	}

}






















































































