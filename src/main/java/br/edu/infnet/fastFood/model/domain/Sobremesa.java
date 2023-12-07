package br.edu.infnet.fastFood.model.domain;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sobremesa extends Produto{

        private float quantidade;

        private boolean doce;

        private String informacao;

        public Sobremesa(String nome, float valor, int codigo, float quantidade, boolean doce, String informacao){
            this.setNome(nome);
            this.setValor(valor);
            this.setCodigo(codigo);
            this.quantidade = quantidade;
            this.doce = doce;
            this.informacao = informacao;
        }

        @Override
        public void preparar(){
            System.out.println("Preparando a sobremesa");
        }

}
