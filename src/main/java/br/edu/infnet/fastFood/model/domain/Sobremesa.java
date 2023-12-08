package br.edu.infnet.fastFood.model.domain;
import br.edu.infnet.fastFood.exceptions.BebidaException;
import br.edu.infnet.fastFood.exceptions.ComidaException;
import br.edu.infnet.fastFood.exceptions.ProdutoException;
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
            this.doce = doce;
            this.informacao = informacao;

            try {
                setQuantidade(quantidade);
            } catch (SobremesaException e) {
                System.out.println("Erro ao configurar a quantidade da sobremesa: " + e.getMessage());
            }
        }
    public void setQuantidade(float quantidade) throws SobremesaException {
        if (quantidade <= 0) {
            throw new SobremesaException("A quantidade da sobremesa deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

        @Override
        public void preparar(){
            System.out.println("Preparando a sobremesa");
        }

}
