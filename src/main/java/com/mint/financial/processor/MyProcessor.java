package com.mint.financial.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;


public interface MyProcessor {
	String INPUT = "myInput";
	 
    @Input
    SubscribableChannel myInput();
 
    @Output("myOutput")
    MessageChannel anOutput();
 
    @Output
    MessageChannel anotherOutput();
}
