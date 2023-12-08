package br.edu.infnet.fastFood.exceptions;

public class SobremesaException extends RuntimeException {

    public SobremesaException(String mensagem) {
        super(mensagem);
    }

    public SobremesaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
