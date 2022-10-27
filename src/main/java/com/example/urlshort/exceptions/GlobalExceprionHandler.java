package com.example.urlshort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceprionHandler {
    @ExceptionHandler
    public ResponseEntity<?> catchRuntimeException(Exception e) {
        System.out.println("Hello");
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
