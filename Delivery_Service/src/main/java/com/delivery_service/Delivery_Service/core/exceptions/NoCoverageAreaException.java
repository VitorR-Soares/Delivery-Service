package com.delivery_service.Delivery_Service.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NoCoverageAreaException extends ZeDeliveryException{

    @Override
    public ProblemDetail toProblemDetail(){

        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Supplier not found for your location");
        pd.setDetail("No suppliers were found whose coverage area operates in your region");

        return pd;
    }

}
