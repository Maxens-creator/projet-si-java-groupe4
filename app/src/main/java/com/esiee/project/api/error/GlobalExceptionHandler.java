package com.esiee.project.api.error;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.esiee.project.domain.exception.BusinessRuleException;
import com.esiee.project.domain.exception.InvalidDataException;
import com.esiee.project.domain.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {

        List<FieldErrorDetail> details = ex.getBindingResult().getFieldErrors().stream()
            .map(err -> new FieldErrorDetail(err.getField(), err.getDefaultMessage()))
            .collect(Collectors.toList());

        ErrorResponse body = new ErrorResponse(
            Instant.now(),
            400,
            "VALIDATION_ERROR",
            "La requête est invalide",
            req.getRequestURI(),
            details
        );

        return ResponseEntity.status(400).body(body);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
        return ResponseEntity.status(404).body(
            new ErrorResponse(Instant.now(), 404, "NOT_FOUND", ex.getMessage(), req.getRequestURI(), List.of())
        );
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(InvalidDataException ex, HttpServletRequest req) {
        return ResponseEntity.status(400).body(
            new ErrorResponse(Instant.now(), 400, "INVALID_DATA", ex.getMessage(), req.getRequestURI(), List.of())
        );
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(BusinessRuleException ex, HttpServletRequest req) {
        return ResponseEntity.status(409).body(
            new ErrorResponse(Instant.now(), 409, "BUSINESS_RULE_VIOLATION", ex.getMessage(), req.getRequestURI(), List.of())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest req) {
        return ResponseEntity.status(500).body(
            new ErrorResponse(Instant.now(), 500, "INTERNAL_ERROR", "Erreur interne", req.getRequestURI(), List.of())
        );
    }
}
