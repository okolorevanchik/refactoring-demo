package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.OrderInfoDTO;

import java.util.Map;

public class StringReportGenerator implements ReportGenerator {

    @Override
    public String generateReport(OrderInfoDTO orderInfoDTO) {
        StringBuilder result = new StringBuilder("Rental record for ");
        result.append(orderInfoDTO.getNameCustomer()).append("\n");

        for (Map.Entry<String, Double> movie : orderInfoDTO.getMovieMap().entrySet()) {
            result.append("\t").append(movie.getKey()).append("\t").append(movie.getValue()).append("\n");
        }
        result.append("Amount owed is ").append(orderInfoDTO.getTotalAmount()).append("\n");
        result.append("You earned ").append(orderInfoDTO.getFrequentRenterPoints()).append(" frequent renter points.");
        return result.toString();
    }
}
