package com.oasis.onlinestore.controller;

import com.oasis.onlinestore.domain.Order;
import com.oasis.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public List<Order> findAll(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<?> findAllById(@PathVariable String orderId){
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> order = orderService.getOrderById(uuid);
        if (order.isPresent()) {
            return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
