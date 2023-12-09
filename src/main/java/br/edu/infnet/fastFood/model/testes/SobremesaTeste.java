package br.edu.infnet.fastFood.model.testes;

import br.edu.infnet.fastFood.model.domain.Sobremesa;

public class SobremesaTeste {

    public static void main(String[] args){
        Sobremesa sobremesaTeste1 = new Sobremesa("Sorvete", 12,0,  1, false, "Coco");
        Sobremesa sobremesaTeste2 = new Sobremesa("Bolo", 15, 1, 2, false, "chocolate");
        Sobremesa sobremesaTeste3 = new Sobremesa("Picole", 5, 2, 3, false, "Limao");
    }

}
