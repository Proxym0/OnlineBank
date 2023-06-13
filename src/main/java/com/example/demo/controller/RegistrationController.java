package com.example.demo.controller;


import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.security.JWTTokenProvider;
import com.example.demo.service.ExchangeRatesClient;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.service.UserService.bCryptPasswordEncoder;


@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

//    @Autowired
//    private ExchangeRatesClient client;

    @PostMapping
    public ResponseEntity<User> registration(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDTO dto) {
        User user = userService.findByUsername(dto.getUsername());
        String token = jwtTokenProvider.generateToken(dto.getUsername(), user.getRoles());
        if (bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

//    @GetMapping("/test")
//    public void test() {
//        System.out.println(client.getRates());
//    }
}



