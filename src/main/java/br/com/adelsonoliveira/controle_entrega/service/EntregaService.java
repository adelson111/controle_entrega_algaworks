package br.com.adelsonoliveira.controle_entrega.service;

import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import br.com.adelsonoliveira.controle_entrega.entity.StatusEntrega;
import br.com.adelsonoliveira.controle_entrega.exception.EntidadeNaoEncontradaException;
import br.com.adelsonoliveira.controle_entrega.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class EntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        entrega.setCliente(clienteService.buscar(entrega.getCliente().getId()));
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }

    @Transactional
    public void finalizar(Long id) {
        Entrega entrega = buscar(id);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }

    public Entrega buscar(Long id) {
        return entregaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
