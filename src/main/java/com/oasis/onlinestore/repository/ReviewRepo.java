package com.oasis.onlinestore.repository;

import com.oasis.onlinestore.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer>{

}
