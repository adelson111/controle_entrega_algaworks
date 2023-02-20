package br.com.adelsonoliveira.controle_entrega.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EntregaModelInput {

    @Valid
    @NotNull
    private Long idCliente;

    @Valid
    @NotNull
    private DestinatarioModel destinatario;

    @NotNull
    private BigDecimal taxa;
}
