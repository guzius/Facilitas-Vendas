package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes;

import java.util.Scanner;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Produtos.CatalogodeProdutos;

public class Pagamento {
	
	public void pagamento()
	{
        int opcaoMenu=0,opcaoMenuCarrinho=0,produtoID,op=0;

        CatalogodeProdutos catalogo = new CatalogodeProdutos();
        CarrinhodeCompras carrinho = new CarrinhodeCompras();
		Scanner leia = new Scanner (System.in);
		
		System.out.printf("\nEntre com o valor de pagamento : ");
        Double valorPagamento = leia.nextDouble();
         Double valorTotal = carrinho.totalProdutosPagar();
         while(!carrinho.validaPagamento(valorTotal, valorPagamento)){
                 System.out.println("O valor está é menor poderia adicionar novamente ? ");
                 System.out.printf("\nEntre com o valor de pagamento : ");
                 valorPagamento = leia.nextDouble();
         }
         carrinho.Pagamento(valorPagamento);
	}

}
