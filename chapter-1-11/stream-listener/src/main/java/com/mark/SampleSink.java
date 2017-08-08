package com.mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

/**
 * SampleSink:
 * <p>
 */
@EnableBinding(SampleSink.Sink.class)
public class SampleSink {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleSink.class);
    @StreamListener(SampleSink.Sink.SAMPLE)
    public void recieve(Foo fooMessage){
        LOGGER.info("Recieved message {} of type {}",fooMessage.getValue(),fooMessage.getClass());
    }

    public interface Sink{
        String SAMPLE="sample-sink";

        @Input(Sink.SAMPLE)
        SubscribableChannel sink();
    }
}
