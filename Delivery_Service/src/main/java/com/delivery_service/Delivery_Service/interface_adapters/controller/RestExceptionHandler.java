package com.delivery_service.Delivery_Service.interface_adapters.controller;

import com.delivery_service.Delivery_Service.core.exceptions.ZeDeliveryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.zip.ZipException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ZeDeliveryException.class)
    public ProblemDetail handleZeDeliveryException(ZeDeliveryException ex){

        return ex.toProblemDetail();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        var inavlid_fields = exception.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();
        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Invalid params");
        pd.setDetail("Your Params didn't validate");
        pd.setProperty("invalid_params", inavlid_fields);

        return pd;

    }

    private record InvalidParam(String name, String reason){};
}
