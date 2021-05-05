package com.roomies.roomies.domain.service;

import com.roomies.roomies.domain.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    Page<Review> getAllReviews(Pageable pageable);
    Review getReviewById(Long reviewId);
    Review createReview(Review review);
    Review updateReview(Long reviewId,Review reviewRequest);
    ResponseEntity<?> deleteReview(Long reviewId);
}
