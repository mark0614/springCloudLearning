package com.mark.movie.web;

import com.mark.movie.domain.MovieDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * MovieController:
 * <p>
 */
@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {
    private String endPoint = "http://MOVIE-SERVICE/movie/list";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "list")
    public List<MovieDTO> list() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MOVIE-SERVICE");
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForEntity(endPoint, List.class, new HashMap<String,Object>()).getBody();
    }
}
