package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface LineItemRepo extends JpaRepository<LineItem, UUID>{

//    List<LineItem> findByOrderId(Long orderId);

}
