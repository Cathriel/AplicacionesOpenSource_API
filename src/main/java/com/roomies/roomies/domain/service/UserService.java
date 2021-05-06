package com.roomies.roomies.domain.service;

import com.roomies.roomies.domain.model.PaymentMethod;
import com.roomies.roomies.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId,User userRequest);
    ResponseEntity<?> deleteUser(Long userId);
    User assignPaymentMethodUser(Long paymentMethodId,Long userId);
    User unAssignPaymentMethodUser(Long paymentMethodId,Long userId);
    Page<User> getAllUserByPaymentMethodId(Long userId, Pageable pageable);
}
