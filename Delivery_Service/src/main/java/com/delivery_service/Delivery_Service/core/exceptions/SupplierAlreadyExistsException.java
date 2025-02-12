package com.delivery_service.Delivery_Service.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SupplierAlreadyExistsException extends ZeDeliveryException{

    @Override
    public ProblemDetail toProblemDetail(){

        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Suppler already exists");
        pd.setDetail("A supplier has already been registered with this information");

        return pd;
    }

}
