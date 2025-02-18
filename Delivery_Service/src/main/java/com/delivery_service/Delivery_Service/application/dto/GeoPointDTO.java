package com.delivery_service.Delivery_Service.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GeoPointDTO(
        String type,
        @JsonProperty("coordinates")
        List<Double> coordinates
) {
    public GeoPointDTO(List<Double> coordinates) {
        this("Point", coordinates); // Definir o tipo automaticamente
    }
}
