package com.petshop.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor//Construtor com argumentos
public class Prontuario {

    private Long id;
    private LocalDateTime dataAtendimento;
    private String diagnostico;
    private String vacinasAplicadas;
}
