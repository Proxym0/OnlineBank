package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class ExchangeRatesClient {

    @Autowired
    private RestTemplate restTemplate;

   public List<Map<String, String>> getRates(){
       ResponseEntity<List> forEntity = restTemplate.getForEntity("https://belarusbank.by/api/kursExchange", List.class, Map.of("city", "Брест"));
       System.out.println(forEntity.getBody());
       return null;
   }
}
