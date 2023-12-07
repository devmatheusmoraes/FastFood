package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Bebida;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BebidaService {

    Map<Integer, Bebida> bebidas = initBebida();
    private static int idBebida = 1;
    private static int idMapa = 1;

    private Map<Integer, Bebida> initBebida(){
        Bebida bebida = new Bebida("",0,0,false,0,"");
        Map<Integer, Bebida> bebidas = new HashMap<>();
        int id = idMapa++;
        bebidas.put(id,bebida);
        return bebidas;
    }

    public List<Bebida> getAll(){
        return this.bebidas.values().stream().toList();
    }
    
    public void delete(int id){
        bebidas.remove(id);
    }

    public void create(Bebida bebida){
        int id = idBebida++;
        bebida.setCodigo(id);
        bebidas.put(id,bebida);
    }

    public void update(int id, Bebida novaBebida){
        novaBebida.setCodigo(id);
        bebidas.replace(id, novaBebida);
    }

    public Bebida getById(int id){
        return this.bebidas.get(id);
    }
}
