package com.mark.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ConfigController:
 * <p>
 */
@RestController
@RefreshScope
@RequestMapping("/recommand")
public class RecommandController {
    @Value("${recommand.test}")
    private String moviePath;

    @GetMapping("test")
    Map<String, Object> getPath() {
        Map<String, Object> map = new HashMap<>();
        map.put("recommand", moviePath);
        return map;
    }
}
