package br.com.agenciaconectaapi.exception;

import br.com.agenciaconectaapi.dto.RetornoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionCatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatcher.class);

    public static ResponseEntity<RetornoDto> collect(Exception e){
        RetornoDto retornoDto = new RetornoDto(e.getMessage(),e);
        LOGGER.trace(e.getMessage(), e);

        if(e.getClass() == InfluenciadorJaExisteException.class || e.getClass() == InfluenciadorNaoEncontradoException.class){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retornoDto);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(retornoDto);
        }
    }
}