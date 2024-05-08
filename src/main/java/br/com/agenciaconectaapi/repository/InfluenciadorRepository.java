package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Influenciador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InfluenciadorRepository extends JpaRepository<Influenciador, Integer> {

    Optional<Influenciador> findInfluenciadorByNomeContaining(String nome);

    @Query("SELECT i.nome FROM Influenciador i ORDER BY i.dataContrato ASC LIMIT 1")
    String findNomeInfluenciadorMaisAntigo();

    @Query("SELECT i.nome FROM Influenciador i ORDER BY i.dataContrato DESC LIMIT 1")
    String findNomeInfluenciadorMaisRecente();

    @Query("SELECT COUNT(i.cpf) FROM Influenciador i WHERE i.ativo = true")
    String getNumeroInfluenciadoresAtivos();
}
