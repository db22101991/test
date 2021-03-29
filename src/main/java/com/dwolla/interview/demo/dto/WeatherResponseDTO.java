package com.dwolla.interview.demo.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class WeatherResponseDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CoordinatesDTO {
        private float lon;
        private float lat;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeatherDTO {
        private long id;
        private String main;
        private String description;
        private String icon;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainDTO {
    
        private float temp;
        @JsonProperty("feels_like")
        private float feelsLike;
        @JsonProperty("temp_min")
        private float tempMin;
        @JsonProperty("temp_max")
        private float tempMax;
        private float pressure;
        private float humidity;
        @JsonProperty("sea_level")
        private float seaLevelPressure;
        @JsonProperty("grnd_level")
        private float groundLevelPressure;
    }
    

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WindDTO {
        private float speed;
        private float deg;
        private float gust;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CloudDTO {
        private float all;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RainDTO {
        @JsonProperty("1h")
        private float oneHour;
        @JsonProperty("3h")
        private float threeHours;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SnowDTO {
        @JsonProperty("1h")
        private float oneHour;
        @JsonProperty("3h")
        private float threeHours;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SystemDTO {
        private long type;
        private long id;
        private double message;
        private String country;
        private Instant sunrise;
        private Instant sunset;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ResponseDTO {
        private CoordinatesDTO coord;
        private List<WeatherDTO> weather;
        private String base;
        private MainDTO main;
        private long visibility;
        private WindDTO wind;
        private CloudDTO clouds;
        private RainDTO rain;
        private SnowDTO snow;
        private Instant dt;
        private SystemDTO sys;
        private long timezone;
        private long id;
        private String name;
        private long cod;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeatherApiResponseDTO {
        boolean success;
        String response;
    }



}
