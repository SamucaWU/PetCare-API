package com.petshop.apipetshop.DTO.tutorDTO;

import com.petshop.apipetshop.model.Tutor;

public record TutorResponseDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String telefone
) {
    public static TutorResponseDTO fromEntity(Tutor tutor) {
        return new TutorResponseDTO(
            tutor.getId(),
            tutor.getNome(),
            tutor.getCpf(),
            tutor.getEmail(),
            tutor.getTelefone()
        );
    }
}
