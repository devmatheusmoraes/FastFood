package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Sobremesa;
import br.edu.infnet.fastFood.model.domain.Solicitante;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SolicitanteService implements CrudInterface<Solicitante>{

    Map<Integer, Solicitante> solicitantes = initSolicitante();
    private static int idMapa = 1;

    private Map<Integer, Solicitante> initSolicitante(){
        Solicitante solicitante = new Solicitante("","","");
        Map<Integer, Solicitante> solicitantes = new HashMap<>();
        int id = idMapa++;
        solicitante.setCodigo(id);
        solicitantes.put(id,solicitante);
        return solicitantes;
    }

    @Override
    public List<Solicitante> getAll(){
        return this.solicitantes.values().stream().toList();
    }

    @Override
    public void delete(int id){
        solicitantes.remove(id);
    }

    @Override
    public void create(Solicitante solicitante){
        int id = solicitante.getCodigo();
        solicitantes.put(id,solicitante);
    }

    @Override
    public void update(int id, Solicitante novoSolicitante){
        solicitantes.replace(id, novoSolicitante);
    }

    @Override
    public Solicitante getById(int id){
        return this.solicitantes.get(id);
    }
}
