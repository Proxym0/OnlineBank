package com.example.demo.controller;

import com.example.demo.service.ExchangeRatesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ExchangeRatesClient client;
    @GetMapping()
    public void test() {
        System.out.println(client.getRates());
    }
}
