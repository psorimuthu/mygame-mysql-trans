package com.pad.mysql.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> ProductExceptionHandler(){
        return new ResponseEntity<>("Product Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=TransExceptionTutorial.class)
    public ResponseEntity<Object> TransExceptionTutorial(){
        return new ResponseEntity<>("Trying transaction exception", HttpStatus.NOT_FOUND);
    }

}