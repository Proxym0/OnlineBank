package com.example.demo.controller;

import com.example.demo.service.CreditClient;
import com.example.demo.service.ExchangeRatesClient;
import com.example.demo.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ExchangeRatesClient client;
    @Autowired
    private CreditClient creditClient;
    @GetMapping("/rates")
    public Map<String, String> ratesMap() {
        Map<String, String> rates = client.getRates().get(0);
        return rates;
    }
    @GetMapping("/credit")
    public Map<String, String> creditMap() {
        Map<String, String> credit = creditClient.getCredit().get(0);
        return credit;
    }
}
