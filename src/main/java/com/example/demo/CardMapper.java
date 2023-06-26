package com.example.demo;

import com.example.demo.dto.CardDTO;
import com.example.demo.entity.Card;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.io.IOException;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface CardMapper {
    @Mapping(target = "userId", source = "user.id")
    CardDTO toDTO(Card card);
    @Mapping(target = "user.id",source = "userId")
    Card toEntity(CardDTO cardDTO);
}
