package br.edu.infnet.fastFood.model.domain;

import br.edu.infnet.fastFood.exceptions.BebidaException;
import br.edu.infnet.fastFood.exceptions.ComidaException;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comida extends Produto{

    private float peso;
    private boolean vegano;
    private String ingredientes;

    public Comida(String nome, float valor, int codigo, float peso, boolean vegano, String ingredientes){
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.ingredientes = ingredientes;
        this.peso = peso;
        this.vegano = vegano;

        try {
            setPeso(peso);
        } catch (ComidaException e) {
            System.out.println("Erro ao configurar o peso da comida: " + e.getMessage());
        }
    }

    public void setPeso(float peso) throws ComidaException {
        if (peso <= 0) {
            throw new ComidaException("O peso da comida deve ser maior que zero.");
        }
        this.peso = peso;
    }
    @Override
    public void preparar(){
        System.out.println("Preparando a comida.");
    }
}
