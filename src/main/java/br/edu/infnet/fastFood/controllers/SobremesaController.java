package br.edu.infnet.fastFood.controllers;


import br.edu.infnet.fastFood.model.domain.Sobremesa;

import br.edu.infnet.fastFood.services.SobremesaService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sobremesa")
public class SobremesaController {

    private SobremesaService sobremesaService;

    Logger logger = LoggerFactory.getLogger(SobremesaController.class);

    @Autowired
    public SobremesaController(SobremesaService sobremesaService) {
        this.sobremesaService = sobremesaService;
        logger.info("SobremesaController construído com sucesso.");
    }

    @GetMapping
    public List<Sobremesa> getAll(){
        logger.info("Método getAll iniciado");
        List<Sobremesa> listaSobremesa = sobremesaService.getAll();
        return listaSobremesa;
    }

    @GetMapping("/{id}")
    public Sobremesa getById(@PathVariable int id){
        logger.info("Método getById iniciado");
        Sobremesa sobremesa = sobremesaService.getById(id);
        return sobremesa;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Sobremesa atualizado) {
        logger.info("Método update iniciado");
        sobremesaService.update(id,atualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Método delete iniciado: " + id);
        this.sobremesaService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Sobremesa sobremesa){
        logger.info("Método create iniciado: " + sobremesa);
        this.sobremesaService.create(sobremesa);
    }

}
