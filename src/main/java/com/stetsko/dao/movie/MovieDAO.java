package com.stetsko.dao.movie;

import com.stetsko.dao.DAO;
import com.stetsko.entity.movie.Movie;

public interface MovieDAO extends DAO<Movie> {

    Movie getByTitle(String title);
}