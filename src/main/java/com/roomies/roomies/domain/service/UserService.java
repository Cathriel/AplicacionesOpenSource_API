package com.roomies.roomies.domain.service;

import com.roomies.roomies.domain.model.Userr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<Userr> getAllUsers(Pageable pageable);
    Userr getUserById(Long userId);
    Userr createUser(Userr userr);
    Userr updateUser(Long userId, Userr userrRequest);
    ResponseEntity<?> deleteUser(Long userId);
}
