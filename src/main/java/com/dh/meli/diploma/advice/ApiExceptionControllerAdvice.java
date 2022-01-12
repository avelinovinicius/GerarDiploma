package com.dh.meli.diploma.advice;

import com.dh.meli.diploma.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.swing.plaf.nimbus.NimbusStyle;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @Autowired
    private MessageSource messageSource;
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    //@ExceptionHandler(BusinessException.class)
    //public ResponseEntity<Object> handlerBusinessException(RuntimeException runtimeException)
    //{
    //   String bodyOfResponse = runtimeException.getMessage();
    //  return ResponseEntity.badRequest().body("Deu erro aqui");
    //}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException(RuntimeException runtimeException) {
        BusinessException businessException = (BusinessException) runtimeException;
        HttpStatus httpStatus = businessException.getStatus();
        return new ResponseEntity(new ErrorMessage(httpStatus, businessException.getMessage()), httpStatus);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException() {
        return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND, "ALUNO NÃO ENCONTRADO"), HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException(IndexOutOfBoundsException indexOutOfBoundsException) {
        return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_FOUND, "ALUNO NÃO ENCONTRADO"), HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(value = MethodArgumentNotValidException.class)
     public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
         Map<String, String> errors = new HashMap<>();
         exception.getBindingResult().getAllErrors().forEach((error) -> {
             String fieldName = ((FieldError) error).getField();
             String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
             errors.put(fieldName, errorMessage);
         });
         return new ResponseEntity(new ErrorMessage(HttpStatus.BAD_REQUEST, "ERRO AO CADASTRAR, FAVOR REVISAR OS DADOS INSERIDOS", errors), HttpStatus.BAD_REQUEST);
 }
   // @ExceptionHandler(MethodArgumentNotValidException.class)
    //public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException() {
      //  return new ResponseEntity(new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, "ERRO AO CADASTRAR, FAVOR REVISAR OS DADOS INSERIDOS"), HttpStatus.NOT_ACCEPTABLE);
    //}
}
