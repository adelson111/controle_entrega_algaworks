package br.com.adelsonoliveira.controle_entrega.service;

import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import br.com.adelsonoliveira.controle_entrega.entity.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {

    private EntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long id, String descricao) {
        Entrega entrega = entregaService.buscar(id);
        return entrega.adicionarOcorrencia(descricao);
    }
}
