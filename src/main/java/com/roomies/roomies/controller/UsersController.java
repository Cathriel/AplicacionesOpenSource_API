package com.roomies.roomies.controller;

import com.roomies.roomies.domain.model.User;
import com.roomies.roomies.domain.service.UserService;
import com.roomies.roomies.resource.SaveUserResource;
import com.roomies.roomies.resource.UserResource;
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
public class UsersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable){
        List<UserResource> users = userService.getAllUsers(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int usersCount = users.size();
        return new PageImpl<>(users,pageable,usersCount);
    }

    @GetMapping("/paymentMethods/{paymentMethodId}/users")
    public Page<UserResource> getAllUsersByPaymentMethodId(@PathVariable Long paymentMethodId, Pageable pageable){
        List<UserResource> users = userService.getAllUserByPaymentMethodId(paymentMethodId,pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int usersCount = users.size();
        return new PageImpl<>(users,pageable,usersCount);
    }

    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return convertToResource(userService.getUserById(userId));
    }

    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.createUser(convertToEntity(resource)));
    }

    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId, @Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.updateUser(userId,convertToEntity(resource)));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}
