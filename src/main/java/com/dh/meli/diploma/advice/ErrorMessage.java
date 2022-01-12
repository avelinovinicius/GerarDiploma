package com.dh.meli.diploma.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class ErrorMessage {
    private String httpStatus;
    private int errorCode;
    private String message;
    private Map<String, String> errors;


    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus.name();
        this.errorCode = httpStatus.value();
        this.message = message;
    }

    public ErrorMessage(HttpStatus httpStatus, String message, Map<String, String>errorMap)
    {
        this(httpStatus, message);
        this.errors = errorMap;
    }

}
