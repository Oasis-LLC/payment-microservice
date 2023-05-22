package com.oasis.onlinestore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
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
    private Customer buyer;



    public Review() {

    }


}
