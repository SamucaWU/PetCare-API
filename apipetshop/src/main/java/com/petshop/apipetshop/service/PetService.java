package com.petshop.apipetshop.service;

import org.springframework.stereotype.Service;

import com.petshop.apipetshop.DTO.petDTO.petRequestDTO;
import com.petshop.apipetshop.DTO.petDTO.petResponseDTO;
import com.petshop.apipetshop.repository.PetRepository;

@Service
public class PetService {
    
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    
    //cadastrar
    public petResponseDTO cadastrarPet(petRequestDTO dto) {
        if()
    }
    //buscar
    //buscarId
    //atualizar
    //deletar
    
}
