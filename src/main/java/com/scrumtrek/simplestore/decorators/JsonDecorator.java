package com.scrumtrek.simplestore.decorators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scrumtrek.simplestore.Customer;

/**
 * The class responsible for generating information in json
 */
public class JsonDecorator implements Decorator {

    @Override
    public String generateReport(Customer customer) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        CustomerInfoDto customerInfoDto = new CustomerInfoDto(customer, customer.getTotalAmount());
        return gson.toJson(customerInfoDto);
    }

    /**
     * DTO class for json format report
     */
    private class CustomerInfoDto {

        private Customer customer;
        private double totalAmount;

        public CustomerInfoDto(Customer customer, double totalAmount) {
            this.customer = customer;
            this.totalAmount = totalAmount;
        }
    }
}
