package com.bachatt_assignment.vehiclemanagement.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //validation error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    //constraint error
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDbErrors(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(
                "Database error: " + ex.getRootCause().getMessage(),
                HttpStatus.CONFLICT
        );
    }

    //external api error
    @ExceptionHandler(ExternalApiException.class)
    public ResponseEntity<String> handleExternal(ExternalApiException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    //fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAny(Exception ex) {
        return new ResponseEntity<>(
                "Internal error: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
