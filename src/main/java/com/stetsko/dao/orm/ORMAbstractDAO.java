package com.stetsko.dao.orm;

import com.stetsko.dao.AbstractDAO;
import com.stetsko.dao.orm.session.SessionFactoryProvider;
import com.stetsko.entity.IEntity;
import com.stetsko.exceptions.DAOException;

import java.util.List;
import java.util.Optional;

public abstract class ORMAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    private static final SessionFactoryProvider SESSION_FACTORY_PROVIDER = SessionFactoryProvider.getInstance();

    @Override
    public E create(E entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {

    }

    @Override
    public List<E> getAll() throws DAOException {
        return null;
    }

    @Override
    public E updateEntity(E entity) throws DAOException {
        return null;
    }

    @Override
    public Optional<E> getEntity(Long id) throws DAOException {
        return Optional.empty();
    }
}