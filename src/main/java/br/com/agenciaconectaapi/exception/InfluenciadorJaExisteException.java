package br.com.agenciaconectaapi.exception;

public class InfluenciadorJaExisteException extends RuntimeException{

    public InfluenciadorJaExisteException(String msg, Throwable err){
        super(msg, err);
    }
    public InfluenciadorJaExisteException(String msg){
        super(msg);
    }
}
