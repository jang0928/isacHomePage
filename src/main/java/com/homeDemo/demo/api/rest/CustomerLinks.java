package com.homeDemo.demo.api;

import com.mashape.unirest.http.HttpResponse;

public class CustomerLinks {
    public static CustomerLink[] list(RestClient rest, long customerId) throws Exception {
        HttpResponse<String> response =
                rest.get("/customer-links", customerId)
                        .asString();

        return rest.asObject(response, CustomerLink[].class);
    }

    public static CustomerLink[] list(RestClient rest, long customerId, String type) throws Exception {
        HttpResponse<String> response =
                rest.get("/customer-links", customerId)
                        .queryString("type", type)
                        .asString();

        return rest.asObject(response, CustomerLink[].class);
    }
}
