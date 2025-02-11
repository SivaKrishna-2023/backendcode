package com.accesshr.emsbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFoundException e, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("message", e.getMessage());
        responseBody.put("details", request.getDescription(false));

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    // Handles ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("message", e.getMessage());
        responseBody.put("details", request.getDescription(false));

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    // Handles all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("message", "An internal error occurred");
        responseBody.put("details", request.getDescription(false));

        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
