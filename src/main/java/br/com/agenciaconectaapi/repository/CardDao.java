package br.com.agenciaconectaapi.repository;

import br.com.agenciaconectaapi.dto.CardDatas;
import br.com.agenciaconectaapi.dto.CardFinancas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CardDao {

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

    public List<CardDatas> findCardProximosAniversarios() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT nome, data_nascimento ");
        query.append("FROM influenciadores ");
        query.append("WHERE ( ");
        query.append("DATE_FORMAT(data_nascimento, '%m-%d') BETWEEN DATE_FORMAT(CURDATE(), '%m-%d') ");
        query.append("AND DATE_FORMAT(DATE_ADD(CURDATE(), INTERVAL 10 DAY), '%m-%d') ) ");
        query.append("OR ( DATE_FORMAT(data_nascimento, '%m-%d') >= DATE_FORMAT(CURDATE(), '%m-%d') ");
        query.append(" AND DATE_FORMAT(data_nascimento, '%m-%d') <= DATE_FORMAT(DATE_ADD(CURDATE(), INTERVAL 10 DAY), '%m-%d') ) ");
        query.append("ORDER BY DATE_FORMAT(data_nascimento, '%m-%d')");

        List<Object[]> resultObjectList = em.createNativeQuery(query.toString()).getResultList();
        List<CardDatas> resultList = new ArrayList<>();

        for (Object[] object : resultObjectList) {
            resultList.add(fromObjectToCardDatas(object));
        }

        return resultList;
    }

    public List<CardDatas> findCardProximosVencimentosContrato() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT nome, data_vencimento_contrato ");
        query.append("FROM influenciadores ");
        query.append("WHERE data_vencimento_contrato BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)");

        List<Object[]> resultObjectList = em.createNativeQuery(query.toString()).getResultList();
        List<CardDatas> resultList = new ArrayList<>();

        for (Object[] object : resultObjectList) {
            resultList.add(fromObjectToCardDatas(object));
        }

        return resultList;
    }

    private CardFinancas fromObjectToCardFinancas(Object[] object){
        return new CardFinancas((String) object[0],
                (BigDecimal) object[1],
                (BigDecimal) object[2],
                Integer.parseInt(object[3].toString())
        );
    }

    private CardDatas fromObjectToCardDatas(Object[] object){
        return new CardDatas((String) object[0],
                (Date) object[1]
        );
    }
}
