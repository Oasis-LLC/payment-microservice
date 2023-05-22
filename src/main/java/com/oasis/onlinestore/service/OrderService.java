package com.oasis.onlinestore.service;

import com.oasis.onlinestore.domain.Order;
import com.oasis.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(UUID orderID){
        if(orderRepository.findById(orderID).isPresent()) {
            return orderRepository.findById(orderID);
        }else{
            return null;
        }

    }
}
