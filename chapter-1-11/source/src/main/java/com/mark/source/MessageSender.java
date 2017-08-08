package com.mark.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.support.MessageBuilder;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * MessageSender:
 * <p>
 */
@EnableBinding(Channels.class)
public class MessageSender {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    @InboundChannelAdapter(value = Channels.PRODUCTS,poller = {
            @Poller(fixedRate = "5000")
    })
    public String sendMessage(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }
}
