package com.oasis.microservice.payment.contract;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class CreditCardResponse {
    private UUID id;
}
