package br.edu.infnet.fastFood.model.domain;
import br.edu.infnet.fastFood.exceptions.SobremesaException;
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
    public void algumaOperacao() {
        // Alguma lógica aqui

        // Se algo der errado, lançar a exceção
        throw new SobremesaException("Mensagem explicativa sobre o erro específico na Sobremesa");
    }

        @Override
        public void preparar(){
            System.out.println("Preparando a sobremesa");
        }

}
