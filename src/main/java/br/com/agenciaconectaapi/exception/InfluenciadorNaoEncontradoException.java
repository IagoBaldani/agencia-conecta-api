package br.com.agenciaconectaapi.exception;

public class InfluenciadorNaoEncontradoException extends RuntimeException{

    public InfluenciadorNaoEncontradoException(String msg, Throwable err){
        super(msg, err);
    }
    public InfluenciadorNaoEncontradoException(String msg){
        super(msg);
    }
}
