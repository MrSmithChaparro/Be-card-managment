package com.cardmanagement.cardmanagmentapp.service;
import com.cardmanagement.cardmanagmentapp.dto.UserDTO;
import com.cardmanagement.cardmanagmentapp.model.Users;
import com.cardmanagement.cardmanagmentapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<?> createUser(UserDTO userDTO) {
        String msg =  "User registered successfully";

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            msg = "Email is already registered";
            return ResponseEntity.badRequest().body(msg);
        }

        Users newUser = new Users();
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }
}
