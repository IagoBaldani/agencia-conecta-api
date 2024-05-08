package br.com.agenciaconectaapi.exception;

public class InfluencerNotFoundException extends RuntimeException{

    public InfluencerNotFoundException(String msg, Throwable err){
        super(msg, err);
    }
    public InfluencerNotFoundException(String msg){
        super(msg);
    }
}
