package com.delivery_service.Delivery_Service.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "tb_suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "supplier_id")
    private Long supplierId;

    @Column(name = "trading_name")
    private String tradingName;

    @Column(name = "owner_name")
    private String ownerName;

    @Pattern(
            regexp = "\\d{14}/\\d{4}",
            message = "Document must follow the pattern: 1432132123891/0001"
    )
    @Column(name = "document", unique = true)
    private String document;

    @Column(columnDefinition = "POINT SRID 4326", name = "address")
    private Point addresss;

    @Column(columnDefinition = "MULTIPOLYGON SRID 4326", name = "coverage_area")
    private MultiPolygon coverageArea;

    public Supplier() {
    }

    public Supplier(Long supplierId, String tradingName, String ownerName, String document, Point addresss, MultiPolygon coverageArea) {
        this.supplierId = supplierId;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.addresss = addresss;
        this.coverageArea = coverageArea;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public @Pattern(
            regexp = "\\d{14}/\\d{4}",
            message = "O documento deve seguir o formato: 1432132123891/0001"
    ) String getDocument() {
        return document;
    }

    public void setDocument(@Pattern(
            regexp = "\\d{14}/\\d{4}",
            message = "O documento deve seguir o formato: 1432132123891/0001"
    ) String document) {
        this.document = document;
    }

    public Point getAddresss() {
        return addresss;
    }

    public void setAddresss(Point addresss) {
        this.addresss = addresss;
    }

    public MultiPolygon getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(MultiPolygon coverageArea) {
        this.coverageArea = coverageArea;
    }
}
