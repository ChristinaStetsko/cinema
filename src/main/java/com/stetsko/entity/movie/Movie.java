package com.stetsko.entity.movie;

import com.stetsko.entity.AbstractEntity;

public class Movie extends AbstractEntity {

    private String title;
    private String description;

    public Movie(String title, String description) {
    }

    public Movie(Long id, String title, String description) {
        super(id);
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
