package br.com.adelsonoliveira.controle_entrega.assembler;

import br.com.adelsonoliveira.controle_entrega.entity.Ocorrencia;
import br.com.adelsonoliveira.controle_entrega.model.OcorrenciaModelOutput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModelOutput toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaModelOutput.class);
    }

    public List<OcorrenciaModelOutput> toCollectionModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
    }
}
