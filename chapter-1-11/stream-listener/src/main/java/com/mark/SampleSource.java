package com.mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

/**
 * SampleSource:
 * <p>
 */
@EnableBinding(SampleSource.Source.class)
public class SampleSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleSource.class);

    @InboundChannelAdapter(value = Source.SAMPLE, poller = {
            @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1")
    })
    @Bean
    public MessageSource<String> sendMessage() {
        return () -> {
            String value = "{\"value\":\"hello\"}";
            LOGGER.info("Send message:{}", value);
            return MessageBuilder
                    .withPayload(value).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .build();
        };
    }

    public interface Source {
        String SAMPLE = "sample-source";

        @Output(Source.SAMPLE)
        MessageChannel sampleSource();
    }
}
