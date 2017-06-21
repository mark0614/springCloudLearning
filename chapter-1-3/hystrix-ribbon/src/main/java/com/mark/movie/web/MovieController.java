package com.mark.movie.web;

import com.mark.movie.domain.MovieDTO;
import com.mark.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   @Autowired
   private MovieService movieService;

    @GetMapping(value = "list")
    public List<MovieDTO> list() {
        return movieService.list();
    }

    @GetMapping(value = "{id}")
    public MovieDTO findOne(@PathVariable long id) {
        return movieService.findOne(id);
    }
}
