package com.petshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    
    private Long id;
    private String nome;
    private String cpf;
    private String email;

}
