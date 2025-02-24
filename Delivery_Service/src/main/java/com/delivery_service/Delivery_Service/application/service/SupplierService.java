package com.delivery_service.Delivery_Service.application.service;

import com.delivery_service.Delivery_Service.application.dto.CreateSupplierDTO;
import com.delivery_service.Delivery_Service.application.dto.ResponseSupplierDTO;
import com.delivery_service.Delivery_Service.core.domain.Supplier;
import com.delivery_service.Delivery_Service.core.exceptions.SupplierAlreadyExistsException;
import com.delivery_service.Delivery_Service.core.exceptions.SupplierNotFoundException;
import com.delivery_service.Delivery_Service.infra.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public ResponseSupplierDTO save(CreateSupplierDTO dto){

        Supplier supplier = DTOtoSupplier.toEntity(dto);

        var supplierSaved = supplierRepository.save(supplier);

        var response = new ResponseSupplierDTO(supplierSaved.getSupplierId(),
                supplierSaved.getTradingName(),
                supplierSaved.getOwnerName(),
                supplierSaved.getDocument());

        return response;

    }

    @Transactional
    public ResponseSupplierDTO findById(String id){

        Optional<Supplier> supplier = supplierRepository.findById(Long.parseLong(id));

        if(supplier.isPresent()){
            var responseSupplierDTO = new ResponseSupplierDTO(supplier.get().getSupplierId(),
                    supplier.get().getTradingName(),
                    supplier.get().getOwnerName(),
                    supplier.get().getDocument());
            return responseSupplierDTO;
        } else {
            throw new SupplierNotFoundException();
        }

    }
}
