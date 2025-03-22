package com.gowri.quartz.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private final RestTemplate restTemplate;

    // API key for the weather service
    @Value("${weather.api.key}")
    private String apiKey;

    // Base URL for the OpenWeatherMap API (you can change it to any weather API service)
    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    // Constructor injection for RestTemplate
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String testEndPoint() {
        log.info("Accessing EndPoint using CRON:: {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")));
        return "SERVICE::UP";
    }

    @GetMapping("/weather/{city}")
    public String getWeatherReport(@PathVariable String city) {
        log.info("Fetching weather for city: {}", city);

        // Construct the URL for the weather API
        String url = WEATHER_API_URL;

        // Make the API request
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, city, apiKey);

        // Return the response as-is for now, or you can parse the response to extract specific data
        return response.getBody();
    }
}
