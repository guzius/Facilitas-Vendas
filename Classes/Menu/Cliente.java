package ProjetoMaquinaDeVendas.Classes.Menu;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ProjetoMaquinaDeVendas.Classes.Carrinho_Pagamento.CarrinhodeCompras;
import ProjetoMaquinaDeVendas.Classes.Produtos.CatalogodeProdutos;

public class Cliente {

	private CatalogodeProdutos catalogo;
	private CarrinhodeCompras carrinho;

	

	public Cliente() {
		super();
	}



	public Cliente(CarrinhodeCompras carrinho,CatalogodeProdutos catalogo) {
		super();
		this.catalogo = catalogo;
		this.carrinho = carrinho;
	}

	
	public void cliente() throws Exception {
        int opcaoMenu=0,produtoID;
        Scanner leia = new Scanner(System.in);
		
		while (opcaoMenu<= 4)
        {
			System.out.println("\n");
			System.out.println("+--------------------------------------+");
			System.out.println("|           MENU PRINCIPAL             |");
			System.out.println("+--------------------------------------+");
			System.out.println("\tDigite a opcao desejada\n");
            System.out.println("-1 COMPRAR PRODUTOS");
            System.out.println("-2 MEU CARRINHO");
            System.out.println("-3 VER CATALOGO");
            System.out.println("-4 REALIZAR PAGAMENTO");
		System.out.println("-5 SAIR DO PROGRAMA");
            System.out.println("+--------------------------------------+");
            System.out.print("Entre com a opcao : ");
            opcaoMenu = leia.nextInt();

             switch (opcaoMenu)
             {
                case 1:
                    int opcaoComprar=0;

                	do {
                		catalogo.apresentarCatalogoProdutos();
                        System.out.print("\nDIGITE O ID DO PRODUTO QUE DESEJA COMPRAR : ");
                        produtoID = leia.nextInt();
                        carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(produtoID));
                        System.out.println("\nPRODUTO ADICIONADO AO CARRINHO COM SUCESSO! \nDESEJA CONTINUAR COMPRANDO?");
                        System.out.println("\n1-- Continuar Comprando \n2-- Retornar ao menu do cliente");
                        System.out.print("Entre com a opção : ");
                        opcaoComprar = leia.nextInt();
                		
                	}while(opcaoComprar!=2);
                	cliente();

                break;
                case 2:
                    int opcaoMenuCarrinho=0;
                	do{
                        System.out.println("\n+--------------------------------------+");
                        System.out.println("|           CARRINHO DE COMPRAS        |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("Digite a opcao desejada");
                        System.out.println("-1 VISUALIZAR CARRINHO");
                        System.out.println("-2 ADICIONAR MAIS UM PRODUTOS");
                        System.out.println("-3 REMOVER PRODUTOS");
                        System.out.println("-4 RETORNAR AO MENU PRINCIPAL\n");
			System.out.println("-5 SAIR DO PROGRAMA");
                        System.out.print("Entre com a opcao : ");
                        opcaoMenuCarrinho = leia.nextInt();

                                switch (opcaoMenuCarrinho)
                                {
                                    case 1: carrinho.mostrarProdutosCarrinho();
                                        System.out.println("\t\tAperte enter para continuar");
                                        System.in.read();
                                    break;

                                    case 2:
                                    	catalogo.apresentarCatalogoProdutos();
                                        System.out.print("\nDIGITE O ID DO PRODUTO QUE DESEJA COMPRAR : ");
                                        produtoID = leia.nextInt();
                                        carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(produtoID));
                                        System.out.println("\nPRODUTO ADICIONADO AO CARRINHO COM SUCESSO!");
                                        break;

                                    case 3:
                                        int opcaoRemover =0;
                                        do {
                                            carrinho.mostrarProdutosCarrinho();
                                            System.out.print("Digite o ID DO PRODUTO A REMOVER : ");
                                            produtoID = leia.nextInt();
                                            carrinho.removerProdutoCarrinho(produtoID);
                                            System.out.println("\nPRODUTO REMOVIDO DO CARRINHO COM SUCESSO!");
                                            System.out.println("\n1-- Continuar removendo  \n2-- Retornar ao menu do carrinho");
                                            System.out.print("Entre com a opcao : ");
                                            opcaoRemover = leia.nextInt();
                                        }while(opcaoRemover==1);
                                }

                            }while (opcaoMenuCarrinho<=3);
                             cliente();
                    break;

                case 3:
                	CatalogodeProdutos catalogo1 = new CatalogodeProdutos();
                	catalogo1.apresentarCatalogoProdutos();
                    cliente();
                    break;

                case 4:

                  	Double valorTotal = carrinho.totalProdutosPagar();
                  	System.out.println("O valor total da sua compra : "+valorTotal);
                  	
                  	System.out.println("Qual a forma de pagamento ? ");
                  	System.out.println("1 - Dinheiro");
                  	System.out.println("2 - PIX");
                  	System.out.println("3 - Cartão de Débitto");
                  	System.out.println("4 - Cartão de Crédito \n");
                  	System.out.print("Opção selecionada : ");
                  	produtoID = leia.nextInt();
                  	
                  	System.out.printf("\nEntre com o valor de pagamento : ");
                    Double valorPagamento = leia.nextDouble();

                     while(!carrinho.validaPagamento(valorTotal, valorPagamento))
                     {
                             System.out.println("O valor é inferior do que o pagamento total poderia adicionar novamente ?\nSeu dinheiro foi devolvido ");
                             System.out.printf("\nEntre com o valor de pagamento : ");
                             valorPagamento = leia.nextDouble();
                     }

                     carrinho.Pagamento(valorPagamento);

                     System.out.printf("\nSUA COMPRA FOI FINALIZADA! OBRIGADE POR USAR NOSSO SISTEMA =D \n");
                     System.out.println("Retornando ao menu Inicial em 3 Segundos \n");
                     TimeUnit.SECONDS.sleep(3);
                     Principal principal = new Principal(carrinho,catalogo);
                     principal.entrada();

                     System.out.printf("\nSUA COMPRA FOI FINALIZADA! OBRIGADE POR USAR NOSSO SISTEMA =D ");
		break;
		case 5:
                	Principal principal1 = new Principal(carrinho,catalogo);
    			principal1.entrada();


                 break;
               } 
             break;

         }
    }
}
