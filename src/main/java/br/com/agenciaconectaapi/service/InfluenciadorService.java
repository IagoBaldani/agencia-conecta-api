package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InfluenciadorService {

    @Autowired
    private InfluenciadorRepository influenciadorRepository;

    public Influenciador buscarInfluenciadorPorId(Integer idInfluenciador){

        Optional<Influenciador> optInfluenciador = influenciadorRepository.findById(idInfluenciador);

        return optInfluenciador.orElseThrow(() -> new RuntimeException("Influenciador nao encontrado."));
    }

    public List<Influenciador> buscaTodosInfluenciadores(){

        List<Influenciador> todosInfluencers = influenciadorRepository.findAll();

        if(todosInfluencers.isEmpty()){
            throw new RuntimeException("Nenhum influenciador cadastrado.");
        }

        return todosInfluencers;
    }

    public void criarInfluenciador(@Valid InfluenciadorDto influenciadorDto){

        Optional<Influenciador> optInfluencer = influenciadorRepository.findInfluenciadorByNomeContaining(influenciadorDto.getNome());

        optInfluencer.ifPresent((influenciador) -> {
            throw new RuntimeException("Influenciador ja cadastrado.");
        });

        Influenciador influenciador = new Influenciador(influenciadorDto);
        influenciadorRepository.save(influenciador);
    }

    private InfluenciadorDto criaInfluenciadorDto(){
        InfluenciadorDto influenciadorDto = new InfluenciadorDto();

        influenciadorDto.setNome("Livia Caroline");
        influenciadorDto.setCpf("123.456.789-10");
        influenciadorDto.setCelular("(14)99999-9999");
        influenciadorDto.setCidadeEstado("Londrina/PR");
        influenciadorDto.setEmail("liviacaroline@gmail.com");
        influenciadorDto.setEndereco("Rua Manoel Alves dos Santos, 185, Apto 1708");
        influenciadorDto.setDataContrato(LocalDate.of(2018, 2, 24));
        influenciadorDto.setDataNascimento(LocalDate.of(2002, 12, 6));
        influenciadorDto.setInstagram("@liviacarolines");
        influenciadorDto.setTiktok("@liviacarolines");
        influenciadorDto.setYoutube("www.youtube.com/liviacarolines");

        return influenciadorDto;
    }

}
