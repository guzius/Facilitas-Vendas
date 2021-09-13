package ProjetoMaquinaDeVendas.Classes.Produtos;

import java.text.NumberFormat;
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
    
    public void removeProdutoCatalogo(int id_produto) throws Exception {
    	Produto produto = getProdutodoCatalogo(id_produto);
    	try {
    	 produtosdoCatalogo.remove(id_produto);
    	 System.out.println("Produto removido!");
    	}catch(Exception e) {
    		throw new Exception("Erro ao apagar o produto");
    	}
	
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
        setProdutosdoCatalogo(novoProduto); //Adiciona um Objeto de produto na

    }

    public void apresentarCatalogoProdutos()
    {
    	System.out.println("\n");
		System.out.println("+-----------------------------------------+");
		System.out.println("|                PRODUTOS                 |");
		System.out.println("+-----------------------------------------+");
    	
        for (int i=0; i< produtosdoCatalogo.size(); i++)
        {

            //VARIAVEIS AUXILIARES PRA USAR NO SYSTEM.OUT
            String nomeProduto = produtosdoCatalogo.get(i).getNome(); //CAPTURA NOME DO PRODUTO
            Double precoProduto = produtosdoCatalogo.get(i).getPreco(); //CAPTURA PRECO DO PRODUTO

            //O ID DO PRODUTO SE REFERE AO INDEX DA COLETION ONDE O OBJETO ESTÃƒï¿½ ARMAZENADO
            int id_produto = i;
            
            NumberFormat nf = NumberFormat.getCurrencyInstance();
    		nf.setMinimumFractionDigits(2);
    		String formatoMoeda = nf.format(precoProduto);
            System.out.println("|ID: " + id_produto + " - " + nomeProduto + "\t\t(" +formatoMoeda+") |");

        }
        System.out.println("+-----------------------------------------+");
    }

    public void adicionarCatalogoPadrao() //METODO AUXILIAR PRA ATRIBUIR ALGUNS PRODUTOS POR PADRAO NO CATALOGO
    {
        this.AdicionarProduto("Refrigerante", 3.0, "25/10/2022", 10);
        this.AdicionarProduto("Chocolate", 7.0, "25/10/2021", 5);
        this.AdicionarProduto("Agua", 2.0, "05/05/2022", 20);
        this.AdicionarProduto("Energético", 5.50, "05/05/2023", 1);
        this.AdicionarProduto("M&M'S", 5.50, "09/09/2021", 5);
    }
}

