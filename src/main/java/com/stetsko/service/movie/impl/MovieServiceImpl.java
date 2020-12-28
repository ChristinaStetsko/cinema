package com.stetsko.service.movie.impl;

import com.stetsko.converter.IConverter;
import com.stetsko.converter.movie.MovieConverter;
import com.stetsko.dao.movie.MovieDAO;
import com.stetsko.dao.movie.SqlMovieDAO;
import com.stetsko.entity.movie.Movie;
import com.stetsko.service.dto.MovieDTO;
import com.stetsko.service.movie.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    private MovieDAO movieDAO = new SqlMovieDAO();
    private IConverter<Movie, MovieDTO> converter = new MovieConverter();

    @Override
    public List<MovieDTO> getAllMovies() {
        return null;
    }

    @Override
    public MovieDTO getMovieByTitle(String title) {
        return null;
    }

}