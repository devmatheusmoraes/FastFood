package br.edu.infnet.fastFood.services;

import br.edu.infnet.fastFood.model.domain.Pedido;
import br.edu.infnet.fastFood.model.domain.Sobremesa;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SobremesaService implements CrudInterface<Sobremesa>{

    Map<Integer, Sobremesa> sobremesas = initSobremesa();
    private static int idSobremesa = 1;
    private static int idMapa = 1;

    private Map<Integer, Sobremesa> initSobremesa(){
        Sobremesa sobremesa = new Sobremesa("",1,0,0,false,"");
        Map<Integer, Sobremesa> sobremesas = new HashMap<>();
        int id = idMapa++;
        sobremesas.put(id,sobremesa);
        return sobremesas;
    }

    @Override
    public List<Sobremesa> getAll(){
        return this.sobremesas.values().stream().toList();
    }

    @Override
    public void delete(int id){
        sobremesas.remove(id);
    }

    @Override
    public void create(Sobremesa sobremesa){
        int id = idSobremesa++;
        sobremesa.setCodigo(id);
        sobremesas.put(id,sobremesa);
    }

    @Override
    public void update(int id, Sobremesa novaSobremesa){
        novaSobremesa.setCodigo(id);
        sobremesas.replace(id, novaSobremesa);
    }

    @Override
    public Sobremesa getById(int id){
        return this.sobremesas.get(id);
    }

}

