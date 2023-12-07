package br.edu.infnet.fastFood.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Produto {

    private String nome;

    private float valor;

    private int codigo;

    public void preparar() {

    }

}
