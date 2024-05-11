package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findAllByAtivoIs(boolean ativo);

    List<Servico> findAllByInfluenciadorOrderByAtivoDescDataFimAsc(Influenciador influenciador);

}
