package com.delivery_service.Delivery_Service.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateSupplierDTO(
        @NotNull String tradingName,
        @NotNull String ownerName,
        @NotNull @Valid String document,
        @NotNull GeoMultiPolygonDTO coverageArea,
        @NotNull GeoPointDTO address
        ) {
}
