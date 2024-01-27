package com.cardmanagement.cardmanagmentapp.repository;

import com.cardmanagement.cardmanagmentapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}
