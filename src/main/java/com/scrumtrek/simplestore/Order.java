package com.scrumtrek.simplestore;

/**
 * Created by anton on 04.04.16.
 */
public class Order {
    private Movie m_Movie;
    private int m_DaysRented;

    public Order(Movie movie, int daysRented) {
        m_Movie = movie;
        m_DaysRented = daysRented;
    }

    public int getDaysRented() {
        return m_DaysRented;
    }

    public Movie getMovie() {
        return m_Movie;
    }
}
