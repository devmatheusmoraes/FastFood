package br.edu.infnet.fastFood.model.domain;

import br.edu.infnet.fastFood.exceptions.PedidoException;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private String descricao;

    private LocalDateTime data;

    private boolean web;

    private List<Produto> listaDeProduto;

    private Solicitante solicitante;

    private int codigo;

    public Pedido(Produto produto, Solicitante solicitante){
        if (listaDeProduto == null){
            listaDeProduto = new ArrayList<>();
        }
        listaDeProduto.add(produto);
        this.solicitante = solicitante;
    }

    public void algumaOperacao() {
        // Alguma lógica aqui

        // Se algo der errado, lançar a exceção
        throw new PedidoException("Mensagem explicativa sobre o erro específico no Pedido");
    }
    public void adicionarProduto (Produto produto){
        listaDeProduto.add(produto);
    }

}
