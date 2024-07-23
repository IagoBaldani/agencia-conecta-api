package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {

    @Query("SELECT IFNULL(SUM(ROUND(valor, 2)), 0) AS VALOR_TOTAL FROM Gasto WHERE MONTH(data) = ?1 AND YEAR(data) = ?2")
    BigDecimal findGastoTotalPorMesAno(Integer mes, Integer ano);
    @Query(value = "SELECT id, descricao, valor, data, fixo FROM gastos WHERE MONTH(data) = :mes AND YEAR(data) = :ano", nativeQuery = true)
    List<Gasto> findGastosPorMesAno(Integer mes, Integer ano);

    @Query(value = "SELECT * FROM gastos WHERE fixo GROUP BY valor, descricao", nativeQuery = true)
    List<Gasto> findAllFixos();

}
