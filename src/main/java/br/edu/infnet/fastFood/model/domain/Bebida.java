package br.edu.infnet.fastFood.model.domain;

import br.edu.infnet.fastFood.exceptions.BebidaException;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bebida extends Produto{

    private boolean gelada;

    private float tamanho;

    private String marca;

    public Bebida(String nome, float valor, int codigo, boolean gelada, float tamanho, String marca){
        super();
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.gelada = gelada;
        this.marca = marca;

        try {
            setTamanho(tamanho);
        } catch (BebidaException e) {
            System.out.println("Erro ao configurar o tamanho da bebida: " + e.getMessage());
        }

    }

    @Override
    public void preparar(){
        System.out.println("Preparando a bebida.");
    }

    public void setTamanho(float tamanho) throws BebidaException {
        if (tamanho <= 0) {
            throw new BebidaException("O tamanho da bebida deve ser maior que zero.");
        }
        this.tamanho = tamanho;
    }
}
