package com.mark.movie.controller;

import com.mark.movie.dto.MovieDTO;
import com.mark.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MovieController:
 * <p>
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    List<MovieDTO> list() {
        return movieService.getMovieList();
    }
}
