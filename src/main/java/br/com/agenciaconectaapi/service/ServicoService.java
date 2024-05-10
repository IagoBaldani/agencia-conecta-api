package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.InfluenciadorJaExisteException;
import br.com.agenciaconectaapi.exception.InfluenciadorNaoEncontradoException;
import br.com.agenciaconectaapi.exception.ServicoNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import br.com.agenciaconectaapi.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.*;

@Service
public class ServicoService {
    private final InfluenciadorRepository influenciadorRepository;
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository, InfluenciadorRepository influenciadorRepository) {
        this.servicoRepository = servicoRepository;
        this.influenciadorRepository = influenciadorRepository;
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
}
