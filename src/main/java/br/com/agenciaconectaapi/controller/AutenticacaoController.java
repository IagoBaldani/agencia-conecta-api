package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.config.TokenService;
import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.dto.UsuarioDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Usuario;
import br.com.agenciaconectaapi.service.AutenticacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static br.com.agenciaconectaapi.util.Constantes.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    private final AutenticacaoService autenticacaoService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> criarUsuario(@RequestBody UsuarioDto usuarioDto){
        try {
            UsuarioDto usuarioCriado = autenticacaoService.criarUsuario(usuarioDto);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(USUARIO_CRIADO, usuarioCriado));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> efetuarLogin(@RequestBody UsuarioDto usuarioDto){
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuarioDto.login(), usuarioDto.senha());
            Authentication authentication;
            try {
                authentication = manager.authenticate(authToken);
            } catch (InternalAuthenticationServiceException e) {
                throw new BadCredentialsException(USUARIO_NAO_ENCONTRADO);
            }

            String jwtToken = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(LOGIN_CONCLUIDO, jwtToken));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/auth/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> validarToken(@PathVariable(value = "token") String token){
        try {
            tokenService.validarTokenERetornarSubject(token);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(TOKEN_VALIDADO, true));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

}
