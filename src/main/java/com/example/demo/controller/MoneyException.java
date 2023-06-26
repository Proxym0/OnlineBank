package com.example.demo.controller;

public class MoneyException extends RuntimeException {
    public MoneyException(String reason) {
        super(reason);
    }
}
