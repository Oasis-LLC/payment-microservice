package com.oasis.microservice.payment.repository;

import com.oasis.microservice.payment.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CreditCardRepository extends JpaRepository<CreditCard, UUID> {
    List<CreditCard> findByUserId(String userId);
}
