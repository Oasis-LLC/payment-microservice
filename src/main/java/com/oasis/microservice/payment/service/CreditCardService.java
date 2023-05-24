package com.oasis.microservice.payment.service;

import com.oasis.microservice.payment.domain.CreditCard;
import com.oasis.microservice.payment.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public Optional<CreditCard> getCreditCardById(UUID id) {
        return creditCardRepository.findById(id);
    }

    public Page<CreditCard> findAll(Pageable pageable) {
        return creditCardRepository.findAll(pageable);
    }

    public Optional<CreditCard> findById(UUID id) {
        return creditCardRepository.findById(id);
    }

    public CreditCard save(CreditCard Payment) {
        return creditCardRepository.save(Payment);
    }

    public void deleteById(UUID id) {
        creditCardRepository.deleteById(id);
    }
}
