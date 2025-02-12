package com.delivery_service.Delivery_Service.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SupplierNotFoundException extends ZeDeliveryException{

    @Override
    public ProblemDetail toProblemDetail(){

        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pd.setTitle("Suppler wasn't found");
        pd.setDetail("Supplier not found with specified ID");

        return pd;
    }
}
