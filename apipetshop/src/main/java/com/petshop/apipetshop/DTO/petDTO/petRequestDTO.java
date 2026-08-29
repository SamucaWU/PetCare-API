package com.petshop.apipetshop.DTO.petDTO;

import com.petshop.apipetshop.model.Especie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record petRequestDTO (

    @NotBlank(message = "O campo nome é obrigatório")
    String nome,

    @NotNull(message = "O campo espécie é obrigatório")
    Especie especie,

    @NotNull(message = "O campo idade em meses é obrigatório")
    Integer idadeMeses,

    @NotNull(message = "O campo tutorId é obrigatório")
    Long tutorId

) {}
