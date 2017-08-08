package com.mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * SampleTransformer:
 * <p>
 */
@EnableBinding(Processor.class)
public class SampleTransformer {
    private static final String TRANSFORMATION_VALUE = "HI";
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTransformer.class);
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Bar recieve(Bar barMessage){
        LOGGER.info("At message transformer");
        LOGGER.info("Recieved Message {} of type {}", barMessage.getValue(), barMessage.getClass());
        LOGGER.info("Transforming the value to {} and with type of", TRANSFORMATION_VALUE, barMessage.getClass().getClass());
        barMessage.setValue(TRANSFORMATION_VALUE);
        return barMessage;
    }
}
