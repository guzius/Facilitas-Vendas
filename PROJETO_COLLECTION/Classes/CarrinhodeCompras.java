package ProjetoMaquinaDeVendas.Classes;

import ProjetoMaquinaDeVendas.Classes.Produtos.Produto;

import java.util.ArrayList;
import java.util.List;

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
        int quantidadeCarrinho = carrinhodeCompras.size();

        if (quantidadeCarrinho<1)
        {
            return ("O seu carrinho está vazio");
        }
        else
        {
           this.carrinhodeCompras.remove(indexObjeto);
           return ("O produto foi removido com sucesso");

        }

    }

    public void mostrarProdutosCarrinho (){

        for (int i=0; i< carrinhodeCompras.size(); i++)
        {
               String nomeProduto = carrinhodeCompras.get(i).getNome();
               //CAPTURA NOME DO OBJETO ATRAVÉS DO INDEX ONDE ESTÁ ARMAZENADO NA LISTA LISTA (COLLETION)

               Double precoProduto = carrinhodeCompras.get(i).getPreco();
               //CAPTURA NOME DO OBJETO ATRAVÉS DO INDEX ONDE ESTÁ ARMAZENADO NA LISTA LISTA (COLLETION)

               int id_produto = i;
               //O ID DO PRODUTO SE REFERE AO INDEX DA COLETION ONDE O OBJETO ESTÁ ARMAZENADO

               System.out.println("ID: " + id_produto + "Produto: " + nomeProduto + "Valor: " +precoProduto);
        }

    }

    public void totalProdutosPagar (){

        for (int i=0; i< carrinhodeCompras.size(); i++)
        {

            this.total_a_pagar += carrinhodeCompras.get(i).getPreco();

        }

    }
}
