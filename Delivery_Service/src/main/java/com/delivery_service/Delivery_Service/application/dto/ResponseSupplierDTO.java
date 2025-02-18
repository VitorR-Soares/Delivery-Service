package com.delivery_service.Delivery_Service.application.dto;

public record ResponseSupplierDTO(
        Long id,
        String tradingName,
        String ownerName,
        String document
) {
}
