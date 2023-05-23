package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    List<Item> findAll();

    Optional<Item> findById(UUID uuid);

    List<Item> findByNameContaining(String keyword);
}
