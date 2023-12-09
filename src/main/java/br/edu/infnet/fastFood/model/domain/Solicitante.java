package br.edu.infnet.fastFood.model.domain;



import br.edu.infnet.fastFood.exceptions.ProdutoException;
import br.edu.infnet.fastFood.exceptions.SolicitanteException;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

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

    private Set<String> telefones;

    private String[] enderecos;

    public Solicitante(String nome, String cpf, String email){
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = new HashSet<>();
        this.enderecos = new String[3];
    }

    public Solicitante(String nome, String cpf, String email, Pedido pedido) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = new HashSet<>();
        this.enderecos = new String[3];

        try {
            setEmail(email);
        }catch (SolicitanteException e) {
            System.out.println("Erro ao configurar o e-mail do solicitante: " + e.getMessage());
        }

        if (listaDePedido == null) {
            this.listaDePedido = new ArrayList<>();
            this.listaDePedido.add(pedido);
        }else {
            listaDePedido.add(pedido);
        }
    }

    public void setEmail(String email) throws SolicitanteException{
        Predicate<String> isValidEmail = emailAddress ->
                emailAddress.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        if (isValidEmail.test(email)) {
            this.email = email;
        } else {
            throw new SolicitanteException("O e-mail do solicitante é inválido.");
        }
    }
    public void adicionarPedido(Pedido pedido) {
        if (listaDePedido == null) {
            listaDePedido = new ArrayList<>();
        }
        listaDePedido.add(pedido);
    }

    public void adicionarEndereco(String endereco, int posicao) {
        if (posicao >= 0 && posicao < enderecos.length) {
            this.enderecos[posicao] = endereco;
        } else {
            System.out.println("Posição inválida para adicionar endereço.");
        }
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }
}
