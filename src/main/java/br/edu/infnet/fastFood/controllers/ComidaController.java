package br.edu.infnet.fastFood.controllers;

import br.edu.infnet.fastFood.model.domain.Comida;

import br.edu.infnet.fastFood.services.ComidaService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comida")
public class ComidaController {

    private ComidaService comidaService;

    Logger logger = LoggerFactory.getLogger(ComidaController.class);

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
        logger.info("ComidaController construído com sucesso.");
    }

    @GetMapping
    public List<Comida> getAll(){
        logger.info("Método getAll iniciado");
        List<Comida> listaComida = comidaService.getAll();
        return listaComida;
    }

    @GetMapping("/{id}")
    public Comida getById(@PathVariable int id){
        logger.info("Método getById iniciado");
        Comida comida = comidaService.getById(id);
        return comida;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Comida atualizado) {
        logger.info("Método update iniciado");
        comidaService.update(id,atualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Método delete iniciado: " + id);
        this.comidaService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Comida comida){
        logger.info("Método create iniciado: " + comida);
        this.comidaService.create(comida);
    }

}
