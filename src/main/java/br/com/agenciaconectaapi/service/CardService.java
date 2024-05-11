package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.model.CardInformacao;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.CardFinancasDao;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static br.com.agenciaconectaapi.util.Constantes.CARD_NAO_ENCONTRADO;

@Service
public class CardService {

    private final InfluenciadorRepository influenciadorRepository;
    private final CardFinancasDao cardFinancasDao;

    public CardService(InfluenciadorRepository influenciadorRepository, CardFinancasDao cardFinancasDao) {
        this.influenciadorRepository = influenciadorRepository;
        this.cardFinancasDao = cardFinancasDao;
    }


    public HashMap<String, String> buscaInformacaoCards(String descricaoCardProcurado){
        HashMap<String, String> map = new HashMap<>();

        if(descricaoCardProcurado.equals(CardInformacao.NUMERO_INFLUENCIADORES_ATIVOS.getDescricao())){
            map.put("qtd_ativos", influenciadorRepository.getNumeroInfluenciadoresAtivos());
        }
        else if(descricaoCardProcurado.equals(CardInformacao.INFLUENCIADOR_MAIS_ANTIGO.getDescricao())){
            map.put("influencer_mais_antigo", influenciadorRepository.findNomeInfluenciadorMaisAntigo());
        }
        else if(descricaoCardProcurado.equals(CardInformacao.INFLUENCIADOR_MAIS_RECENTE.getDescricao())){
            map.put("influencer_mais_recente", influenciadorRepository.findNomeInfluenciadorMaisRecente());
        }
        else {
            throw new RuntimeException(CARD_NAO_ENCONTRADO);
        }

        return map;
    }

    public List<CardFinancas> buscaCardsFinancas(Integer mes, Integer ano){
        List<Influenciador> listaInfluenciadores = influenciadorRepository.findAll();

        List<CardFinancas> listaCards = new ArrayList<>();

        for (Influenciador influenciador : listaInfluenciadores) {

            CardFinancas cardFinancas = null;
            try {
                cardFinancas = cardFinancasDao.findCardFinancasPorInfluenciadorMesEAno(influenciador.getId(), mes, ano);
            }
            catch (EmptyResultDataAccessException ignored) {}

            if(cardFinancas != null){
                listaCards.add(cardFinancas);
            }
        }

        return listaCards;
    }

}
