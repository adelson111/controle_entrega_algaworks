package br.com.adelsonoliveira.controle_entrega.controller;

import br.com.adelsonoliveira.controle_entrega.assembler.OcorrenciaAssembler;
import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import br.com.adelsonoliveira.controle_entrega.entity.Ocorrencia;
import br.com.adelsonoliveira.controle_entrega.model.OcorrenciaModelInput;
import br.com.adelsonoliveira.controle_entrega.model.OcorrenciaModelOutput;
import br.com.adelsonoliveira.controle_entrega.service.EntregaService;
import br.com.adelsonoliveira.controle_entrega.service.OcorrenciaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;
    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModelOutput registrar(@PathVariable Long id, @Valid @RequestBody OcorrenciaModelInput ocorrenciaModelInput) {
        Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(id, ocorrenciaModelInput.getDescricao());
        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModelOutput> listar(@PathVariable Long id) {
        Entrega entrega = entregaService.buscar(id);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
