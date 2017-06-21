package com.mark.movie.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * MovieDTO:
 * <p>
 */
@Data
@Builder
public class MovieDTO implements Serializable{

    private long id;

    private String title;

    private String director;

    private String screenTime;
}
