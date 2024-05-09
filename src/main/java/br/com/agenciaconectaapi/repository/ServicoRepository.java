package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findAllByAtivoIs(boolean ativo);
}
