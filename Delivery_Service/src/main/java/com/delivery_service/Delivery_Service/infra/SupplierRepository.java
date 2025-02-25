package com.delivery_service.Delivery_Service.infra;

import com.delivery_service.Delivery_Service.core.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface SupplierRepository  extends JpaRepository<Supplier, Long> {

    @Query("""
            SELECT s FROM Supplier s
            WHERE ST_CONTAINS(f.coverageArea, ST_GeoFromText(:location, 4326))
            ORDER BY ST_DistanceSphere(f.address, ST_GeoFromText(:location, 4326))
            LIMIT 1
            """
    )
    public Supplier findNearestSupplier(@Param("location") String location);





}
