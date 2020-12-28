package com.stetsko.converter.movie;

import com.stetsko.converter.AbstractConverter;
import com.stetsko.entity.movie.Movie;
import com.stetsko.service.dto.MovieDTO;

public class MovieConverter extends AbstractConverter<Movie, MovieDTO> {
    @Override
    public MovieDTO convert(Movie movie) {
        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription());
    }
}