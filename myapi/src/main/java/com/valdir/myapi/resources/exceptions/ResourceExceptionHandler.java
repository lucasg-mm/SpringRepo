package com.valdir.myapi.resources.exceptions;

import com.valdir.myapi.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExcpetion.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcpetion e, HttpServletRequest req){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    };


}
