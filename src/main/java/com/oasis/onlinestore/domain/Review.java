package com.oasis.onlinestore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int numberOfStars;
    private String title;
    private String date;
    private String description;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customerId")
    private User buyer;

    public Review() {

    }


}
