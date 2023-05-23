package com.oasis.onlinestore.controller;

import com.oasis.onlinestore.domain.Item;
import com.oasis.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping
    ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = service.findAll();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @PostMapping(consumes = { "application/json"})
    ResponseEntity<?> saveItem(@RequestBody Item item) {
        try {
//            String imageContent = new String(image.getBytes(), StandardCharsets.UTF_8);
            service.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }

    @PostMapping("/{uuid}/saveImage")
    void saveImage(@PathVariable String path, MultipartFile file) throws Exception {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        service.setImage(path, content);
    }
}
