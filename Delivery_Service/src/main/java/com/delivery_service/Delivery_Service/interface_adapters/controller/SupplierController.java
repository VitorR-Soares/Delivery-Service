package com.delivery_service.Delivery_Service.interface_adapters.controller;

import com.delivery_service.Delivery_Service.application.dto.CreateSupplierDTO;
import com.delivery_service.Delivery_Service.application.dto.ResponseSupplierDTO;
import com.delivery_service.Delivery_Service.application.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/createSupplier")
    public ResponseSupplierDTO createSupplier(@RequestBody @Valid CreateSupplierDTO createSupplierDTO){

        var response = supplierService.save(createSupplierDTO);

        return response;

    }

    @GetMapping("/findSupplier/{id}")
    public ResponseSupplierDTO searchSupplier(@PathVariable("id") String id){

        var response = supplierService.findById(id);

        return response;
    }
}
