package com.dwolla.interview.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@SpringBootTest
public class WeatherControllerTest {

    @Autowired
    private WeatherController weatherController;

    private static String validCityName = "New York";

    private static String invalidCityName = "abc";


    @Test
    public void getCityWeatherSuccessTest(){

        ResponseEntity response = this.weatherController.getCityWeather(validCityName);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getCityWeatherFailTest(){

        ResponseEntity response = this.weatherController.getCityWeather(invalidCityName);
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }


    @Test
    public void getCityTemperatureSuccessTest(){

        ResponseEntity response = this.weatherController.getCityTemperature(validCityName);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getCityTemperatureFailTest(){

        ResponseEntity response = this.weatherController.getCityTemperature(invalidCityName);
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }


}
