package br.com.agenciaconectaapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionCatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatcher.class);

    public static ResponseEntity<?> collect(Exception e){
        LOGGER.trace(e.getMessage(), e);

        if(e.getClass() == InfluencerAlreadyExistsException.class || e.getClass() == InfluencerNotFoundException.class){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
