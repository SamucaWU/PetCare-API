package com.petshop.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    
    private Long id;
    private LocalDateTime dataHora;
    private TipoServico tipoServico; //Classe enum TipoServico
    private StatusAgendamento status; //Classe enum StatusAgendamento
    private Boolean prioridadeEmergencia;
    private String observacoes;

}
