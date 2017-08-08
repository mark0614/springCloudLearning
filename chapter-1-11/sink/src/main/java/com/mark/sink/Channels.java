package com.mark.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Channels:${DESCRIPTION}
 * Author: Administrator
 * Create: 2017-7-17
 */
public interface Channels {
    String ORDERS="orders";

    //String PRODUCTS="products";

    @Input(Channels.ORDERS)
    SubscribableChannel orders();

//    @Output(Channels.PRODUCTS)
//    MessageChannel products();
}
