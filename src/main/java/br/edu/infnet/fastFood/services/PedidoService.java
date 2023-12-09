package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Comida;
import br.edu.infnet.fastFood.model.domain.Pedido;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PedidoService implements CrudInterface<Pedido>{

    Map<Integer, Pedido> pedidos = new HashMap<>();
    private static int idMapa = 1;

    @Override
    public List<Pedido> getAll(){
        return this.pedidos.values().stream().toList();
    }

    @Override
    public void delete(int id){
        pedidos.remove(id);
    }

    @Override
    public void create(Pedido pedido){
        int id = idMapa++;
        pedido.setCodigo(id);
        pedidos.put(id,pedido);
    }

    @Override
    public void update(int id, Pedido novoPedido){
        pedidos.replace(id, novoPedido);
    }

    @Override
    public Pedido getById(int id){
        return this.pedidos.get(id);
    }

}
