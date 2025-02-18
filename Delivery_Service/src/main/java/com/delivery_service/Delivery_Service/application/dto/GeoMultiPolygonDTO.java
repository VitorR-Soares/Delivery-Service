package com.delivery_service.Delivery_Service.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GeoMultiPolygonDTO(
        String type,
        @JsonProperty("coordinates")
        List<List<List<List<Double>>>> coordinates
) {
    public GeoMultiPolygonDTO(List<List<List<List<Double>>>> coordinates) {
        this("MultiPolygon", coordinates); // Definir o tipo automaticamente
    }
}
