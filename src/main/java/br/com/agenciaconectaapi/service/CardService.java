package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.CardFinancasDao;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import br.com.agenciaconectaapi.repository.ServicoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CardService {

    private final InfluenciadorRepository influenciadorRepository;
    private final ServicoRepository servicoRepository;
    private final CardFinancasDao cardFinancasDao;

    public CardService(InfluenciadorRepository influenciadorRepository, ServicoRepository servicoRepository, CardFinancasDao cardFinancasDao) {
        this.influenciadorRepository = influenciadorRepository;
        this.servicoRepository = servicoRepository;
        this.cardFinancasDao = cardFinancasDao;
    }


    public HashMap<String, String> buscaInformacaoCardsInfluenciador() {
        HashMap<String, String> map = new HashMap<>();

        map.put("qtdInfluenciadoresAtivos", influenciadorRepository.getNumeroInfluenciadoresAtivos());
        map.put("influenciadorMaisAntigo", influenciadorRepository.findNomeInfluenciadorMaisAntigo());
        map.put("influenciadorMaisRecente", influenciadorRepository.findNomeInfluenciadorMaisRecente());

        return map;
    }

    public HashMap<String, BigDecimal> buscaInformacaoCardsFinancas(Integer mes, Integer ano) {
        HashMap<String, BigDecimal> map = new HashMap<>();

        map.put("ganhosAcessor", servicoRepository.findTotalGanhosAcessorPorMesAno(mes, ano));
        map.put("totalContratos", servicoRepository.findTotalContratosPorMesAno(mes, ano));

        return map;
    }

    public List<CardFinancas> buscaCardsFinancas(Integer mes, Integer ano) {
        List<Influenciador> listaInfluenciadores = influenciadorRepository.findAll();

        List<CardFinancas> listaCards = new ArrayList<>();

        for (Influenciador influenciador : listaInfluenciadores) {

            CardFinancas cardFinancas = null;
            try {
                cardFinancas = cardFinancasDao.findCardFinancasPorInfluenciadorMesEAno(influenciador.getId(), mes, ano);
            } catch (EmptyResultDataAccessException ignored) {
            }

            if (cardFinancas != null) {
                listaCards.add(cardFinancas);
            }
        }

        listaCards.sort((card1, card2) -> Integer.compare(card2.qtdServicos(),card1.qtdServicos()));

        return listaCards;
    }

}
