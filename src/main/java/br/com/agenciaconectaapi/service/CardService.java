package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.model.CardInformacao;
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

import static br.com.agenciaconectaapi.util.Constantes.CARD_NAO_ENCONTRADO;

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


    public HashMap<String, String> buscaInformacaoCardsInfluenciador(String descricaoCardProcurado){
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

    public HashMap<String, BigDecimal> buscaInformacaoCardsFinancas(String descricaoCardProcurado, Integer mes, Integer ano){
        HashMap<String, BigDecimal> map = new HashMap<>();

        if(descricaoCardProcurado.equals("ganhos_acessor")){
            map.put("ganhosAcessor", servicoRepository.findTotalGanhosAcessorPorMesAno(mes, ano));
        }
        else if(descricaoCardProcurado.equals("total_contratos")){
            map.put("totalContratos", servicoRepository.findTotalContratosPorMesAno(mes, ano));
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
