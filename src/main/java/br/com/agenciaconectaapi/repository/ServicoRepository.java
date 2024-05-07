package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
