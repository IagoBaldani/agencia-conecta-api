package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.dto.InfluenciadorSimplificadoDto;
import br.com.agenciaconectaapi.exception.InfluenciadorJaExisteException;
import br.com.agenciaconectaapi.exception.InfluenciadorNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.InfluenciadorProjection;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.*;

@Service
public class InfluenciadorService {

    private final InfluenciadorRepository influenciadorRepository;

    public InfluenciadorService(InfluenciadorRepository influenciadorRepository) {
        this.influenciadorRepository = influenciadorRepository;
    }

    public Influenciador buscarInfluenciadorPorId(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        return optInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));
    }

    public List<?> buscaTodosInfluenciadores(boolean buscaSimplificada){
        List<?> todosInfluencers;

        if(buscaSimplificada){
            List<InfluenciadorProjection> projections = influenciadorRepository.findAllProjectedBy();
            List<InfluenciadorSimplificadoDto> listaInfluenciadorSimplificado = new ArrayList<>();

            projections.forEach(projection -> {
                InfluenciadorSimplificadoDto influenciadorSimplificadoDto = new InfluenciadorSimplificadoDto(projection.getId(),
                        projection.getNome(),
                        projection.getCidadeEstado(),
                        projection.getAtivo());

                listaInfluenciadorSimplificado.add(influenciadorSimplificadoDto);
            });

            todosInfluencers = listaInfluenciadorSimplificado;
        }
        else{
            todosInfluencers = influenciadorRepository.findAll();
        }

        if(todosInfluencers.isEmpty()){
            throw new InfluenciadorNaoEncontradoException(NENHUM_INFLUENCIADOR_ENCONTRADO);
        }

        return todosInfluencers;
    }

    public Influenciador criarInfluenciador(InfluenciadorDto influenciadorDto){
        Optional<Influenciador> optInfluencer = influenciadorRepository.findInfluenciadorByNomeContaining(influenciadorDto.getNome());

        optInfluencer.ifPresent((influenciador) -> {
            throw new InfluenciadorJaExisteException("Influenciador " + influenciador.getNome() + " ja cadastrado.");
        });

        Influenciador influenciador = new Influenciador(influenciadorDto);
        return influenciadorRepository.save(influenciador);
    }

    public List<Influenciador> criarInfluenciadoresEmLote(List<InfluenciadorDto> listInfluenciadorDto){
        List<Influenciador> listaInfluenciadores = new ArrayList<>();

        listInfluenciadorDto.forEach((influenciadorDto) -> {
            Optional<Influenciador> optInfluencer = influenciadorRepository.findInfluenciadorByNomeContaining(influenciadorDto.getNome());

            optInfluencer.ifPresent((influenciador) -> {
                throw new InfluenciadorJaExisteException(INFLUENCIADOR_JA_EXISTENTE);
            });

            Influenciador influenciador = new Influenciador(influenciadorDto);
            influenciador = influenciadorRepository.save(influenciador);

            listaInfluenciadores.add(influenciador);
        });

        return listaInfluenciadores;
    }

    public Influenciador atualizarStatusInfluenciadorPorId(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        Influenciador influenciador = optInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));
        influenciador.mudarStatus();

        return influenciadorRepository.save(influenciador);
    }

    public Influenciador excluirInfluenciador(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        optInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));
        influenciadorRepository.delete(optInfluenciador.get());

        return optInfluenciador.get();
    }

    public Influenciador atualizarInfluenciador(InfluenciadorDto influenciadorDto, Integer id){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(id);

        optInfluenciador.orElseThrow(() -> new InfluenciadorNaoEncontradoException(INFLUENCIADOR_NAO_ENCONTRADO));

        Influenciador influenciador = new Influenciador(influenciadorDto);
        influenciador.setId(id);
        influenciador.setAtivo(optInfluenciador.get().isAtivo());

        return influenciadorRepository.save(influenciador);
    }
}
