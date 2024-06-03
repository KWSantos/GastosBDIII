package com.example.gastos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gastos.domain.model.Title;
import com.example.gastos.domain.model.Users;

import java.util.List;


public interface TitleRepository extends JpaRepository<Title, Long>{
    
    List<Title> findByUser(Users user);
}
