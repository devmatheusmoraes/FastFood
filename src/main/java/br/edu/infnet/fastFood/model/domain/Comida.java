package br.edu.infnet.fastFood.model.domain;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comida extends Produto{

    private float peso;
    private boolean vegano;
    private String ingredientes;

    public Comida(String nome, float valor, int codigo, float peso, boolean vegano, String ingredientes){
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.ingredientes = ingredientes;
        this.peso = peso;
        this.vegano = vegano;
    }

    @Override
    public void preparar(){

        System.out.println("Preparando a comida.");
    }
}
