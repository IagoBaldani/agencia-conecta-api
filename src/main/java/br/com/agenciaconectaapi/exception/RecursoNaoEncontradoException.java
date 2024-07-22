package br.com.agenciaconectaapi.exception;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException(String msg, Throwable err){
        super(msg, err);
    }
    public RecursoNaoEncontradoException(String msg){
        super(msg);
    }
}
