package br.com.adelsonoliveira.controle_entrega.assembler;

import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import br.com.adelsonoliveira.controle_entrega.model.EntregaModelOutput;
import br.com.adelsonoliveira.controle_entrega.model.EntregaModelInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaModelOutput toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModelOutput.class);
    }

    public List<EntregaModelOutput> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaModelInput entregaModelInput) {
        return modelMapper.map(entregaModelInput, Entrega.class);
    }
}
