package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Leaseholder;
import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.repository.LeaseholderRepository;
import com.roomies.roomies.domain.repository.PostRepository;
import com.roomies.roomies.domain.service.LeaseholderService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseholderServiceImpl implements LeaseholderService {

    @Autowired
    private LeaseholderRepository leaseholderRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Leaseholder> getAllLeaseholder(Pageable pageable) {
        return leaseholderRepository.findAll(pageable);
    }

    @Override
    public Leaseholder getLeaseholderById(Long leaseholderId) {
        return leaseholderRepository.findById(leaseholderId)
                .orElseThrow(()->new ResourceNotFoundException("Leaseholder","Id",leaseholderId));
    }

    @Override
    public Leaseholder createLeaseholder(Leaseholder leaseholder) {
        return leaseholderRepository.save(leaseholder);
    }

    @Override
    public Leaseholder updateLeaseholder(Long leaseholderId, Leaseholder leaseholderRequest) {
        Leaseholder leaseholder = leaseholderRepository.findById(leaseholderId)
                .orElseThrow(()->new ResourceNotFoundException("Leaseholder","Id",leaseholderId));
        leaseholder.setAddress(leaseholderRequest.getAddress())
                .setBirthday(leaseholderRequest.getBirthday())
                .setCellphone(leaseholderRequest.getCellphone())
                .setDepartment(leaseholderRequest.getDepartment())
                .setEmail(leaseholderRequest.getEmail())
                .setDescription(leaseholderRequest.getDescription())
                .setIdCard(leaseholderRequest.getIdCard())
                .setName(leaseholderRequest.getName())
                .setPassword(leaseholderRequest.getPassword())
                .setProvince(leaseholderRequest.getProvince())
                .setLastName(leaseholderRequest.getLastName())
                .setDistrict(leaseholderRequest.getDistrict());
        return leaseholderRepository.save(leaseholder);
    }

    @Override
    public ResponseEntity<?> deleteLeaseholder(Long leaseholderId) {
        Leaseholder leaseholder = leaseholderRepository.findById(leaseholderId)
                .orElseThrow(()->new ResourceNotFoundException("Leaseholder","Id",leaseholderId));
        leaseholderRepository.delete(leaseholder);
        return ResponseEntity.ok().build();
    }

    @Override
    public Leaseholder assignLeaseholderPost(Long leaseholderId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","Id",postId));
        return leaseholderRepository.findById(postId).map(
                leaseholder -> leaseholderRepository.save(leaseholder.assignWith(post)))
                .orElseThrow(()->new ResourceNotFoundException("Leaseholder","Id",leaseholderId));
    }

    @Override
    public Leaseholder unAssignLeaseholderPost(Long leaseholderId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","Id",postId));
        return leaseholderRepository.findById(postId).map(
                leaseholder -> leaseholderRepository.save(leaseholder.unAssignWith(post)))
                .orElseThrow(()->new ResourceNotFoundException("Leaseholder","Id",leaseholderId));
    }

    @Override
    public Page<Post> getAllPostsByLeaseholderId(Long leaseholderId, Pageable pageable) {
        return leaseholderRepository.findById(leaseholderId).map(
                leaseholder -> {
                    List<Post> posts = leaseholder.getFavouritePosts();
                    int postsCount = posts.size();
                    return new PageImpl<>(posts,pageable,postsCount);
                }).orElseThrow(()->new ResourceNotFoundException(
                        "Leaseholder","Id",leaseholderId));
    }
}
