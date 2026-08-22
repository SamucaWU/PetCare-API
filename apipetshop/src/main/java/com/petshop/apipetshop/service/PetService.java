package com.petshop.apipetshop.service;

import com.petshop.apipetshop.repository.PetRepository;

public class PetService {
    
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
}
