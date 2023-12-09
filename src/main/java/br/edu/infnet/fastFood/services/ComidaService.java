package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Comida;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ComidaService implements CrudInterface<Comida> {

    Map<Integer, Comida> comidas = initComida();
    private static int idComida = 1;
    private static int idMapa = 1;

    private Map<Integer, Comida> initComida(){
        Comida comida = new Comida("",1,0,0,false,"");
        Map<Integer, Comida> comidas = new HashMap<>();
        int id = idMapa++;
        comidas.put(id,comida);
        return comidas;
    }

    @Override
    public List<Comida> getAll(){
        return this.comidas.values().stream().toList();
    }

    @Override
    public void delete(int id){
        comidas.remove(id);
    }

    @Override
    public void create(Comida comida){
        int id = idComida++;
        comida.setCodigo(id);
        comidas.put(id,comida);
    }

    @Override
    public void update(int id, Comida novaComida){
        novaComida.setCodigo(id);
        comidas.replace(id, novaComida);
    }

    @Override
    public Comida getById(int id){
        return this.comidas.get(id);
    }

}
