package com.scrumtrek.simplestore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void addRental(Rental arg){
		rentals.add(arg);
	}

	private CustomerStatDto statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;

        CustomerStatDto dto = new CustomerStatDto();

		for(Rental each: rentals) {
            for (Order order : each.getOrderSet()) {
                double thisAmount = 0;

                // Determine amounts for each line
                switch (order.getMovie().getPriceCode()) {
                    case Regular:
                        thisAmount += 2;
                        if (order.getDaysRented() > 2) {
                            thisAmount += (order.getDaysRented() - 2) * 1.5;
                        }
                        break;

                    case NewRelease:
                        thisAmount += order.getDaysRented() * 3;
                        break;

                    case Childrens:
                        thisAmount += 1.5;
                        if (order.getDaysRented() > 3) {
                            thisAmount = (order.getDaysRented() - 3) * 1.5;
                        }
                        break;
                }

                // Add frequent renter points
                frequentRenterPoints++;

                // Add bonus for a two-day new-release rental
                if ((order.getMovie().getPriceCode() == PriceCodes.NewRelease) && (order.getDaysRented() > 1)) {
                    frequentRenterPoints++;
                }
                dto.getMovieMap().put(order.getMovie().getTitle(), thisAmount);

                // Show figures for this rental
                totalAmount += thisAmount;
            }
		}

        dto.setTotalAmount(totalAmount);
        dto.setFrequentRenterPoints(frequentRenterPoints);
		return dto;
	}

    public String statementString() {
        CustomerStatDto dto = statement();
        String result = "Rental record for " + name + "\n";
        for (Map.Entry<String, Double> movie : dto.getMovieMap().entrySet()) {
            result += "\t" + movie.getKey() + "\t" + movie.getValue() + "\n";
        }
        result += "Amount owed is " + dto.getTotalAmount() + "\n";
        result += "You earned " + dto.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    public String statementJson() {
        CustomerStatDto dto = statement();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(dto);
    }
}