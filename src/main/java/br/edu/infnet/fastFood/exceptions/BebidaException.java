package br.edu.infnet.fastFood.exceptions;

public class BebidaException extends RuntimeException {

    public BebidaException(String mensagem) {
        super(mensagem);
    }

    public BebidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

