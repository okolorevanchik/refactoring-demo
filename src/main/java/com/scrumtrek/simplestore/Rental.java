package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    private List<Movie> movies = new ArrayList<>();
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

