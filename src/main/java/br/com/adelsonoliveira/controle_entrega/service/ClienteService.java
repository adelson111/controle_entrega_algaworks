package br.com.adelsonoliveira.controle_entrega.service;

import br.com.adelsonoliveira.controle_entrega.entity.Cliente;
import br.com.adelsonoliveira.controle_entrega.exception.NegocioException;
import br.com.adelsonoliveira.controle_entrega.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        Boolean emailUsado = clienteRepository.findByEmail(cliente.getEmail())
                .stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailUsado) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscar(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }
}
