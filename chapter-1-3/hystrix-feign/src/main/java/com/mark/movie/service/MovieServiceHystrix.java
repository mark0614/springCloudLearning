package com.mark.movie.service;

import com.mark.movie.dto.MovieDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * MovieServiceHystrix:
 * <p>
 */
public class MovieServiceHystrix implements MovieService {
    @Override
    public List<MovieDTO> getMovieList() {
        return null;
    }

    @Override
    public MovieDTO findOne(@PathVariable long id) {
        return null;
    }
}
