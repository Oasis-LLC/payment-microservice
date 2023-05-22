package com.oasis.onlinestore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private String image;

    private String barcode;

    private int quantity;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemId")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BundleItem",
            joinColumns = { @JoinColumn(name = "itemId", referencedColumnName = "id")},
            inverseJoinColumns =  { @JoinColumn(name = "subItemId", referencedColumnName = "id")}
    )
    private List<Item> items = new ArrayList<>(); // composite

}
