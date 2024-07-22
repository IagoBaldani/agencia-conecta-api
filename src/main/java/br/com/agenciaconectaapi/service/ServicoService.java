package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.InfluenciadorJaExisteException;
import br.com.agenciaconectaapi.exception.RecursoNaoEncontradoException;
import br.com.agenciaconectaapi.exception.RecursoNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import br.com.agenciaconectaapi.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.*;

@Service
@AllArgsConstructor
public class ServicoService {

    private final InfluenciadorRepository influenciadorRepository;
    private final ServicoRepository servicoRepository;

    public Servico buscaServicoPorId(Integer id){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        return optionalServico.orElseThrow(() ->  new RecursoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));
    }

    public List<Servico> buscarTodosServicos(String ativos, Integer idInfluenciador){
        List<Servico> listServicos = new ArrayList<>();

        if(ativos != null && idInfluenciador == null){
            listServicos = servicoRepository.findAllByAtivoIs(ativos.equals("true"));
        }
        else if(idInfluenciador != null && ativos == null){
            Influenciador influenciador = this.buscaInfluenciador(idInfluenciador);

            listServicos = servicoRepository.findAllByInfluenciadorOrderByAtivoDescDataFimAsc(influenciador);
        }
        else if(idInfluenciador != null && ativos != null){
            Influenciador influenciador = this.buscaInfluenciador(idInfluenciador);

            listServicos = servicoRepository.findAllByInfluenciadorAndAtivoIsOrderByAtivoDescDataFimAsc(influenciador, ativos.equals("true"));
        }

        if(listServicos.isEmpty()){
            throw new RecursoNaoEncontradoException(NENHUM_SERVICO_ENCONTRADO);
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

        Servico servico = optionalServico.orElseThrow(() -> new RecursoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));
        servico.mudarStatus();

        return servicoRepository.save(servico);
    }

    public Servico atualizarServico(Integer id, ServicoDto servicoDto){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        optionalServico.orElseThrow(() -> new RecursoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));

        Servico servico = new Servico(servicoDto);
        servico.setId(id);
        servico.setAtivo(optionalServico.get().isAtivo());

        Optional<Influenciador> optionalInfluenciador = influenciadorRepository.findById(servicoDto.getInfluenciadorId());
        Influenciador influenciador = optionalInfluenciador.orElseThrow(() -> new RecursoNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));

        servico.setInfluenciador(influenciador);

        return servicoRepository.save(servico);
    }

    public Servico deletarServico(Integer id){
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        Servico servico = optionalServico.orElseThrow(() -> new RecursoNaoEncontradoException(SERVICO_NAO_ENCONTRADO));

        servicoRepository.delete(servico);

        return servico;
    }

    private Influenciador buscaInfluenciador(Integer id){
        Optional<Influenciador> optionalInfluenciador = influenciadorRepository.findById(id);

        return optionalInfluenciador.orElseThrow(() -> new RecursoNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));
    }
}
