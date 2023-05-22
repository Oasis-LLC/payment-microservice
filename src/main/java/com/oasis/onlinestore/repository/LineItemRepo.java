package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepo extends JpaRepository<LineItem,Integer>{

}
