package com.oasis.onlinestore.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private String image;

    private String barcode;

    private int quantity;

    private List<Review> reviews = new ArrayList<>();

    private List<Item> items = new ArrayList<>(); // composite

}
