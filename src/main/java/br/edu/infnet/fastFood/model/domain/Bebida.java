package br.edu.infnet.fastFood.model.domain;

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
        this.tamanho = tamanho;
        this.marca = marca;
    }

    @Override
    public void preparar(){
        System.out.println("Preparando a bebida.");
    }

}
