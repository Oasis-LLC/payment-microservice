package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.Address;
import com.oasis.onlinestore.domain.Customer;
import com.oasis.onlinestore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
//    Order findById(Long orderId);
//    List<Order> findByCustomer(Customer customer);
    List<Order> findByShippingAddress(Address address);
//    List<Order> findUnshippedOrders();

}
