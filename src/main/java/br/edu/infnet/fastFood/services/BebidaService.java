package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Bebida;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BebidaService implements CrudInterface<Bebida> {

    Map<Integer, Bebida> bebidas = initBebida();
    private static int idBebida = 1;
    private static int idMapa = 1;

    private Map<Integer, Bebida> initBebida(){
        Bebida bebida = new Bebida("",1,0,false,0,"");
        Map<Integer, Bebida> bebidas = new HashMap<>();
        int id = idMapa++;
        bebidas.put(id,bebida);
        return bebidas;
    }
    @Override
    public List<Bebida> getAll(){
        return this.bebidas.values().stream().toList();
    }

    @Override
    public void delete(int id){
        bebidas.remove(id);
    }

    @Override
    public void create(Bebida bebida){
        int id = idBebida++;
        bebida.setCodigo(id);
        bebidas.put(id,bebida);
    }

    @Override
    public void update(int id, Bebida novaBebida){
        novaBebida.setCodigo(id);
        bebidas.replace(id, novaBebida);
    }

    @Override
    public Bebida getById(int id){
        return this.bebidas.get(id);
    }
}
