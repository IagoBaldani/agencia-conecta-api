package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = AutenticacaoService.class)
class AutenticacaoServiceTest {

    @InjectMocks
    AutenticacaoService service;

    @Mock
    UsuarioRepository userRepository;

    @Mock
    UserDetails userDetail;

    @Test
    void testDeletarSevico(){
        when(userRepository.findByLogin(any())).thenReturn(userDetail);

        UserDetails response = service.loadUserByUsername(any());

        Assertions.assertNotNull(response);
    }
}