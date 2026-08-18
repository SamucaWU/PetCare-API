package com.petshop.apipetshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.apipetshop.DTO.TutorRequestDTO;
import com.petshop.apipetshop.DTO.TutorResponseDTO;
import com.petshop.apipetshop.service.TutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {
    
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }
    
    @PostMapping
    public ResponseEntity<TutorResponseDTO> cadastrar(@RequestBody @Valid TutorRequestDTO dto) {
        TutorResponseDTO tutorResponse = tutorService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorResponse);
    }

    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(tutorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tutorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TutorRequestDTO dto) {
        return ResponseEntity.ok(tutorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
