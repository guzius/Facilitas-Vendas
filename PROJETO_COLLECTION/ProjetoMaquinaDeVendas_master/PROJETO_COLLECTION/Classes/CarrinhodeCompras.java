package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes;


import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Produtos.Produto;

public class CarrinhodeCompras {



    private Double total_a_pagar;
    private List<Produto> carrinhodeCompras = new ArrayList<Produto>();


    public String AdicionarProdutoCarrinho(Produto produto) //A FUNCAO RECEBE COMO PARAMETRO UM OBJETO DO TIPO PRODUTO
    {
        int quantidadeEstoqueProduto = produto.getQuantidade(); //CAPTURA QUANTIDADE DO PRODUTO NO ESTOQUE

        if (quantidadeEstoqueProduto<1)
        {
            return ("Desculpe, parece que o estoque deste produto esgotou :( ");
        }
        else
        {
            this.carrinhodeCompras.add(produto);
            return ("O produto" + produto.getNome() + "foi adicionado com sucesso");
        }

    }

    public String removerProdutoCarrinho (int indexObjeto)
    {
            //int quantidadeCarrinho = carrinhodeCompras.size();

           this.carrinhodeCompras.remove(indexObjeto);
           return ("O produto foi removido com sucesso");

        }



    public void mostrarProdutosCarrinho () throws IOException {
        System.out.println("\n+----------------------------------------+");
        System.out.println("|        PRODUTOS DO SEU CARRINHO        |");
        System.out.println("+----------------------------------------+");
        for (int i=0; i< carrinhodeCompras.size(); i++)
        {
               String nomeProduto = carrinhodeCompras.get(i).getNome();
               //CAPTURA NOME DO OBJETO ATRAV�S DO INDEX ONDE EST� ARMAZENADO NA LISTA LISTA (COLLETION)
               Double precoProduto = carrinhodeCompras.get(i).getPreco();
               //CAPTURA NOME DO OBJETO ATRAV�S DO INDEX ONDE EST� ARMAZENADO NA LISTA LISTA (COLLETION)
               int id_produto = i;
               //O ID DO PRODUTO SE REFERE AO INDEX DA COLETION ONDE O OBJETO EST� ARMAZENADO

               NumberFormat nf = NumberFormat.getCurrencyInstance();
               nf.setMinimumFractionDigits(2);
               String formatoMoeda = nf.format(precoProduto);
              System.out.println("ID: " + id_produto + " - " + nomeProduto + "\t\t(" +formatoMoeda+") ");

        }
        System.out.println("|----------------------------------------|");
        System.out.println("\t\t\tTOTAL A PAGAR: " + this.totalProdutosPagar());


    }

    public Double totalProdutosPagar (){

        this.total_a_pagar = 0.0;
        for (int i=0; i< carrinhodeCompras.size(); i++)
        {

            this.total_a_pagar += carrinhodeCompras.get(i).getPreco();

        }
        return total_a_pagar;
    }
    public boolean validaPagamento(Double valorTotal, Double valorPagamento ){
        if(valorTotal>valorPagamento){
            return false;
        }
        return true;
    }

    public void Pagamento(double valor) {
    	Double totalAPagar = this.total_a_pagar;
    	System.out.println("O valor total da compra é :"+totalAPagar);

    	if(valor < totalAPagar )
    	{
    		System.out.printf("\nO valor inserido é insuficiente");
    	}else
    	{
    		valor -= totalAPagar;
    		System.out.println("Pagamento efetuado com sucesso!!\nO seu troco é de :"+valor);
    	}
    }
    

    
}