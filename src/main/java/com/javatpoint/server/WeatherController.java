package com.javatpoint.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final OpenMeteoService openMeteoService;

    @Autowired
    public WeatherController(OpenMeteoService openMeteoService) {
        this.openMeteoService = openMeteoService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam double latitude, @RequestParam double longitude) {
        return openMeteoService.getWeatherForecast(latitude, longitude);
    }
}