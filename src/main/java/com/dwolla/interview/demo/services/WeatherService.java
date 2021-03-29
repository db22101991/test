package com.dwolla.interview.demo.services;

import com.dwolla.interview.demo.dto.WeatherResponseDTO.ResponseDTO;

public interface WeatherService {
    
    public ResponseDTO getCityWeatherByName(String name) throws Exception;
}
