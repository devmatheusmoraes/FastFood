package br.edu.infnet.fastFood.model.domain;


import br.edu.infnet.fastFood.exceptions.PedidoException;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pedido {

    private String descricao;

    private LocalDateTime data;

    private boolean web;

    private List<Produto> listaDeProduto;

    private Solicitante solicitante;

    private int codigo;

    public Pedido(String descricao, LocalDateTime data, boolean web, List<Produto> listaDeProduto, Solicitante solicitante, int codigo) {
        this.descricao = descricao;
        this.web = web;
        this.listaDeProduto = listaDeProduto;
        this.solicitante = solicitante;
        this.codigo = codigo;

        try {
            setData(data);
        } catch (PedidoException e) {
            System.out.println("Erro ao configurar a data do pedido: " + e.getMessage());
        }
    }

    public Pedido(Produto produto, Solicitante solicitante){
        this.solicitante = solicitante;
        this.listaDeProduto = new ArrayList<>();
        listaDeProduto.add(produto);

        /*if (listaDeProduto == null){
            listaDeProduto = new ArrayList<>();
        }*/

        /*listaDeProduto.add(produto);
        this.solicitante = solicitante;*/
    }

    public void setData(LocalDateTime data) throws PedidoException {
        LocalDateTime dataAtualFinalDoDia = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX);

        if (data.isAfter(dataAtualFinalDoDia)) {
            throw new PedidoException("Não é permitido lançar data futura.");
        }
        this.data = data;
    }
    public void adicionarProduto (Produto produto){
        listaDeProduto.add(produto);
    }

}
