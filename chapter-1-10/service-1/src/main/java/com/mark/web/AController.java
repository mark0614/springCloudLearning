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
 * AController:
 * <p>
 */
@RestController
public class AController {
    public static final Logger LOGGER = LoggerFactory.getLogger(AController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/a")
    public Map<String, Object> getUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "mark");
        map.put("age", 33);
        ResponseEntity<Map> entity;
        entity = restTemplate.getForEntity("http://localhost:8082/b", Map.class,"");
        LOGGER.info("service-a call service b");
        return map;
    }
}
