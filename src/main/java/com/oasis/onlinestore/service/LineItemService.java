package com.oasis.onlinestore.service;

import com.oasis.onlinestore.domain.LineItem;
import com.oasis.onlinestore.repository.LineItemRepo;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class LineItemService {
    @Autowired
    private LineItemRepo lineItemRepository;

    public LineItem createLineItem(LineItem lineItem) {
        //  create a new LineItem and save it to the database
        return lineItemRepository.save(lineItem);
    }

    public LineItem getLineItemById(UUID id) {
        //  get a LineItem by id
        return lineItemRepository.findById(id).orElse(null);
    }

    public LineItem updateLineItem(LineItem lineItem) {
        //  update an existing LineItem and save the changes to the database
        return lineItemRepository.save(lineItem);
    }

    public void deleteLineItem(UUID id) {
        //  delete a LineItem by id
        lineItemRepository.deleteById(id);
    }
    public List<LineItem> getAllLineItems() {
        // retrieve all LineItems from the database
        return lineItemRepository.findAll();
    }

//    public List<LineItem> getLineItemsByOrderId(Long orderId) {
//        //retrieve all LineItems associated with a specific order from the database
//        return lineItemRepository.findByOrderId(orderId);
//    }

}
