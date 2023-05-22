package com.oasis.onlinestore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String city;
    private String street;
    private String state;
    @Enumerated
    private AddressType addressType;

    public Address(){}

    public Address(String city, String street, String state, AddressType addressType) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.addressType = addressType;
    }
}
