package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.OrderInfoDTO;

public interface ReportGenerator {

    String generateReport(OrderInfoDTO orderInfoDTO);
}
