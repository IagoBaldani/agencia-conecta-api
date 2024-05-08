package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.exception.InfluencerAlreadyExistsException;
import br.com.agenciaconectaapi.exception.InfluencerNotFoundException;
import br.com.agenciaconectaapi.model.CardInformacao;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.*;

@Service
public class InfluenciadorService {

    @Autowired
    private InfluenciadorRepository influenciadorRepository;

    public Influenciador buscarInfluenciadorPorId(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        return optInfluenciador.orElseThrow(() -> new InfluencerNotFoundException(INFLUENCIADOR_NAO_ENCONTRADO));
    }

    public List<Influenciador> buscaTodosInfluenciadores(){

        List<Influenciador> todosInfluencers = influenciadorRepository.findAll();

        if(todosInfluencers.isEmpty()){
            throw new InfluencerNotFoundException(NENHUM_INFLUENCIADOR_ENCONTRADO);
        }

        return todosInfluencers;
    }

    public void criarInfluenciador(InfluenciadorDto influenciadorDto){
        Optional<Influenciador> optInfluencer = influenciadorRepository.findInfluenciadorByNomeContaining(influenciadorDto.getNome());

        optInfluencer.ifPresent((influenciador) -> {
            throw new InfluencerAlreadyExistsException("Influenciador " + influenciador.getNome() + " ja cadastrado.");
        });

        Influenciador influenciador = new Influenciador(influenciadorDto);
        influenciadorRepository.save(influenciador);
    }

    public void criarInfluenciadoresEmLote(List<InfluenciadorDto> listInfluenciadorDto){
        listInfluenciadorDto.forEach((influenciadorDto) -> {
            Optional<Influenciador> optInfluencer = influenciadorRepository.findInfluenciadorByNomeContaining(influenciadorDto.getNome());

            optInfluencer.ifPresent((influenciador) -> {
                throw new InfluencerAlreadyExistsException(INFLUENCIADOR_JA_EXISTENTE);
            });

            Influenciador influenciador = new Influenciador(influenciadorDto);
            influenciadorRepository.save(influenciador);
        });
    }

    public void atualizarStatusInfluenciadorPorId(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        Influenciador influenciador = optInfluenciador.orElseThrow(() -> new InfluencerNotFoundException(INFLUENCIADOR_NAO_ENCONTRADO));

        influenciador.mudarStatus();
        influenciadorRepository.save(influenciador);
    }

    public void excluirInfluenciador(Integer idInfluenciador){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        optInfluenciador.orElseThrow(() -> new InfluencerNotFoundException(INFLUENCIADOR_NAO_ENCONTRADO));

        influenciadorRepository.delete(optInfluenciador.get());
    }

    public void atualizarInfluenciador(InfluenciadorDto influenciadorDto, Integer id){
        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(id);

        optInfluenciador.orElseThrow(() -> new InfluencerNotFoundException(INFLUENCIADOR_NAO_ENCONTRADO));

        Influenciador influenciador = new Influenciador(influenciadorDto);
        influenciador.setId(id);

        influenciadorRepository.save(influenciador);
    }

    public String buscaInformacaoCards(String descricaoCardProcurado){
        if(descricaoCardProcurado.equals(CardInformacao.NUMERO_INFLUENCIADORES_ATIVOS.getDescricao())){
            return influenciadorRepository.getNumeroInfluenciadoresAtivos();
        }
        else if(descricaoCardProcurado.equals(CardInformacao.INFLUENCIADOR_MAIS_ANTIGO.getDescricao())){
            return influenciadorRepository.findNomeInfluenciadorMaisAntigo();
        }
        else if(descricaoCardProcurado.equals(CardInformacao.INFLUENCIADOR_MAIS_RECENTE.getDescricao())){
            return influenciadorRepository.findNomeInfluenciadorMaisRecente();
        }

        throw new RuntimeException(CARD_NAO_ENCONTRADO);
    }

}
