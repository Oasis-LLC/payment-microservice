package com.oasis.microservice.payment.contract;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreditCardResponse {
    private String id;
    private String cardHolderName;
    private String cardNumber;
}
