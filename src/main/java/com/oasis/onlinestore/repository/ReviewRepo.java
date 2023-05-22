package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Integer>{

}
