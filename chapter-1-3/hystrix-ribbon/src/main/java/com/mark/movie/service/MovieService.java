package com.mark.movie.service;

import com.mark.movie.domain.MovieDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MovieService:
 * <p>
 */
@Service
@Slf4j
public class MovieService {
    private static final String END_POINT_LIST = "http://MOVIE-SERVICE/movie/list";

    private static final String END_POINT_ONE = "http://MOVIE-SERVICE/movie/{id}";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "listFallback")
    public List<MovieDTO> list() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MOVIE-SERVICE");
        log.info("list movie---{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForEntity(END_POINT_LIST, List.class, new HashMap<String,Object>()).getBody();
    }

    @HystrixCommand(fallbackMethod = "findOneFallback")
    public MovieDTO findOne(long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ServiceInstance serviceInstance = loadBalancerClient.choose("MOVIE-SERVICE");
        log.info("find one movie---{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForEntity(END_POINT_ONE, MovieDTO.class, paramMap).getBody();
    }

    private List<MovieDTO> listFallback() {
        return null;
    }

    private MovieDTO findOneFallback(long id){
        return null;
    }

}
