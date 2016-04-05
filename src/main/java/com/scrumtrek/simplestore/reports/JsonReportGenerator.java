package com.scrumtrek.simplestore.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scrumtrek.simplestore.OrderInfoDTO;

public class JsonReportGenerator implements ReportGenerator {

    @Override
    public String generateReport(OrderInfoDTO orderInfoDTO) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(orderInfoDTO);
    }
}
