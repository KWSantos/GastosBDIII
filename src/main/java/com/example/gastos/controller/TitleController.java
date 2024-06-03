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

import com.example.gastos.domain.dto.title.TitleRequestDTO;
import com.example.gastos.domain.dto.title.TitleResponseDTO;
import com.example.gastos.domain.service.TitleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/titles")
public class TitleController {

    @Autowired
    private TitleService title;

    @GetMapping
    public ResponseEntity<List<TitleResponseDTO>> getAll() {
        return ResponseEntity.ok(title.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitleResponseDTO> getByID(@PathVariable Long id) {
        return ResponseEntity.ok(title.getById(id));
    }

    @PostMapping
    public ResponseEntity<TitleResponseDTO> register(@RequestBody TitleRequestDTO dto) {
        TitleResponseDTO titleResponseDTO = title.register(dto);
        return new ResponseEntity<>(titleResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitleResponseDTO> update(@PathVariable Long id, @RequestBody TitleRequestDTO dto) {
        return ResponseEntity.ok(title.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        title.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
