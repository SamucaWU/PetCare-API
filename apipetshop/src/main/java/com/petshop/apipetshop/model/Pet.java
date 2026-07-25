package com.petshop.apipetshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Long id;
    private String nome;
    private Especie especie; //Classe enum Especie
    private Integer idadeMeses;

}
