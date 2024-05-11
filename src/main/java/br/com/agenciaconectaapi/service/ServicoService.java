package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.InfluenciadorJaExisteException;
import br.com.agenciaconectaapi.exception.InfluenciadorNaoEncontradoException;
import br.com.agenciaconectaapi.exception.ServicoNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.repository.CardFinancasDao;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import br.com.agenciaconectaapi.repository.ServicoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.*;

@Service
public class ServicoService {
    private final InfluenciadorRepository influenciadorRepository;
    private final ServicoRepository servicoRepository;
    private final CardFinancasDao cardFinancasDao;

    public ServicoService(ServicoRepository servicoRepository, InfluenciadorRepository influenciadorRepository, CardFinancasDao cardFinancasDao) {
        this.servicoRepository = servicoRepository;
        this.influenciadorRepository = influenciadorRepository;
        this.cardFinancasDao = cardFinancasDao;
    }

    public Servico buscaServicoPorId(Integer id){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        return optionalServico.orElseThrow(() ->  new ServicoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));
    }

    public List<Servico> buscarTodosServicos(boolean ativos){
        List<Servico> listServicos = servicoRepository.findAllByAtivoIs(ativos);

        if(listServicos.isEmpty()){
            throw new ServicoNaoEncontradoException(NENHUM_SERVICO_ENCONTRADO);
        }

        return listServicos;
    }

    public List<Servico> buscarServicosPorInfluenciador(Integer id){
        Optional<Influenciador> optionalInfluenciador = influenciadorRepository.findById(id);

        Influenciador influenciador = optionalInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));


        List<Servico> listServicos = servicoRepository.findAllByInfluenciadorOrderByAtivoDescDataFimAsc(influenciador);

        if(listServicos.isEmpty()){
            throw new ServicoNaoEncontradoException(NENHUM_SERVICO_ENCONTRADO);
        }

        return listServicos;
    }

    public Servico criarServico(ServicoDto servicoDto){
        Servico servico = new Servico(servicoDto);

        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(servicoDto.getInfluenciadorId());

        Influenciador influenciador = optInfluenciador.orElseThrow(() -> new InfluenciadorJaExisteException(INFLUENCIADOR_NAO_ENCONTRADO));
        servico.setInfluenciador(influenciador);

        return servicoRepository.save(servico);
    }

    public Servico atualizarStatus(Integer id){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        Servico servico = optionalServico.orElseThrow(() -> new ServicoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));
        servico.mudarStatus();

        return servicoRepository.save(servico);
    }

    public Servico atualizarServico(Integer id, ServicoDto servicoDto){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        optionalServico.orElseThrow(() -> new ServicoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));

        Servico servico = new Servico(servicoDto);
        servico.setId(id);

        Optional<Influenciador> optionalInfluenciador = influenciadorRepository.findById(servicoDto.getInfluenciadorId());
        Influenciador influenciador = optionalInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));

        servico.setInfluenciador(influenciador);

        return servicoRepository.save(servico);
    }

    public Servico deletarServico(Integer id){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        Servico servico = optionalServico.orElseThrow(() -> new ServicoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));

        servicoRepository.delete(servico);

        return servico;
    }

    public List<CardFinancas> buscaCardsFinancas(Integer mes, Integer ano){
        //Busca todos os influenciadores.
        List<Influenciador> listaInfluenciadores = influenciadorRepository.findAll();

        // Cria a lista que sera retornada.
        List<CardFinancas> listaCards = new ArrayList<>();

        // Itera por todos os influenciadores.
        for (Influenciador influenciador : listaInfluenciadores) {

            // Pega o card de financas do influenciador da iteracao no mes e ano especificado.
            CardFinancas cardFinancas = null;
            try {
                cardFinancas = cardFinancasDao.findCardFinancasPorInfluenciadorMesEAno(influenciador.getId(), mes, ano);
            }
            catch (EmptyResultDataAccessException ignored) {}

            // Se o card de financas nao for null, insere na lista de retorno.
            if(cardFinancas != null){
                listaCards.add(cardFinancas);
            }
        }

        return listaCards;
    }
}
