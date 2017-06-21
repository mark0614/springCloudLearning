package com.mark.movie.service;

import com.mark.movie.dto.MovieDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="MOVIE-SERVICE",fallback = MovieServiceHystrix.class)
public interface MovieService {

    @RequestMapping(value = "/movie/list", method = RequestMethod.GET)
    List<MovieDTO> getMovieList();

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    MovieDTO findOne(@PathVariable long id);
}
