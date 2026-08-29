package com.petshop.apipetshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.apipetshop.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByNomeContaining(String nome);// buscar por nome do pet
    List<Pet> findByTutorId(Long tutorId); // buscar por tutorId
    List<Pet> findByEspecie(String especie); // buscar por especie do pet
}
