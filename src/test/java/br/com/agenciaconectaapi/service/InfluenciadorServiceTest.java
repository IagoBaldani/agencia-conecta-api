package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.exception.InfluenciadorJaExisteException;
import br.com.agenciaconectaapi.exception.InfluenciadorNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = InfluenciadorService.class)
class InfluenciadorServiceTest {

    @InjectMocks
    InfluenciadorService service;

    @Mock
    InfluenciadorRepository influenciadorRepository;

    @Mock
    Influenciador influenciador;

    @Mock
    InfluenciadorDto influenciadorDTO;

    @Mock
    List<Influenciador> listaInfluenciador;

    @Test
    void testBuscarInfluenciadorPorId(){
        when(influenciadorRepository.findById(any())).thenReturn(Optional.ofNullable(influenciador));

        Influenciador response = service.buscarInfluenciadorPorId(any());

        Assertions.assertNotNull(response);
    }

    @Test
    void testBuscaTodosInfluenciadoresEntraNoIF(){
        List<Influenciador> listaVazia = new ArrayList<>();
        when(influenciadorRepository.findAll()).thenReturn(listaVazia);

//        Assertions.assertThrows(InfluenciadorNaoEncontradoException.class, () -> service.buscaTodosInfluenciadores());
    }

    @Test
    void testBuscaTodosInfluenciadores(){
        when(influenciadorRepository.findAll()).thenReturn(listaInfluenciador);

//        List<Influenciador> response = service.buscaTodosInfluenciadores();
//
//        Assertions.assertNotNull(response);
    }

    @Test
    void testCriarInfluenciadorEntraNoIF(){
        when(influenciadorRepository.findInfluenciadorByNomeContaining(any())).thenThrow(InfluenciadorJaExisteException.class);

        Assertions.assertThrows(InfluenciadorJaExisteException.class, () -> service.criarInfluenciador(influenciadorDTO));
    }

    @Test
    void testCriarInfluenciador(){
        when(influenciadorRepository.save(any())).thenReturn(influenciador);

        Influenciador response = service.criarInfluenciador(influenciadorDTO);

        Assertions.assertNotNull(response);
    }
}