package br.com.agenciaconectaapi.exception;

public class ServicoNaoEncontradoException extends RuntimeException{

    public ServicoNaoEncontradoException(String msg, Throwable err){
        super(msg, err);
    }
    public ServicoNaoEncontradoException(String msg){
        super(msg);
    }
}
