package com.example.gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastos.domain.dto.dashboard.DashboardResponseDTO;
import com.example.gastos.domain.service.DashboardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponseDTO> getCashFlow(@RequestParam(name="initialPeriod") String initialPeriod, @RequestParam(name="finalPeriod") String finalPeriod) {
        return ResponseEntity.ok(dashboardService.getCashFlow(initialPeriod, finalPeriod));
    }
}
