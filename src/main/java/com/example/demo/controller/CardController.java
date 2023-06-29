package com.example.demo.controller;

import com.example.demo.dto.CardDTO;
import com.example.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<CardDTO> saveCard(@RequestBody CardDTO cardDTO){
        CardDTO save = cardService.save(cardDTO);
        return ResponseEntity.ok(save);
    }

//    @PostMapping
//    public ResponseEntity<CardDTO> saveCard(@AuthenticationPrincipal UserDetails userDetails,
//                                         @RequestBody CardDTO cardDTO) {
//        cardService.save(userDetails.getUsername(), Card.builder()
//                        .number(cardDTO.getNumber())
//                        .cvv(cardDTO.getCvv())
//                        .build());
//        return ResponseEntity.ok(cardDTO);
//    }

//    private CardDTO toDTO(CardDTO cardDTO) {
//
//        return CardDTO.builder()
//                .number(cardDTO.getNumber())
//                .cvv(cardDTO.getCvv())
//                .user(toUserDTO(card.getUser()))
//                .build();
//    }
//
//    private User toUserDTO(User user) {
//        return User.builder()
//                .id((int) user.getId())
//                .build();
//    }
//    @GetMapping("/home/my_card")
//    public ResponseEntity<String> myCard () {
//cardService.findByNumberCard()
//
//
//        @GetMapping("/rates")
//        public Map<String, String> ratesMap() {
//            Map<String, String> rates = client.getRates().get(0);
//            return rates;
//        }
//    }
}
