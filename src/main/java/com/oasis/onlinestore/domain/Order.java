package com.oasis.onlinestore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Customer customer;
    private Address shippingAddress;
    private List<LineItem> lineItems = new ArrayList<>();
    @Enumerated
    private Status status;

    public boolean isEditable() {
        return status == Status.PLACED;
    }



}
