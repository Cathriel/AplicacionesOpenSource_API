package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.PaymentMethod;
import com.roomies.roomies.domain.model.User;
import com.roomies.roomies.domain.repository.PaymentMethodRepository;
import com.roomies.roomies.domain.repository.UserRepository;
import com.roomies.roomies.domain.service.UserService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

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
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        user.setAddress(userRequest.getAddress())
                .setBirthday(userRequest.getBirthday())
                .setCellphone(userRequest.getCellphone())
                .setDepartment(userRequest.getDepartment())
                .setEmail(userRequest.getEmail())
                .setDescription(userRequest.getDescription())
                .setIdCard(userRequest.getIdCard())
                .setName(userRequest.getName())
                .setPassword(userRequest.getPassword())
                .setProvince(userRequest.getProvince())
                .setLastName(userRequest.getLastName())
                .setDistrict(userRequest.getDistrict());
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public User assignPaymentMethodUser(Long paymentMethodId, Long userId) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(()->new ResourceNotFoundException("PaymentMethod","Id",paymentMethodId));
        return userRepository.findById(userId).map(
                user -> userRepository.save(user.assignWithPm(paymentMethod)))
                .orElseThrow(()->new ResourceNotFoundException(
                        "User","Id",userId));
    }

    @Override
    public User unAssignPaymentMethodUser(Long paymentMethodId, Long userId) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(()->new ResourceNotFoundException("PaymentMethod","Id",paymentMethodId));
        return userRepository.findById(userId).map(
                user -> userRepository.save(user.unAssignWithPm(paymentMethod)))
                .orElseThrow(()->new ResourceNotFoundException(
                        "User","Id",userId));
    }

    @Override
    public Page<User> getAllUserByPaymentMethodId(Long paymentMethodId, Pageable pageable) {
        return paymentMethodRepository.findById(paymentMethodId).map(
                paymentMethod ->{List<User> users = paymentMethod.getUserPaymentMethods();
                    int usersCount = users.size();
                    return new PageImpl<>(users,pageable,usersCount);
                }).orElseThrow(()->new ResourceNotFoundException("PaymentMethod","Id",paymentMethodId));
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("User","Name",name));
    }


}
