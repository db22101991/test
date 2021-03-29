package com.dwolla.interview.demo.controller;

import java.text.DecimalFormat;

import com.dwolla.interview.demo.dto.WeatherResponseDTO.ResponseDTO;
import com.dwolla.interview.demo.dto.WeatherResponseDTO.WeatherApiResponseDTO;
import com.dwolla.interview.demo.services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WeatherController {
    
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getCityWeather")
    public ResponseEntity getCityWeather(@RequestParam String name){
        try{
            ResponseDTO response = weatherService.getCityWeatherByName(name);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
        }   
    }

    @GetMapping("/getCityTemperature")
    public ResponseEntity<WeatherApiResponseDTO> getCityTemperature(@RequestParam String name){
        try{
            ResponseDTO response = weatherService.getCityWeatherByName(name);
            return ResponseEntity.ok(new WeatherApiResponseDTO(true, df.format(response.getMain().getTemp()) + " degree Fahrenheit"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new WeatherApiResponseDTO(false, e.toString()));
        }   
    }
}
