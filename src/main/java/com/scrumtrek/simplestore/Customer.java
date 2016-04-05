package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.reports.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private ReportGenerator reportGenerator;

    public Customer(String name, ReportGenerator reportGenerator) {
        this.name = name;
        this.reportGenerator = reportGenerator;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        ProcessorOrder instance = ProcessorOrder.getInstance();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setNameCustomer(getName());
        instance.processOrder(orderInfoDTO, rentals);
        return reportGenerator.generateReport(orderInfoDTO);
    }
}