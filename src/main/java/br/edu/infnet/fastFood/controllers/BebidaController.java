package br.edu.infnet.fastFood.controllers;

import br.edu.infnet.fastFood.model.domain.Bebida;
import br.edu.infnet.fastFood.services.BebidaService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bebida")
public class BebidaController {

    private BebidaService bebidaService;

    Logger logger = LoggerFactory.getLogger(BebidaController.class);

    @Autowired
    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
        logger.info("BebidaController construído com sucesso.");
    }

    @GetMapping
    public List<Bebida> getAll(){
        logger.info("Método getAll iniciado");
        List<Bebida> listaBebida = bebidaService.getAll();
        return listaBebida;
    }

    @GetMapping("/{id}")
    public Bebida getById(@PathVariable int id){
        logger.info("Método getById iniciado");
        Bebida bebida = bebidaService.getById(id);
        return bebida;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Bebida atualizado) {
        logger.info("Método update iniciado");
        bebidaService.update(id,atualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Método delete iniciado: " + id);
        this.bebidaService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Bebida bebida){
        logger.info("Método create iniciado: " + bebida);
        this.bebidaService.create(bebida);
    }

}
