package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.CardDatas;
import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.CardDao;
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
    private final CardDao cardDao;

    public CardService(InfluenciadorRepository influenciadorRepository, ServicoRepository servicoRepository, CardDao cardDao) {
        this.influenciadorRepository = influenciadorRepository;
        this.servicoRepository = servicoRepository;
        this.cardDao = cardDao;
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

        map.put("ganhosAcessorDeclaravel", servicoRepository.findTotalGanhosAcessorPorMesAno(mes, ano, true));
        map.put("ganhosAcessorNaoDeclaravel", servicoRepository.findTotalGanhosAcessorPorMesAno(mes, ano, false));
        map.put("totalContratos", servicoRepository.findTotalContratosPorMesAno(mes, ano));

        return map;
    }

    public List<CardFinancas> buscaCardsFinancas(Integer mes, Integer ano) {
        List<Influenciador> listaInfluenciadores = influenciadorRepository.findAll();

        List<CardFinancas> listaCards = new ArrayList<>();

        for (Influenciador influenciador : listaInfluenciadores) {

            CardFinancas cardFinancas = null;
            try {
                cardFinancas = cardDao.findCardFinancasPorInfluenciadorMesEAno(influenciador.getId(), mes, ano);
            } catch (EmptyResultDataAccessException ignored) {}

            if (cardFinancas != null) {
                listaCards.add(cardFinancas);
            }
        }

        listaCards.sort((card1, card2) -> Integer.compare(card2.qtdServicos(),card1.qtdServicos()));

        return listaCards;
    }

    public List<CardDatas> buscarCardProximosAniversarios(){
        return cardDao.findCardProximosAniversarios();
    }

    public List<CardDatas> buscarCardProximosVencimentosContrato(){
        return cardDao.findCardProximosVencimentosContrato();
    }
}
