package com.example.demo.controller;

import com.example.demo.dto.TransferOperationDTO;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rem")
public class OperationController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<TransferOperationDTO> remittance(@RequestBody TransferOperationDTO transferOperationDTO){
        TransferOperationDTO transferOperationDTO1 = cardService.transferAmount(transferOperationDTO).getBody();
        return ResponseEntity.ok(transferOperationDTO1);

    }
}
