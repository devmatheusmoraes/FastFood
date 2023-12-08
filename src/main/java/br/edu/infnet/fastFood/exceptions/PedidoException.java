package br.edu.infnet.fastFood.exceptions;

public class PedidoException extends RuntimeException {

    public PedidoException(String mensagem) {
        super(mensagem);
    }

    public PedidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

