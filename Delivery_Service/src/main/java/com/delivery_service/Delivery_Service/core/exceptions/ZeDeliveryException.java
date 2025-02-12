package com.delivery_service.Delivery_Service.core.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ZeDeliveryException extends RuntimeException {

    public ProblemDetail toProblemDetail(){

        var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("Ze Delivery Application Internal Server Error");

        return pd;
    }
}
