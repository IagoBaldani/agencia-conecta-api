package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.config.TokenService;
import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.dto.UsuarioDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.agenciaconectaapi.util.Constantes.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> efetuarLogin(@RequestBody UsuarioDto usuarioDto){
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuarioDto.login(), usuarioDto.senha());
            Authentication authentication = manager.authenticate(authToken);

            String jwtToken = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(LOGIN_CONCLUIDO, jwtToken));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

}
