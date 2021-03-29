package com.dwolla.interview.demo.services;

import com.dwolla.interview.demo.dto.WeatherResponseDTO.ResponseDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${cityNameAPI}")
    private String weatherByName;

    @Value("${cityIdAPI}")
    private String weatherById;

    @Override
    public ResponseDTO getCityWeatherByName(String name) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String url = getWeatherByNameAPI(name);
        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    private String getWeatherByNameAPI(String name) {
        return baseUrl + weatherByName + name;
    }
    
}
