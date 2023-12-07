package br.edu.infnet.fastFood.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public abstract class Produto {

    private String nome;

    private float valor;

    private int codigo;

    public abstract void preparar();
    public abstract String toString();

}
