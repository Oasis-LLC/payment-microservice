package com.oasis.onlinestore.service;

import com.oasis.onlinestore.domain.Item;
import com.oasis.onlinestore.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    public List<Item> findNameLike(String name) {
        return itemRepository.findByNameContaining(name);
    }

    public Optional<Item> findById(UUID id) {
        return itemRepository.findById(id);
    }

    public void setImage(String uuid, String imageByte) {

    }
}
