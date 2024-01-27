package com.cardmanagement.cardmanagmentapp.controller;

import com.cardmanagement.cardmanagmentapp.dto.UserDTO;
import com.cardmanagement.cardmanagmentapp.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user) {
        return userService.createUser(user);
    }
}
