package com.mark.movie.service;

import com.mark.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * MovieService:
 * <p>
 */
@Service
public class MovieService {
    public List<MovieDTO> findMovies() {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        MovieDTO movieDTO1 = MovieDTO.builder()
                .id(1)
                .title("异形 契约")
                .director("雷德利·斯科特")
                .screenTime("2017-06-16").build();
        MovieDTO movieDTO2 = MovieDTO.builder()
                .id(2)
                .title("变形金刚5：最后的骑士")
                .director(" 迈克尔·贝")
                .screenTime("2017-06-23").build();
        MovieDTO movieDTO3 = MovieDTO.builder()
                .id(3)
                .title("神偷奶爸3")
                .director("凯尔·巴尔达")
                .screenTime("2017-07-07").build();
        movieDTOList.add(movieDTO1);
        movieDTOList.add(movieDTO2);
        movieDTOList.add(movieDTO3);
        return movieDTOList;
    }

    public MovieDTO findOne(String id) {
        return MovieDTO.builder()
                .id(1)
                .title("异形 契约")
                .director("雷德利·斯科特")
                .screenTime("2017-06-16").build();
    }
}
