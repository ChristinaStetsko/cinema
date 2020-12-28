package com.stetsko.dao.movie;

import com.stetsko.dao.sql.SqlQueries;
import com.stetsko.dao.util.ConnectionManager;
import com.stetsko.entity.field.movie.MovieFields;
import com.stetsko.entity.movie.Movie;
import com.stetsko.exceptions.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SqlMovieDAO extends ConnectionManager implements MovieDAO {

    @Override
    public Movie create(Movie entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {

    }

    @Override
    public List<Movie> getAll() throws DAOException {
        final Optional<Connection> connectionOptional = Optional.ofNullable(getConnection());
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(SqlQueries.SQL_READ_ALL_MOVIES);
                List<Movie> movies = new ArrayList<>();
                while (resultSet.next()) {
                    final Movie movie = processResultSet(resultSet);
                    movies.add(movie);
                }
                return movies;
            } catch (SQLException e) {
                // TODO: 28.12.2020 Add Logger
                throw new DAOException("Unable to retrieve products");
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Movie updateEntity(Movie entity) throws DAOException {
        return null;
    }

    @Override
    public Movie getByTitle(String title) {
        return null;
    }

    @Override
    public Optional<Movie> getEntity(Long id) throws DAOException {
        return Optional.empty();
    }

    private Movie processResultSet(ResultSet resultSet) {
        try {
            final String title = resultSet.getString(MovieFields.TITLE);
            final String description = resultSet.getString(MovieFields.DESCRIPTION);
            return new Movie(title, description);
        } catch (SQLException e) {
            // TODO: 28.12.2020 Logger
            throw new DAOException("Unable to read product", e);
        }
    }
}