package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * A class describes the object of the order
 */
public class Rental {

    /**
     * List of  movies
     */
    private List<Movie> movies = new ArrayList<>();

    /**
     * Number of rental days
     */
    private int daysRented;

    public Rental(int daysRented) {
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

