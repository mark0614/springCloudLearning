package com.mark.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Service2Controller:
 * <p>
 */
@RestController
public class Service2Controller {
    public static final Logger LOGGER = LoggerFactory.getLogger(Service2Controller.class);


    @GetMapping("/b")
    public Map<String,Object> get() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","service-B");
        LOGGER.info("I am service-B");
        return map;
    }
}
