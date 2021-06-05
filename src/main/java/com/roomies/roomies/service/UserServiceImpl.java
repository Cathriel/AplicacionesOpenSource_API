package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Userr;
import com.roomies.roomies.domain.repository.ProfileRepository;
import com.roomies.roomies.domain.repository.UserRepository;
import com.roomies.roomies.domain.service.UserService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Page<Userr> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Userr getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
    }

    @Override
    public Userr createUser(Userr userr) {
        Pageable pageable = PageRequest.of(0,10000);
        Page<Userr> userPage = userRepository.findAll(pageable);

        if(userPage!=null)
            userPage.forEach(user1 -> {
                if(user1.getEmail().equals(userr.getEmail()))
                    throw new ResourceNotFoundException("There is already another user with the same email");
            });

        return userRepository.save(userr);
    }

    @Override
    public Userr updateUser(Long userId, Userr userrRequest) {
        Userr userr = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        userr.setEmail(userrRequest.getEmail())
                .setPassword(userrRequest.getPassword());
        return userRepository.save(userr);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        Userr userr = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(userr);
        return ResponseEntity.ok().build();
    }
}
