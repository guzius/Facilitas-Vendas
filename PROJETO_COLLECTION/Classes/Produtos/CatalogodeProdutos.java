package ProjetoMaquinaDeVendas.Classes.Produtos;

import java.util.ArrayList;
import java.util.List;

public class CatalogodeProdutos extends Produto {

    private List<Produto> produtosdoCatalogo = new ArrayList<Produto>();

    public CatalogodeProdutos(){ // AO INSTANCIAR O OBJETO NA CLASSE MAIN AUTOMATICAMENTE CRIA UMA CATALOGO PADRAO
        this.adicionarCatalogoPadrao();
    }

    public Produto getProdutodoCatalogo(int id_produto){ //RETORNA UM OBJETO PRODUTO A PARTIR DO ID (INDEX)

        return  this.produtosdoCatalogo.get(id_produto);

    }

    public void setProdutosdoCatalogo(Produto objetoProduto)
    {
        this.produtosdoCatalogo.add(objetoProduto);
    }

    public void AdicionarProduto(String nome, Double preco, String validade, int quantidade){ //ADICIONA UM PRODUTO AO CATALOGO

        Produto novoProduto = new Produto();

        //Atribuindo valores no objeto produto;
        novoProduto.setNome(nome);
        novoProduto.setPreco(preco);
        novoProduto.setValidade(validade);
        novoProduto.setQuantidade(quantidade);

        setProdutosdoCatalogo(novoProduto); //Adiciona um Objeto de produto na colletion

        System.out.println("\nO produto: " + novoProduto.getNome() + " foi Adicionado no catalogo com sucesso ");

    }

    public void apresentarCatalogoProdutos()
    {
        for (int i=0; i< produtosdoCatalogo.size(); i++)
        {

            //VARIAVEIS AUXILIARES PRA USAR NO SYSTEM.OUT
            String nomeProduto = produtosdoCatalogo.get(i).getNome(); //CAPTURA NOME DO PRODUTO
            Double precoProduto = produtosdoCatalogo.get(i).getPreco(); //CAPTURA PRECO DO PRODUTO

            //O ID DO PRODUTO SE REFERE AO INDEX DA COLETION ONDE O OBJETO ESTÁ ARMAZENADO
            int id_produto = i;

            System.out.println("ID: " + id_produto + " Produto: " + nomeProduto + "Valor: " +precoProduto);
        }
    }

    public void adicionarCatalogoPadrao() //METODO AUXILIAR PRA ATRIBUIR ALGUNS PRODUTOS POR PADRAO NO CATALOGO
    {
        this.AdicionarProduto("Refrigerante", 3.0, "25/10/2022", 10);
        this.AdicionarProduto("Chocolate", 7.0, "25/10/2021", 5);
        this.AdicionarProduto("Agua", 2.0, "05/05/2022", 20);
        this.AdicionarProduto("Energético", 5.50, "05/05/2023", 1);
        this.AdicionarProduto("M$M'S", 5.50, "09/09/2021", 5);
    }







}

