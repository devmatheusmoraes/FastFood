package br.edu.infnet.fastFood.model.domain;



import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Solicitante {

    private int codigo;

    private String nome;

    private String cpf;

    private String email;

    private List<Pedido> listaDePedido;

    public Solicitante(String nome, String cpf, String email){
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Solicitante(String nome, String cpf, String email, Pedido pedido) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

        if (listaDePedido == null) {
            this.listaDePedido = new ArrayList<>();
            this.listaDePedido.add(pedido);
        }else {
            listaDePedido.add(pedido);
        }
    }

    public void adicionarPedido(Pedido pedido) {
        if (listaDePedido == null) {
            listaDePedido = new ArrayList<>();
        }
        listaDePedido.add(pedido);
    }
}
