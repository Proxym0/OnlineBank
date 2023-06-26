package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferOperationDTO {
    private String sender;
    private String recipient;
    private int transferAmount;
}
