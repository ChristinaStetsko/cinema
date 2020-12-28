package com.stetsko.service.movie;

import com.stetsko.service.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieByTitle(String title);

}