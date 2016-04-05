package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.reports.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name, ReportGenerator reportGenerator) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public double getTotalAmount() {
        double totalAmount = 0;

        for (Rental each : rentals) {
            for (Movie movie : each.getMovies()) {
                double thisAmount = getMovieRentedDaysAmount(movie, each.getDaysRented());
                totalAmount += thisAmount;
            }
        }

        return totalAmount;
    }

    public double getMovieRentedDaysAmount(Movie movie, int daysRented) {
        double result = movie.getPriceCode().getStartPrice();
        int lowCostDaysCount = movie.getPriceCode().getLowCostDaysCount();
        if (daysRented > lowCostDaysCount) {
            result += movie.getPriceCode().getAmountPrice();
        }

        return result;
    }
}