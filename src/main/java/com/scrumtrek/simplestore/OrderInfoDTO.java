package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

public class OrderInfoDTO {

    private String nameCustomer;
    private Map<String, Double> movieMap = new HashMap<>();
    private double totalAmount;
    private int frequentRenterPoints;

    public Map<String, Double> getMovieMap() {
        return movieMap;
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

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }
}
