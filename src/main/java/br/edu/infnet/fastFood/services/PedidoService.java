package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Pedido;
import br.edu.infnet.fastFood.model.domain.Sobremesa;
import br.edu.infnet.fastFood.model.domain.Solicitante;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PedidoService {

    Map<Integer, Pedido> pedidos = initPedido();
    private static int idMapa = 1;

    private Map<Integer, Pedido> initPedido(){
        Pedido pedido = new Pedido(new Sobremesa(), new Solicitante());
        Map<Integer, Pedido> pedidos = new HashMap<>();
        int id = idMapa++;
        pedido.setCodigo(id);
        pedidos.put(id,pedido);
        return pedidos;
    }

    public List<Pedido> getAll(){
        return this.pedidos.values().stream().toList();
    }

    public void delete(int id){
        pedidos.remove(id);
    }

    public void create(Pedido pedido){
        int id = pedido.getCodigo();
        pedidos.put(id,pedido);
    }

    public void update(int id, Pedido novoPedido){
        pedidos.replace(id, novoPedido);
    }

    public Pedido getById(int id){
        return this.pedidos.get(id);
    }

}
