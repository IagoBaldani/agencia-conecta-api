package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.dto.CardFinancas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public class CardFinancasDao {

    @PersistenceContext
    private EntityManager em;

    public CardFinancas findCardFinancasPorInfluenciadorMesEAno(Integer idInfluenciador, Integer mes, Integer ano) {
        StringBuilder query = new StringBuilder();

        query.append("SELECT I.nome AS nomeInfluenciador, ");
        query.append("SUM(ROUND((S.porcentagem/100) * S.valor, 2)) AS valorAcessor, ");
        query.append("SUM(ROUND(S.valor - ((S.porcentagem/100) * S.valor), 2))  AS valorInfluenciador, ");
        query.append("(SELECT COUNT(*) FROM servicos S WHERE S.influenciador_id = :idInfluenciador AND MONTH(S.data_fim) = :mes AND YEAR(S.data_fim) = :ano) AS qtdServicos ");
        query.append("FROM servicos S ");
        query.append("INNER JOIN influenciadores I ");
        query.append("ON S.influenciador_id = I.id ");
        query.append("WHERE S.influenciador_id = :idInfluenciador ");
        query.append("AND MONTH(S.data_fim) = :mes ");
        query.append("AND YEAR(S.data_fim) = :ano ");
        query.append("GROUP BY I.NOME");

        Object[] retorno = (Object[]) em.createNativeQuery(query.toString())
                .setParameter("idInfluenciador", idInfluenciador)
                .setParameter("mes", mes)
                .setParameter("ano", ano)
                .getSingleResult();

        return fromObjectToCardFinancas(retorno);
    }

    private CardFinancas fromObjectToCardFinancas(Object[] object){
        return new CardFinancas((String) object[0],
                (BigDecimal) object[1],
                (BigDecimal) object[2],
                Integer.parseInt(object[3].toString())
        );
    }
}
