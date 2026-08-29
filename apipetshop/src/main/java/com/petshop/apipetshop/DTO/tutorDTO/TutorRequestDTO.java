package com.petshop.apipetshop.DTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TutorRequestDTO(

    @NotBlank(message = "O campo nome é obrigatório")
    String nome,

    @NotBlank(message = "O campo CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números")
    String cpf,

    @NotBlank(message = "O campo telefone é obrigatório")
    String telefone

) {}
