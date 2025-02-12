package com.delivery_service.Delivery_Service.core.use_cases;

import com.delivery_service.Delivery_Service.application.dto.CoordinatesDTO;
import com.delivery_service.Delivery_Service.application.dto.CreateSupplierDTO;
import com.delivery_service.Delivery_Service.application.dto.ResponseSupplierDTO;
import com.delivery_service.Delivery_Service.application.dto.SupplierCreatedDTO;
import com.delivery_service.Delivery_Service.core.domain.Supplier;

import java.util.Optional;

public interface SupplierUseCases {
    public Optional<SupplierCreatedDTO> findById(String id);
    public Optional<ResponseSupplierDTO> save(CreateSupplierDTO dto);
    public Optional<ResponseSupplierDTO> findNearestSupplier(CoordinatesDTO dto);
}
