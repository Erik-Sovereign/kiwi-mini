package com.kiwimini.applicationsapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThingsApiService {
    private final RestTemplate restTemplate;
    private final String thingsApiBaseUrl;

    public ThingsApiService(RestTemplate restTemplate,
            @Value("${things-api.base-url}") String thingsApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.thingsApiBaseUrl = thingsApiBaseUrl;
    }
}
