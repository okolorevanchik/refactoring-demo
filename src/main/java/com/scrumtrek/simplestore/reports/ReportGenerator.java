package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;

public interface ReportGenerator {

    String generateReport(Customer orderInfoDTO);
}
