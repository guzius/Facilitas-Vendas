package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION;

import java.util.Scanner;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.CarrinhodeCompras;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Pagamento;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Produtos.CatalogodeProdutos;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Funcionarios.Funcionario;

public class Cliente {
	
	public void cliente()
	{
        int opcaoMenu=0,opcaoMenuCarrinho=0,produtoID,op=0;
       
        
        CatalogodeProdutos catalogo = new CatalogodeProdutos();
        CarrinhodeCompras carrinho = new CarrinhodeCompras();
        Scanner leia = new Scanner(System.in);
		
		while (opcaoMenu<= 4)
        {

			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|           MAQUINA DE VENDAS          |");
			System.out.println("+--------------------------------------+");
			System.out.println("\tDigite a opcao desejada\n");
            System.out.println("-1 COMPRAR PRODUTOS");
            System.out.println("-2 MEU CARRINHO");
            System.out.println("-3 VER CATALOGO");
            System.out.println("-4 REALIZAR PAGAMENTO");
            System.out.println("+--------------------------------------+");
            System.out.print("Entre com a opcao : ");
            opcaoMenu = leia.nextInt();

             switch (opcaoMenu)
             {
                case 1:
                	
                	do {
                		
                		catalogo.apresentarCatalogoProdutos();
                        System.out.println("\n -- DIGITE O ID DO PRODUTO QUE DESEJA COMPRAR---");
                        produtoID = leia.nextInt();
                        carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(produtoID));
                        System.out.println("\nPRODUTO ADICIONADO AO CARRINHO COM SUCESSO! \n Deseja continuar comprando?");
                        System.out.println("\n1-- Continuar Comprando \n2-- Ir ao carrinho");
                        op = leia.nextInt();
                		
                	}while(op!=2);
                	carrinho.mostrarProdutosCarrinho();
                	Pagamento pagamento = new Pagamento();
                	pagamento.pagamento();
                	
                    break;
                case 2:
                	do{

                        System.out.println("\n -------------- | CARRINHO OPCOES | ---------------");
                        System.out.println("Digite a opcao desejada");
                        System.out.println("-1 Visualizar meu carrinho");
                        System.out.println("-2 Adicionar Produtos no carrinho");
                        System.out.println("-3 Remover Produtos do carrinho");
                        System.out.println("-4 Retornar ao menu principal\n");
                        System.out.print("Entre com a opcao : ");

                        opcaoMenuCarrinho = leia.nextInt();

                                switch (opcaoMenuCarrinho)
                                {
                                    case 1: carrinho.mostrarProdutosCarrinho(); break;

                                    case 2:
                                    	catalogo.apresentarCatalogoProdutos();
                                        System.out.print("\nDIGITE O ID DO PRODUTO QUE DESEJA COMPRAR : ");
                                        produtoID = leia.nextInt();
                                        carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(produtoID)); break;

                                    case 3:
                                        System.out.println("Digite o ID DO PRODUTO A REMOVER");
                                        produtoID = leia.nextInt();
                                        carrinho.removerProdutoCarrinho(produtoID);
                                }

                            }while (opcaoMenuCarrinho<=3);

                    break;
                case 3:
                	CatalogodeProdutos catalogo1 = new CatalogodeProdutos();
                	catalogo1.apresentarCatalogoProdutos();
                    break;
                case 4:
                	System.out.printf("\nEntre com o valor de pagamento : ");
                    Double valorPagamento = leia.nextDouble();
                     Double valorTotal = carrinho.totalProdutosPagar();
                     while(!carrinho.validaPagamento(valorTotal, valorPagamento)){
                             System.out.println("O valor est� a menor poderia adicionar novamente ? ");
                             System.out.printf("\nEntre com o valor de pagamento : ");
                             valorPagamento = leia.nextDouble();
                     }
                     carrinho.Pagamento(valorPagamento);
                 break;
               } 
             break;

         }
    }


		
	}
