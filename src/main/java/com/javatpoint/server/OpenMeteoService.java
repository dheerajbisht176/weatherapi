package com.javatpoint.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenMeteoService {

    @Value("${openmeteo.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public OpenMeteoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherForecast(double latitude, double longitude) {
        String url = apiUrl + "?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";

        // Make the HTTP GET request and return the response as a string
        return restTemplate.getForObject(url, String.class);
    }
}