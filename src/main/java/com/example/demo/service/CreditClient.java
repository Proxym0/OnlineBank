package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class CreditClient {
    @Autowired
    private RestTemplate restTemplate;

    public List<Map<String, String>> getCredit(){
        ResponseEntity<List> forEntity= restTemplate.getForEntity("https://belarusbank.by/api/kredits_info",
                    List.class,Map.of("credit","потребительский"));
        return  ((List<Map<String,String>>) forEntity.getBody());
    }
}
