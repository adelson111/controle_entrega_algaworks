package br.com.adelsonoliveira.controle_entrega.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModelOutput {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
