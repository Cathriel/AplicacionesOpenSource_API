package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
