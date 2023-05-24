package com.oasis.microservice.payment.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String cardNumber;
    @Column(name = "expDate")
    private int expirationDate;
    private String nameOnCard;
    private int securityCode;
    private String userId;

    public CreditCard() {}
}


// Example credit card JSON:
// {
//     "cardNumber": "1234567890123456",
//     "expirationDate": 1221,
//     "nameOnCard": "John Doe",
//     "securityCode": 123
//     "userId": "12345678-1234-1234-1234-123456789012"
// }

// Another example credit card JSON:
// {
//     "cardNumber": "1334567890123456",
//     "expirationDate": 1221,
//     "nameOnCard": "Jane Doe",
//     "securityCode": 123
//     "userId": "12345678-1234-1234-1234-1d2gg456789012"
// }