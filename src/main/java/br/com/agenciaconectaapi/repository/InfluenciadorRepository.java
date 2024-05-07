package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Influenciador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InfluenciadorRepository extends JpaRepository<Influenciador, Integer> {

    Optional<Influenciador> findInfluenciadorByNomeContaining(String nome);
}
