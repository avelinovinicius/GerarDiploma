package com.dh.meli.diploma.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus status = null;
    private Object data = null;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(HttpStatus status, String message) {
        this(message);
        this.status = status;
    }

    public BusinessException(HttpStatus status, String message, Object data) {
        this(status, message);
        this.data = data;
    }
}
