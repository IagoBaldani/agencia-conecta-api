package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.dto.InfluenciadorSimplificadoDto;
import br.com.agenciaconectaapi.model.Influenciador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InfluenciadorRepository extends JpaRepository<Influenciador, Integer> {

    Optional<Influenciador> findInfluenciadorByNomeContaining(String nome);

    List<InfluenciadorProjection> findAllProjectedBy();

    List<InfluenciadorProjection> findAllProjectedByAtivoIs(boolean ativo);

    @Query("SELECT i.nome FROM Influenciador i ORDER BY i.dataAssinaturaContrato ASC LIMIT 1")
    String findNomeInfluenciadorMaisAntigo();

    @Query("SELECT i.nome FROM Influenciador i ORDER BY i.dataAssinaturaContrato DESC LIMIT 1")
    String findNomeInfluenciadorMaisRecente();

    @Query("SELECT COUNT(i.cpf) FROM Influenciador i WHERE i.ativo = true")
    String getNumeroInfluenciadoresAtivos();
}
