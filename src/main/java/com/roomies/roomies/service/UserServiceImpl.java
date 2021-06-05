package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.User;
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
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
    }

    @Override
    public User createUser(User user) {
        Pageable pageable = PageRequest.of(0,10000);
        Page<User> userPage = userRepository.findAll(pageable);

        if(userPage!=null)
            userPage.forEach(user1 -> {
                if(user1.getEmail().equals(user.getEmail()))
                    throw new ResourceNotFoundException("There is already another user with the same email");
            });

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        User userr = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        userr.setEmail(userRequest.getEmail())
                .setPassword(userRequest.getPassword());
        return userRepository.save(userr);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
