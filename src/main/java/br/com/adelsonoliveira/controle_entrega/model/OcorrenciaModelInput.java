package br.com.adelsonoliveira.controle_entrega.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModelInput {

    @NotBlank
    private String descricao;
}
