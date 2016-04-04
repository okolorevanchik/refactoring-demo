package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anton on 04.04.16.
 */
public class CustomerStatDto {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    Map<String, Double> movieMap = new HashMap<>();


    public Map<String, Double> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(Map<String, Double> movieMap) {
        this.movieMap = movieMap;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }
}
