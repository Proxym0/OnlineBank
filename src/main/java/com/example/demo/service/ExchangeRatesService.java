package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeRatesService {
    @Autowired
    private ExchangeRatesClient client;
//    @Autowired
//    private Vol vv;


//    public Map<String, String> rates() {
//        System.out.println(client.getRates());
//        Map<String, String> map = new HashMap<>();
//        client.getRates().forEach(item -> {
//            String key = item.get("name");
//            String value = item.get("USD_in");
//            map.put(key, value);
//        });
//        return map;
//    }
}


