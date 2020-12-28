package com.stetsko.entity.ticket;

import com.stetsko.entity.AbstractEntity;

public class Ticket extends AbstractEntity {

    private Long id;
    private String movieTitle;
    private String details;
    private double price;

    public Ticket(long id, String movieTitle, String details, double price) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.details = details;
        this.price = price;
    }

    public Ticket() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                '}';
    }
}