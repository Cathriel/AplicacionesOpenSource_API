package com.roomies.roomies.controller;

import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.repository.PostRepository;
import com.roomies.roomies.domain.service.PostService;
import com.roomies.roomies.resource.PostResource;
import com.roomies.roomies.resource.SavePostResource;
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
public class PostsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Page<PostResource> getAllComments(Pageable pageable){
        Page<Post> postPage = postService.getAllPosts(pageable);
        List<PostResource> resources = postPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @PostMapping("/landlord/{landlordId}/posts")
    public PostResource createPost(@PathVariable Long landlordId, @Valid @PathVariable SavePostResource resource){
        return convertToResource(postService.createPost(landlordId,convertToEntity(resource)));
    }

    @PutMapping("/posts/{postId}")
    public PostResource updatePost(@PathVariable Long postId,@Valid @RequestBody SavePostResource resource){
        return convertToResource(postService.updatePost(postId,convertToEntity(resource)));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }

    private Post convertToEntity(SavePostResource resource){return mapper.map(resource,Post.class);}
    private PostResource convertToResource(Post entity){return mapper.map(entity,PostResource.class);}

}
