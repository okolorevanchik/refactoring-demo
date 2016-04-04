package com.scrumtrek.simplestore;

/**
 * Created by anton on 04.04.16.
 */
public class Order {
    private Movie movie;
    private int daysRented;

    public Order(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
