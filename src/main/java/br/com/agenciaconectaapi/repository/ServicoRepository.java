package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findAllByAtivoIs(boolean ativo);
    List<Servico> findAllByInfluenciadorOrderByAtivoDescDataFimAsc(Influenciador influenciador);
    List<Servico> findAllByInfluenciadorAndAtivoIsOrderByAtivoDescDataFimAsc(Influenciador influenciador, boolean ativo);

    @Query("SELECT IFNULL(SUM(ROUND((porcentagem/100) * valor, 2)), 0) AS valorAcessor FROM Servico WHERE MONTH(dataFim) = ?1 AND YEAR(dataFim) = ?2")
    BigDecimal findTotalGanhosAcessorPorMesAno(Integer mes, Integer ano);

    @Query("SELECT IFNULL(SUM(ROUND(valor, 2)), 0) AS VALOR_TOTAL FROM Servico WHERE MONTH(dataFim) = ?1 AND YEAR(dataFim) = ?2")
    BigDecimal findTotalContratosPorMesAno(Integer mes, Integer ano);

}
