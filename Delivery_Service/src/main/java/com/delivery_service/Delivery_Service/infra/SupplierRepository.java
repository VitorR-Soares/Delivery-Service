package com.delivery_service.Delivery_Service.infra;

import com.delivery_service.Delivery_Service.core.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface SupplierRepository  extends JpaRepository<Supplier, Long> {



}
