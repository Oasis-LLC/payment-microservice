package com.oasis.onlinestore.controller;

import com.oasis.onlinestore.domain.Item;
import com.oasis.onlinestore.domain.LineItem;
import com.oasis.onlinestore.domain.Order;
import com.oasis.onlinestore.domain.Status;
import com.oasis.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findAllById(@PathVariable String orderId) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> order = orderService.getOrderById(uuid);
        if (order.isPresent()) {
            return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{orderId}/line")
    public ResponseEntity<?> getAllItemLine(@PathVariable String orderId) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> order = orderService.getOrderById(uuid);
        if (order.isPresent()) {
            List<LineItem> lineItems = order.get().getLineItems();
            return new ResponseEntity<List<LineItem>>(lineItems, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/additem")
    public ResponseEntity<?> addItemLineToOrder(@RequestParam("itemId") String itemId) {
        UUID itemUuid = UUID.fromString(itemId);
        Optional<LineItem> lineItemOptional = orderService.addLineItem(itemUuid);

        if (lineItemOptional.isPresent()) {
            return new ResponseEntity<LineItem>(lineItemOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/line/{itemLineId}")
    public ResponseEntity<?> removeItemLineFromOrder(@PathVariable String orderId,
                                                     @PathVariable String itemLineId) {
        UUID uuid = UUID.fromString(orderId);
        UUID itemLineUUID = UUID.fromString(orderId);
        orderService.removeLineItem(uuid, itemLineUUID);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkoutOrder(@PathVariable String orderId) {
        UUID uuid = UUID.fromString(orderId);
        orderService.checkoutOrder(uuid);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable String orderId) {
        UUID uuid = UUID.fromString(orderId);
        orderService.cancelOrder(uuid);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}




