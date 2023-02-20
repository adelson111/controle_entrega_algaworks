package br.com.adelsonoliveira.controle_entrega.repository;

import br.com.adelsonoliveira.controle_entrega.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
