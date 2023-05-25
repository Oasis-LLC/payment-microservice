package com.oasis.microservice.payment.controller;

import com.oasis.microservice.payment.contract.CreditCardResponse;
import com.oasis.microservice.payment.domain.CreditCard;
import com.oasis.microservice.payment.service.CreditCardService;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CreditCardController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    CreditCardService creditCardService;

    @GetMapping
    public List<CreditCard> findAll() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<?> findAllById(@PathVariable String cardId) {
        UUID uuid = UUID.fromString(cardId);
        Optional<CreditCard> card = creditCardService.getCreditCardById(uuid);

        if (card.isPresent()) {
            return new ResponseEntity<CreditCard>(card.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCard(@RequestBody CreditCard card) {
        CreditCard save = creditCardService.save(card);
        return new ResponseEntity<CreditCard>(save, HttpStatus.CREATED);
    }

    @PutMapping("/update/{cardId}")
    public ResponseEntity<?> updateCard(@PathVariable String cardId, @RequestBody CreditCard card) {
        UUID uuid = UUID.fromString(cardId);
        Optional<CreditCard> cardData = creditCardService.getCreditCardById(uuid);

        if (cardData.isPresent()) {
            CreditCard _card = cardData.get();
            _card.setCardNumber(card.getCardNumber());
            _card.setExpirationDate(card.getExpirationDate());
            _card.setNameOnCard(card.getNameOnCard());
            _card.setSecurityCode(card.getSecurityCode());
            return new ResponseEntity<>(creditCardService.save(_card), HttpStatus.OK);
        }

        return new ResponseEntity<>(cardData.get(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserCreditCards(@PathVariable String userId) {
        List<CreditCard> cards = creditCardService.getCreditCardsByUserId(userId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseEntity<?> deleteCard(@PathVariable String cardId) {
        UUID uuid = UUID.fromString(cardId);
        Optional<CreditCard> card = creditCardService.getCreditCardById(uuid);

        if (card.isPresent()) {
            creditCardService.deleteCreditCardById(uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}




