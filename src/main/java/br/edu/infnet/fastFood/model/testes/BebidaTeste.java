package br.edu.infnet.fastFood.model.testes;

import br.edu.infnet.fastFood.model.domain.Bebida;

public class BebidaTeste {

    public static void main(String[] args){

        Bebida bebidaTeste1 = new Bebida("coca", 10, 0, true, 2, "coca");
        Bebida bebidaTeste2 = new Bebida("pepsi", 20, 1,  true,  5,"pepsi");
        Bebida bebidaTeste3 = new Bebida("kuat", 30, 2,  false,  3,"kuat");
    }

}
