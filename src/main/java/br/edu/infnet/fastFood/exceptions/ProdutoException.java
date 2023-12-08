package br.edu.infnet.fastFood.exceptions;


public class ProdutoException extends RuntimeException {

    public ProdutoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
