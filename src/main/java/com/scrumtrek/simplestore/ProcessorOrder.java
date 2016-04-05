package com.scrumtrek.simplestore;

import java.util.List;

public class ProcessorOrder {

    private static ProcessorOrder processorOrder;

    public static ProcessorOrder getInstance() {
        if (processorOrder == null) {
            processorOrder = new ProcessorOrder();
        }
        return processorOrder;
    }

    public void processOrder(OrderInfoDTO orderInfo, List<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental each : rentals) {
            for (Movie movie : each.getMovies()) {
                double thisAmount = getMovieRentedDaysAmount(movie, each.getDaysRented());
                orderInfo.getMovieMap().put(movie.getTitle(), thisAmount);
                totalAmount += thisAmount;
            }
            frequentRenterPoints += each.getMovies().size();
        }

        orderInfo.setTotalAmount(totalAmount);
        orderInfo.setFrequentRenterPoints(frequentRenterPoints);
    }

    private double getMovieRentedDaysAmount(Movie movie, int daysRented) {
        double result = movie.getPriceCode().getStartPrice();
        int lowCostDaysCount = movie.getPriceCode().getLowCostDaysCount();
        if (daysRented > lowCostDaysCount) {
            result += movie.getPriceCode().getAmountPrice();
        }

        return result;
    }
}
