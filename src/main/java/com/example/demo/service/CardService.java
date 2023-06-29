package com.example.demo.service;

import ch.qos.logback.classic.Logger;
import com.example.demo.controller.DBException;
import com.example.demo.controller.MoneyException;
import com.example.demo.dao.CardRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CardDTO;
import com.example.demo.dto.TransferOperationDTO;
import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional

public class CardService {
    private Logger log = (Logger) LoggerFactory.getLogger(CardService.class);
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    private static CardDTO mappingToDTO(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .number(card.getNumber())
                .cvv(card.getCvv())
                .expireDate(card.getExpireDate())
                .userId(card.getUser().getId())
                .balance(card.getBalance())
                .build();
    }

    private static Card mappingToEntity(CardDTO cardDTO) {
        return Card.builder()
                .number(cardDTO.getNumber())
                .cvv(cardDTO.getCvv())
                .expireDate(cardDTO.getExpireDate())
                .user(User.builder()
                        .id(cardDTO.getUserId())
                        .build())
                .balance(0)
                .build();
    }

    public CardDTO save(CardDTO cardDTO) {
        try {
            Card card = mappingToEntity(cardDTO);
            Card savedCard = cardRepository.save(card);
            return mappingToDTO(savedCard);
        } catch (DataIntegrityViolationException e) {
            log.warn("This number already exists", e);
            throw new DBException("This number already exists");
//        }catch (JDBCException ex){
//            log.warn("Unexpected error",ex);
//            throw new DBException("Unexpected error");
        }
    }

    public ResponseEntity<TransferOperationDTO> transferAmount(TransferOperationDTO transferOperationDTO) {
        Optional<Card> byNumber1 = cardRepository.findByNumber(transferOperationDTO.getSender());
        Card card1 = byNumber1.get();
        if (card1.getBalance() < transferOperationDTO.getTransferAmount()) {
            throw new MoneyException("Not enough money in the account.");
        }
        card1.setBalance(card1.getBalance() - transferOperationDTO.getTransferAmount());
        Optional<Card> byNumber2 = cardRepository.findByNumber(transferOperationDTO.getRecipient());
        Card card2 = byNumber2.get();
        card2.setBalance(card2.getBalance() + transferOperationDTO.getTransferAmount());
        cardRepository.save(card1);
        cardRepository.save(card2);
        return ResponseEntity.ok().build();
    }

    public Card save(String username, Card card) {
        Optional<User> byId = userRepository.findByUsername(username);
        if (byId.isPresent()) {
            User user = byId.get();
            card.setUser(user);
        }
        return cardRepository.save(card);
    }

    public Card findByNumber(String number) {
        Optional<Card> byNumberCard = cardRepository.findByNumber(number);
        if (byNumberCard.isPresent()) {
            return byNumberCard.get();
        }
        throw new RuntimeException();
    }
}
