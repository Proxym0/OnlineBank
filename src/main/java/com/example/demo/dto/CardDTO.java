package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Builder
public class CardDTO {

    private long id;
    private String number;
    private String cvv;
    private long userId;
    private String expireDate;
    private int balance;
}
