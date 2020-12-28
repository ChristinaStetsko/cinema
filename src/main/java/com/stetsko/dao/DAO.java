package com.stetsko.dao;

import com.stetsko.entity.IEntity;
import com.stetsko.exceptions.DAOException;

import java.util.List;
import java.util.Optional;

public interface DAO<T extends IEntity> {

    T create(T entity) throws DAOException;

    void deleteEntity(Long id) throws DAOException;

    List<T> getAll() throws DAOException;

    T updateEntity(T entity) throws DAOException;

    Optional<T> getEntity(Long id) throws DAOException;
}