package com.roomies.roomies.controller;

import com.roomies.roomies.domain.model.Review;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.domain.service.ReviewService;
import com.roomies.roomies.resource.ReviewResource;
import com.roomies.roomies.resource.SaveReviewResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ReviewsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/post/{postId}/reviews")
    public Page<ReviewResource> getAllReviewsByPostId(@PathVariable Long postId, Pageable pageable){
        Page<Review> reviewPage = reviewService.getAllReviewsByPostId(postId,pageable);
        List<ReviewResource> resources = reviewPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @GetMapping("/reviews/{reviewId}")
    public ReviewResource getReviewById(@PathVariable Long reviewId){
        return convertToResource(reviewService.getReviewById(reviewId));
    }

    @PostMapping("/users/{userId}/posts/{postId}/reviews")
    public ReviewResource createReview(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "postId") Long postId,
            @Valid @RequestBody SaveReviewResource resource){
        return convertToResource(reviewService.createReview(postId,userId,convertToEntity(resource)));
    }

    @PutMapping("/reviews/{reviewId}")
    public ReviewResource updateReview(@PathVariable Long reviewId, @Valid @RequestBody SaveReviewResource resource){
        return convertToResource(reviewService.updateReview(reviewId,convertToEntity(resource)));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId){
        return reviewService.deleteReview(reviewId);
    }

    private Review convertToEntity(SaveReviewResource resource) {
        return mapper.map(resource, Review.class);
    }

    private ReviewResource convertToResource(Review entity) {
        return mapper.map(entity, ReviewResource.class);
    }

}