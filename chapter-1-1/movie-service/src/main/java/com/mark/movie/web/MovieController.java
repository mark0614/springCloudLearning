package com.mark.movie.web;

import com.mark.movie.dto.MovieDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * MovieController:
 * <p>
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping(value = "list")
    public List<MovieDTO> list() {
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
}
