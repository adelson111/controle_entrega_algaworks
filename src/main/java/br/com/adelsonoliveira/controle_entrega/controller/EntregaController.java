package br.com.adelsonoliveira.controle_entrega.controller;

import br.com.adelsonoliveira.controle_entrega.assembler.EntregaAssembler;
import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import br.com.adelsonoliveira.controle_entrega.model.EntregaModelInput;
import br.com.adelsonoliveira.controle_entrega.model.EntregaModelOutput;
import br.com.adelsonoliveira.controle_entrega.repository.EntregaRepository;
import br.com.adelsonoliveira.controle_entrega.service.EntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModelOutput solicitar(@Valid @RequestBody EntregaModelInput entrega) {
        Entrega novaEntrega = entregaAssembler.toEntity(entrega);
        Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
        return entregaAssembler.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModelOutput> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModelOutput> buscar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long id) {
        entregaService.finalizar(id);
    }
}
