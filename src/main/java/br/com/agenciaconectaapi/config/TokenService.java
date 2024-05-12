package br.com.agenciaconectaapi.config;

import br.com.agenciaconectaapi.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        Algorithm algoritmo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("API AGENCIA CONECTA")
                .withSubject(usuario.getLogin())
                .withExpiresAt(dataExpiracao())
                .sign(algoritmo);
    }

    public String validarTokenERetornarSubject(String token){
        Algorithm algoritmo = Algorithm.HMAC256(secret);

        return JWT.require(algoritmo)
                .withIssuer("API AGENCIA CONECTA")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}