package com.oasis.microservice.payment;

import com.oasis.microservice.payment.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication {
    @Autowired
    CreditCardRepository creditCardRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
