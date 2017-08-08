package com.mark.sink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * LogSink:
 * <p>
 */
@EnableBinding(Channels.class)
public class LogSink {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogSink.class);

    @ServiceActivator(inputChannel = Channels.ORDERS)
    public void loggerSink(String payload){
        LOGGER.info("Recieved message: "+ payload);
    }
}
