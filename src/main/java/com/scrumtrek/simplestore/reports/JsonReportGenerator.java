package com.scrumtrek.simplestore.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scrumtrek.simplestore.Customer;

public class JsonReportGenerator implements ReportGenerator {

    private class CustomerInfoDto {

        private Customer customer;
        private double totalAmount;

        public CustomerInfoDto(Customer customer, double totalAmount) {
            this.customer = customer;
            this.totalAmount = totalAmount;
        }
    }

    @Override
    public String generateReport(Customer customer) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        CustomerInfoDto customerInfoDto = new CustomerInfoDto(customer, customer.getTotalAmount());
        return gson.toJson(customerInfoDto);
    }
}
