package com.roomies.roomies.controller;

import com.roomies.roomies.domain.model.Landlord;
import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.model.Review;
import com.roomies.roomies.domain.repository.PostRepository;
import com.roomies.roomies.domain.service.LandlordService;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.domain.service.ReviewService;
import com.roomies.roomies.resource.*;
import io.swagger.v3.oas.annotations.Operation;
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
@CrossOrigin
@RequestMapping("/api")
public class PostsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostService postService;

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private LandlordService landlordService;



    @GetMapping("/posts")
    public Page<PostResource> getAllComments(Pageable pageable){
        Page<Post> postPage = postService.getAllPosts(pageable);
        List<PostResource> resources = postPage.getContent().stream().map(
                this::convertToResourcePost).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }


    @GetMapping("/posts/{postId}")
    public PostResource getPostById(@PathVariable Long postId){
        return convertToResourcePost(postService.getPostById(postId));
    }


    @GetMapping("/posts/{postId}/reviews")
    public Page<ReviewResource> getAllReviewsByPostId(@PathVariable Long postId, Pageable pageable){
        Page<Review> reviewPage = reviewService.getAllReviewsByPostId(postId,pageable);
        List<ReviewResource> resources = reviewPage.getContent().stream().map(
                this::convertToResourceReview).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @GetMapping("/posts/{postId}/landlords")
    public LandlordResource getLandlordByPostId(@PathVariable Long postId){
        return convertToResourceLandlord(landlordService.getLandlordByPostId(postId));
    }

    @PutMapping("/posts/{postId}")
    public PostResource updatePost(@PathVariable Long postId,@Valid @RequestBody SavePostResource resource){
        return convertToResourcePost(postService.updatePost(postId,convertToEntityPost(resource)));
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }

    private Post convertToEntityPost(SavePostResource resource){return mapper.map(resource,Post.class);}
    private PostResource convertToResourcePost(Post entity){return mapper.map(entity,PostResource.class);}

    private LandlordResource convertToResourceLandlord(Landlord entity) {
        return mapper.map(entity, LandlordResource.class);
    }

    private ReviewResource convertToResourceReview(Review entity) {
        return mapper.map(entity, ReviewResource.class);
    }
}
