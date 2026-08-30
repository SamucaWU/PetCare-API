package com.petshop.apipetshop.DTO.petDTO;

import com.petshop.apipetshop.model.Especie;
import com.petshop.apipetshop.model.Pet;

public record PetResponseDTO (
    Long id,
    String nome,
    Especie especie,
    Integer idadeMeses,
    Long tutorId
){
    public static PetResponseDTO fromEntity(Pet pet) {
        return new PetResponseDTO(
            pet.getId(),
            pet.getNome(),
            pet.getEspecie(),
            pet.getIdadeMeses(),
            pet.getTutor() != null ? pet.getTutor().getId() : null
            // ^ Se houver tutor, pegue o ID; se não houver, coloque null
        );
    }
}

