package com.mark.movie.web;

import com.mark.movie.service.MovieService;
import com.mark.movie.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(value = "list")
    public List<MovieDTO> list() {
        return movieService.findMovies();
    }

    @GetMapping("{id}")
    MovieDTO get(@PathVariable String id){
        return movieService.findOne(id);
    }
}
