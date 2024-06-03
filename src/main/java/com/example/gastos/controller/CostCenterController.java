package com.example.gastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gastos.domain.dto.coscenter.CostCenterRequestDTO;
import com.example.gastos.domain.dto.coscenter.CostCenterResponseDTO;
import com.example.gastos.domain.service.CostCenterService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/costcenters")
public class CostCenterController {
    
    @Autowired
    private CostCenterService service;

    @GetMapping
    public ResponseEntity<List<CostCenterResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenterResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CostCenterResponseDTO> register(@RequestBody CostCenterRequestDTO dto) {
        CostCenterResponseDTO costCenterResponseDTO = service.register(dto);
        return new ResponseEntity<>(costCenterResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenterResponseDTO> update(@PathVariable Long id, @RequestBody CostCenterRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
