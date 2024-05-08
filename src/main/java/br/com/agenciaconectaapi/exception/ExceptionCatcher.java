package br.com.agenciaconectaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class ExceptionCatcher {
    public static ResponseEntity<?> collect(Exception e){
        System.out.println("======== EXCEPTION: " + e.getClass());
        System.out.println("======== EXCEPTION MESSAGE: " + e.getMessage());
        System.out.println("======== EXCEPTION CAUSE: " + e.getCause());
        System.out.println("======== EXCEPTION STACKTRACE: " + Arrays.toString(e.getStackTrace()));

        if(e.getClass() == InfluencerAlreadyExistsException.class || e.getClass() == InfluencerNotFoundException.class){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
