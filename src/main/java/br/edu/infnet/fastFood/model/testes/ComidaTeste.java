package br.edu.infnet.fastFood.model.testes;

import br.edu.infnet.fastFood.model.domain.Comida;

public class ComidaTeste {

    public static void main(String[] args){

        Comida comidaTeste1 = new Comida("carne", 100,0, 200, true, "alho");
        Comida comidaTeste2 = new Comida("Hamburgue", 50,1,  30, false, "Queijo");
        Comida comidaTeste3 = new Comida("Lasanha", 45,2,  23, false, "Presunto");
    }
}
