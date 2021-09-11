package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION;


import java.io.IOException;
import java.util.Scanner;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.CarrinhodeCompras;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Produtos.CatalogodeProdutos;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Funcionarios.Funcionario;


public class Main {
    public static void main(String args[]) throws Exception {
        int opcaoMenu=0,opcaoMenuCarrinho=0,produtoID, opcaoMenuFuncionario = 0;
        String usuario, senha;
        
        CatalogodeProdutos catalogo = new CatalogodeProdutos();
        CarrinhodeCompras carrinho = new CarrinhodeCompras();
        Scanner leia = new Scanner(System.in);

        while (opcaoMenu<= 4)
        {

            System.out.println("--------   MAQUINA DE VENDAS   ----------");
            System.out.println("\tDigite a opcao desejada\n");
            System.out.println("-1 COMPRAR PRODUTOS");
            System.out.println("-2 MEU CARRINHO");
            System.out.println("-2 VER CATALOGO");
            System.out.println("-3 REALIZAR PAGAMENTO");
            System.out.println("-4 ADMINISTRATIVO \n");
            System.out.print("Entre com a opcao : ");
            opcaoMenu = leia.nextInt();

             switch (opcaoMenu)
             {
                case 1:
                    catalogo.apresentarCatalogoProdutos();
                    System.out.println("\n -- DIGITE O ID DO PRODUTO QUE DESEJA COMPRAR---");
                    produtoID = leia.nextInt();
                    carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(produtoID));
                  break;

                case 2:
                    do{

                        System.out.println(" -------------- | CARRINHO OPCOES | ---------------");
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
                       System.out.printf("\nEntre com o valor de pagamento : ");
                       Double valorPagamento = leia.nextDouble();
                        Double valorTotal = carrinho.totalProdutosPagar();
                        while(!carrinho.validaPagamento(valorTotal, valorPagamento)){
                                System.out.println("O valor está a menor poderia adicionar novamente ? ");
                                System.out.printf("\nEntre com o valor de pagamento : ");
                                valorPagamento = leia.nextDouble();
                        }
                        carrinho.Pagamento(valorPagamento);
                    break;
                case 4 :
                	System.out.println("--------   Administtrativo  ----------");
                	System.out.print("Qual o seu nome : ");
                	usuario = leia.next();
                	System.out.print("Qual a sua senha : ");
                	senha = leia.next();
                	
                	Funcionario funcionario = new Funcionario(usuario,senha);
                	if(funcionario.FuncAutenticar(senha)) {
                		System.out.println("\n\nUsuario Autenticado");
                		
                		System.out.println("Digite a opcao desejada\n");
                        System.out.println("-1 Adicionar Produto");
                        System.out.println("-2 Remover Produto");
                        
                        System.out.print("Entre com a opcao : ");
                        opcaoMenuFuncionario = leia.nextInt();
                        
                        while(!(opcaoMenuFuncionario==1 || opcaoMenuFuncionario==2)) {
                        	System.out.print("\nOpção invalida ! ");
                        	System.out.print("\nEntre com a opcao : ");
                        	opcaoMenuFuncionario = leia.nextInt();
                        }
                        
                        switch(opcaoMenuFuncionario) {
                        	case 1 :
                        		String nome, validade; 
                        		Double preco;
                        		int quantidade;
                        		
                        		System.out.print("\nEntre com o nome do produto : ");
                        		nome = leia.next();
                        		System.out.print("\nEntre com o preco : ");
                        		preco = leia.nextDouble();
                        		System.out.print("\nEntre com a validade : ");
                        		validade = leia.next();
                        		System.out.print("\nEntre com a qtde : ");
                        		quantidade = leia.nextInt();
                        		
                        		try {
                        		 catalogo.AdicionarProduto(nome, preco, validade, quantidade);
                        		} catch(Exception e) {
                        			throw new Exception("Erro ao cadastrar o produto");
                        		}
                        		
                        		System.out.println("Produtos Atuais no carrinho :");
                        		catalogo.apresentarCatalogoProdutos();
                        		
                        		break;
                        	
                        	case 2 :
                        		System.out.println("\nOs produtos em Estoque");
                        		catalogo.apresentarCatalogoProdutos();
                        		System.out.print("\nQual produto deseja apagar : ");
                        		produtoID = leia.nextInt();
                        		
                        		catalogo.removeProdutoCatalogo(produtoID);
                        		
                        		catalogo.apresentarCatalogoProdutos();
                        		break;
                        }  
                	}else {
                		System.out.println("Erro na autenticacao");
                		break;
                	}
                	
                break;

         }
    }

}




}
