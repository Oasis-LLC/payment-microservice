package com.oasis.microservice.payment.controller;

import com.oasis.microservice.payment.domain.CreditCard;
import com.oasis.microservice.payment.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CreditCardController {
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
}




