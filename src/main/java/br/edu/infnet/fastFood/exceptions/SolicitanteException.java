package br.edu.infnet.fastFood.exceptions;

public class SolicitanteException extends RuntimeException {

    public SolicitanteException(String mensagem) {
        super(mensagem);
    }

    public SolicitanteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
