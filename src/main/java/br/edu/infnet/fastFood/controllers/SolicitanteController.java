package br.edu.infnet.fastFood.controllers;

import br.edu.infnet.fastFood.model.domain.Solicitante;
import br.edu.infnet.fastFood.services.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {

    private SolicitanteService solicitanteService;

    Logger logger = LoggerFactory.getLogger(SolicitanteController.class);

    @Autowired
    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
        logger.info("SolicitanteController construído com sucesso.");
    }

    @GetMapping
    public List<Solicitante> getAll(){
        logger.info("Método getAll iniciado");
        List<Solicitante> listaSolicitante = solicitanteService.getAll();
        return listaSolicitante;
    }

    @GetMapping("/{id}")
    public Solicitante getById(@PathVariable int id){
        logger.info("Método getById iniciado");
        Solicitante solicitante = solicitanteService.getById(id);
        return solicitante;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Solicitante atualizado) {
        logger.info("Método update iniciado");
        solicitanteService.update(id,atualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Método delete iniciado: " + id);
        this.solicitanteService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Solicitante solicitante){
        logger.info("Método create iniciado: " + solicitante);
        this.solicitanteService.create(solicitante);
    }

}
