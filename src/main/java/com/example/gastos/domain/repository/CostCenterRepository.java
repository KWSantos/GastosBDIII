package com.example.gastos.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gastos.domain.model.CostCenter;
import com.example.gastos.domain.model.Users;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{
    
    List<CostCenter> findByUser(Users user);
}
