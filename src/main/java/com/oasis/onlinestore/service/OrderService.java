package com.oasis.onlinestore.service;

import com.oasis.onlinestore.domain.LineItem;
import com.oasis.onlinestore.domain.Order;
import com.oasis.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Optional<LineItem> addLineItem(UUID orderId, LineItem itemLine) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.addLineItem(itemLine);
            orderRepository.save(order);
            return Optional.of(itemLine);
        }
        return Optional.empty();
    }

    public void removeLineItem(UUID orderId, UUID lineId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.removeLineItem(lineId);
            orderRepository.save(order);
        }
    }

    public void checkoutOrder(UUID uuid) {
        /// TO-DO

        // fetch the order with UUID

        // Check the current state of order, if the state is not NEW, return
        // validate credit card

        // Do checkout here
        // 1. change order state
        // 2. save order
    }

}
