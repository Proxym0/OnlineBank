package com.example.demo.controller;

import com.example.demo.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MoneyException.class)
    public ResponseEntity<ErrorResponseDTO> err(MoneyException exception) {
        ErrorResponseDTO errorResponseDTO= ErrorResponseDTO.builder()
                .message(exception.getMessage())
                .details(exception.toString())
                .build();
        return ResponseEntity.badRequest().body(errorResponseDTO);
    }
    @ExceptionHandler(DBException.class)
    public ResponseEntity<ErrorResponseDTO> error(DBException e) {
        ErrorResponseDTO errorResponseDTO= ErrorResponseDTO.builder()
                .message(e.getMessage())
                .details(e.toString())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDTO);
    }
}
