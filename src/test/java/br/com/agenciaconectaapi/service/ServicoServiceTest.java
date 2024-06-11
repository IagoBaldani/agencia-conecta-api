package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.ServicoNaoEncontradoException;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.repository.InfluenciadorRepository;
import br.com.agenciaconectaapi.repository.ServicoRepository;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ServicoService.class)
class ServicoServiceTest {

    @InjectMocks
    ServicoService service;

    @Mock
    ServicoRepository servicoRepository;

    @Mock
    InfluenciadorRepository influenciadorRepository;

    @Mock
    Influenciador influenciador;

    @Mock
    Servico servico;

    @Mock
    ServicoDto servicoDto;

    @Mock
    List<Servico> listaServicosMock;

    List<Servico> listaServicoVazia = new ArrayList<>();

    @Test
    void testBuscaServicoPorId(){
        when(servicoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(servico));

        Servico response = service.buscaServicoPorId(anyInt());

        Assertions.assertEquals(servico, response);
    }

    @Test
    void testBuscarTodosServicos(){
//        when(servicoRepository.findAllByAtivoIs(anyBoolean())).thenReturn(listaServicosMock);
//
//        List<Servico> response = service.buscarTodosServicos(anyBoolean());
//
//        Assertions.assertEquals(listaServicosMock, response);
    }

    @Test
    void testIFBuscarTodosServicos(){
//        when(servicoRepository.findAllByAtivoIs(anyBoolean())).thenReturn(listaServicoVazia);
//
//        Assertions.assertThrows(ServicoNaoEncontradoException.class, () -> service.buscarTodosServicos(anyBoolean()));
    }

    @Test
    void testBuscarServicosPorInfluenciador(){
//        when(influenciadorRepository.findById(anyInt())).thenReturn(Optional.ofNullable(influenciador));
//        when(servicoRepository.findAllByInfluenciadorOrderByAtivoDescDataFimAsc(any())).thenReturn(listaServicosMock);
//
//        List<Servico> response = service.buscarServicosPorInfluenciador(anyInt());
//
//        Assertions.assertEquals(listaServicosMock, response);
    }

    @Test
    void testIFBuscarServicosPorInfluenciador(){
//        when(influenciadorRepository.findById(anyInt())).thenReturn(Optional.ofNullable(influenciador));
//        when(servicoRepository.findAllByInfluenciadorOrderByAtivoDescDataFimAsc(any())).thenReturn(listaServicoVazia);
//
//        Assertions.assertThrows(ServicoNaoEncontradoException.class, () ->
//                service.buscarServicosPorInfluenciador(anyInt()));
    }

    @Test
    void testCriarServico(){
        when(influenciadorRepository.findById(anyInt())).thenReturn(Optional.ofNullable(influenciador));
        when(servicoRepository.save(any())).thenReturn(servico);

        Servico response = service.criarServico(servicoDto);

        Assertions.assertNotNull(response);
    }

    @Test
    void testAtualizarStatus(){
        when(servicoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(servico));
        when(servicoRepository.save(any())).thenReturn(servico);

        Servico response = service.atualizarStatus(anyInt());

        Assertions.assertNotNull(response);
    }

    @Test
    void testAtualizarServico(){
        when(servicoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(servico));
        when(influenciadorRepository.findById(anyInt())).thenReturn(Optional.ofNullable(influenciador));
        when(servicoRepository.save(any())).thenReturn(servico);

        Servico response = service.atualizarServico(anyInt(),servicoDto);

        Assertions.assertNotNull(response);
    }

    @Test
    void testDeletarSevico(){
        when(servicoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(servico));

        Servico response = service.deletarServico(anyInt());

        Assertions.assertNotNull(response);
    }
}
