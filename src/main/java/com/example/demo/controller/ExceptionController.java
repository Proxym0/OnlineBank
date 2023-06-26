package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MoneyException.class)
    public ResponseEntity<Map<String, String>> err(MoneyException exception) {
        Map<String, String> resp = new HashMap<>();
        resp.put("title", "Error");
        resp.put("code", HttpStatus.BAD_REQUEST.toString());
        resp.put("detail", exception.getMessage());
        return ResponseEntity.badRequest().body(resp);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, String>> error(SQLException exception) {
        Map<String, String> res = new HashMap<>();
        res.put("title", "Error");
        res.put("code", HttpStatus.BAD_REQUEST.toString());
        res.put("detail","This card number already exists.");
        return ResponseEntity.badRequest().body(res);
    }
}
