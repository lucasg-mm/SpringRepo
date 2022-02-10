package com.luv2code.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    // exception code here

    // add an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        // create a student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return Response Entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){

        // create a student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return Response Entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
