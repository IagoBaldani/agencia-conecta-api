package br.com.agenciaconectaapi.exception;

public class InfluencerAlreadyExistsException extends RuntimeException{

    public InfluencerAlreadyExistsException(String msg, Throwable err){
        super(msg, err);
    }
    public InfluencerAlreadyExistsException(String msg){
        super(msg);
    }
}
