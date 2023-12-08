package br.edu.infnet.fastFood.controllers;

import br.edu.infnet.fastFood.model.domain.Pedido;
import br.edu.infnet.fastFood.services.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
        logger.info("PedidoService construído com sucesso.");
    }

    @GetMapping
    public List<Pedido> getAll(){
        logger.info("Método getAll iniciado");
        List<Pedido> listaPedido = pedidoService.getAll();
        return listaPedido;
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable int id){
        logger.info("Método getById iniciado");
        Pedido pedido = pedidoService.getById(id);
        return pedido;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Pedido atualizado) {
        logger.info("Método update iniciado");
        pedidoService.update(id,atualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Método delete iniciado: " + id);
        this.pedidoService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Pedido pedido) {
        logger.info("Método create iniciado: " + pedido);
        this.pedidoService.create(pedido);
    }

}
