package com.homeDemo.demo.api;

import com.homeDemo.demo.api.model.StatReport;
import com.homeDemo.demo.api.rest.StatReports;

public class StatSample {


    public static void main(String[] args) throws Exception {
        String baseUrl = "https://api.searchad.naver.com";
        String apiKey = "010000000066ec70db7514980c3ee838fc6189dd52868d229775acc17201c115fbafda67d3"; // 액세스키
        String secretKey = "AQAAAABm7HDbdRSYDD7oOPxhid1ScHiiGA1Q8vKF87FQg6wsvQ==";  // 시크릿키
        long managerCustomerId = 3027373;  // ID
        RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);
        String reportType = "AD";
        String statDate = "20231201";

        // 리포트 요청 POST /stat-reports
        StatReport statReport = StatReports.create(rest, managerCustomerId, reportType, statDate);
        long reportJobId = statReport.getReportJobId();

        // 리포트 조회 GET /stat-reports/{reportJobId}
        StatReport singleStatReport = StatReports.get(rest, managerCustomerId, reportJobId);


    }


}
