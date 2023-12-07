package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Solicitante;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SolicitanteService {

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

    public List<Solicitante> getAll(){
        return this.solicitantes.values().stream().toList();
    }

    public void delete(int id){
        solicitantes.remove(id);
    }

    public void create(Solicitante solicitante){
        int id = solicitante.getCodigo();
        solicitantes.put(id,solicitante);
    }

    public void update(int id, Solicitante novoSolicitante){
        solicitantes.replace(id, novoSolicitante);
    }

    public Solicitante getById(int id){
        return this.solicitantes.get(id);
    }
}
