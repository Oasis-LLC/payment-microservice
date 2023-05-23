package com.oasis.onlinestore.controller;

import com.oasis.onlinestore.domain.Item;
import com.oasis.onlinestore.domain.LineItem;
import com.oasis.onlinestore.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/lineitems")
public class ItemLineController {
    @Autowired
    private LineItemService lineItemService;

    @PostMapping
    public LineItem createLineItem(@RequestBody LineItem lineItem, @RequestParam long itemId) {
        //  create a new LineItem and save it to the database
        return lineItemService.createLineItem(lineItem);
    }
    @GetMapping("/lineitem/{id}")
    public LineItem getLineItemById(@PathVariable long id) {
        //  get a LineItem by id
        return lineItemService.getLineItemById(UUID.randomUUID());
    }

    @GetMapping
    public Iterable<LineItem> getAllLineItems() {
        // retrieve all LineItems from the database
        return lineItemService.getAllLineItems();
    }
    @DeleteMapping("/lineitem/{id}") //  delete a LineItem by id
    public void deleteLineItem(@PathVariable UUID lineItemId) {
        LineItem lineItem = lineItemService.getLineItemById(lineItemId);
        if (lineItem == null) {
            throw new RuntimeException("LineItem not found - " + lineItemId);
        }
        lineItemService.deleteLineItem(UUID.randomUUID());
    }
    @PutMapping("/lineitem/{id}")
    public LineItem updateLineItem(@RequestBody LineItem lineItem, @PathVariable UUID lineItemId) {
        LineItem existingLineItem = lineItemService.getLineItemById(lineItemId);
        if (existingLineItem == null) {
            throw new RuntimeException("LineItem not found - " + lineItemId);
        }
        return lineItemService.updateLineItem(lineItem);
    }

}
