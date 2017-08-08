package com.mark.web;

import com.mark.source.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController:
 * <p>
 */
@RestController
public class MessageController {
    @Autowired
    private MessageSender messageSender;
    @GetMapping("/send/{message}")
    public String sendMsg(@PathVariable("message")  String message){
        messageSender.sendMessage();
        return message;
    }
}
