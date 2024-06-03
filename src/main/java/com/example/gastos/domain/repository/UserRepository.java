package com.example.gastos.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gastos.domain.model.Users;

public interface UserRepository extends JpaRepository <Users, Long> {
    
    Optional<Users>findByEmail(String email);
}
