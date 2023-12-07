package br.edu.infnet.fastFood.model.domain;



import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Solicitante {

    private String nome;

    private String cpf;

    private String email;

    private List<Pedido> listaDePedido;

}
