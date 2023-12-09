package br.edu.infnet.fastFood.model.testes;

import br.edu.infnet.fastFood.model.domain.Bebida;
import br.edu.infnet.fastFood.model.domain.Comida;
import br.edu.infnet.fastFood.model.domain.Sobremesa;
import br.edu.infnet.fastFood.model.domain.Solicitante;
import br.edu.infnet.fastFood.model.domain.Pedido;

import java.time.LocalDateTime;

public class PedidoTeste {

    public static void main(String[] args){

        Solicitante solicitanteTeste1 = new Solicitante("Paulo", "11111122221", "paulo@gmail.com");
        Solicitante solicitanteTeste2 = new Solicitante("Luiz", "11122233345", "luiz@gmail.com");
        Solicitante solicitanteTeste3 = new Solicitante("Bruno", "22233344456", "bruno@gmail.com");

        Bebida bebidaTeste1 = new Bebida("coca", 10,0,  true, 15, "coca");
        Comida comidaTeste3 = new Comida("Lasanha", 45, 1,3,  false, "Presunto");
        Sobremesa sobremesaTeste1 = new Sobremesa("Sorvete", 12, 2,1,  false, "Coco");

        Pedido pedidoTeste1 = new Pedido("Mesa 02", LocalDateTime.now(), false, bebidaTeste1, solicitanteTeste1);
        Pedido pedidoTeste2 = new Pedido("Mesa 03", LocalDateTime.now(), false, comidaTeste3, solicitanteTeste2);
        Pedido pedidoTeste3 = new Pedido("Mesa 07", LocalDateTime.now(), false, sobremesaTeste1, solicitanteTeste3);

        Comida comidaTeste2 = new Comida("Hamburguer", 50,0,  30, false, "Queijo");
        pedidoTeste1.adicionarProduto(comidaTeste2);
    }

}
