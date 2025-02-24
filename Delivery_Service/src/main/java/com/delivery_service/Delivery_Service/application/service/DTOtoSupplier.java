package com.delivery_service.Delivery_Service.application.service;

import com.delivery_service.Delivery_Service.application.dto.CreateSupplierDTO;
import com.delivery_service.Delivery_Service.core.domain.Supplier;
import com.delivery_service.Delivery_Service.core.exceptions.ZeDeliveryException;
import org.locationtech.jts.geom.*;

import java.util.List;

public class DTOtoSupplier {

    private static final GeometryFactory geometryFactory = new GeometryFactory();

    public static Supplier toEntity(CreateSupplierDTO dto){

        Point address = createPoint(dto.address().coordinates());
        address.setSRID(4326);
        MultiPolygon coverageArea = createMultiPolygon(dto.coverageArea().coordinates());
        coverageArea.setSRID(4326);

        Supplier supplier = new Supplier();
        supplier.setTradingName(dto.tradingName());
        supplier.setOwnerName(dto.ownerName());
        String regex = "^\\d{13}[/]\\d{4}";
        if(!dto.document().matches(regex)){
            throw new ZeDeliveryException();
        }
        supplier.setDocument(dto.document());
        supplier.setCoverageArea(coverageArea);
        supplier.setAddresss(address);


        return supplier;

    }


    private static Point createPoint(List<Double> coordinates) {
        Coordinate coord = new Coordinate(coordinates.get(0), coordinates.get(1));
        return geometryFactory.createPoint(coord);
    }

    private static MultiPolygon createMultiPolygon(List<List<List<List<Double>>>> coordinates) {
        Polygon[] polygons = coordinates.stream()
                .map(DTOtoSupplier::createPolygon)
                .toArray(Polygon[]::new);

        return geometryFactory.createMultiPolygon(polygons);
    }

    private static Polygon createPolygon(List<List<List<Double>>> polygonCoords) {
        LinearRing shell = createLinearRing(polygonCoords.get(0));
        LinearRing[] holes = polygonCoords.subList(1, polygonCoords.size()).stream()
                .map(DTOtoSupplier::createLinearRing)
                .toArray(LinearRing[]::new);

        return geometryFactory.createPolygon(shell, holes);
    }

    private static LinearRing createLinearRing(List<List<Double>> coordinates) {
        Coordinate[] coords = coordinates.stream()
                .map(coord -> new Coordinate(coord.get(0), coord.get(1)))
                .toArray(Coordinate[]::new);

        return geometryFactory.createLinearRing(coords);
    }

}
