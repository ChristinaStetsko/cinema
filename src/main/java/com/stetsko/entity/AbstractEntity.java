package com.stetsko.entity;

public abstract class AbstractEntity implements IEntity {

    protected Long id;

    public AbstractEntity() {
    }

    public AbstractEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
