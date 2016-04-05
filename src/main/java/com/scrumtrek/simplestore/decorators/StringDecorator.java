package com.scrumtrek.simplestore.decorators;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;

/**
 * The class is responsible for generating the information in a predetermined pattern
 */
public class StringDecorator implements Decorator {

    @Override
    public String generateReport(Customer customer) {
        StringBuilder result = new StringBuilder("Rental record for ");
        result.append(customer.getName()).append("\n");

        for (Rental rental : customer.getRentals()) {
            for (Movie movie : rental.getMovies()) {
                result.append("\t").append(movie.getTitle()).append("\t");
                result.append(customer.getMovieRentedDaysAmount(movie, rental)).append("\n");
            }
        }
        result.append("Amount owed is ").append(customer.getTotalAmount());
        return result.toString();
    }
}
