package com.oasis.onlinestore.service;

import com.oasis.onlinestore.domain.OrderLine;
import com.oasis.onlinestore.repository.OrderLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class OrderLineService {
    @Autowired
    private OrderLineRepo orderLineRepository;

    public OrderLine createLineItem(OrderLine orderLine) {
        //  create a new LineItem and save it to the database
        return orderLineRepository.save(orderLine);
    }

    public OrderLine getLineItemById(UUID id) {
        //  get a LineItem by id
        return orderLineRepository.findById(id).orElse(null);
    }

    public OrderLine updateLineItem(OrderLine orderLine) {
        //  update an existing LineItem and save the changes to the database
        return orderLineRepository.save(orderLine);
    }

    public void deleteLineItem(UUID id) {
        //  delete a LineItem by id
        orderLineRepository.deleteById(id);
    }
    public List<OrderLine> getAllLineItems() {
        // retrieve all LineItems from the database
        return orderLineRepository.findAll();
    }

//    public List<LineItem> getLineItemsByOrderId(Long orderId) {
//        //retrieve all LineItems associated with a specific order from the database
//        return lineItemRepository.findByOrderId(orderId);
//    }

}
