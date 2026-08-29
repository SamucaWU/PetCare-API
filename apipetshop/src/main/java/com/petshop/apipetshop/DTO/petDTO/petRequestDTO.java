package com.petshop.apipetshop.DTO.petDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record petRequestDTO (

    @NotBlank(message = "O campo nome é obrigatório")
    String nome,
    
    @NotBlank(message = "O campo espécie é obrigatório")
    String especie,
    
    @NotNull(message = "O campo idade em meses é obrigatório")
    Integer idadeMeses

) {}
