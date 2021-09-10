package ProjetoMaquinaDeVendas-master.PROJETO_COLLECTION;


import ProjetoMaquinaDeVendas.Classes.Produtos.CatalogodeProdutos;
import ProjetoMaquinaDeVendas.Classes.CarrinhodeCompras;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws IOException {
        int opcaoMenu=0,opcaoMenuCarrinho=0,produtoID;

        CatalogodeProdutos catalogo = new CatalogodeProdutos();
        CarrinhodeCompras carrinho = new CarrinhodeCompras();
        Scanner leia = new Scanner(System.in);

        while (opcaoMenu<= 3)
        {

            System.out.println("-------- MAQUINA DE VENDAS ----------");
            System.out.println("Digite a opcao desejada");
            System.out.println("-1 COMPRAR PRODUTOS");
            System.out.println("-2 MEU CARRINHO");
            System.out.println("-2 VER CATALOGO");
            System.out.println("-3 REALIZAR PAGAMENTO \n");
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

                        opcaoMenuCarrinho = leia.nextInt();

                                switch (opcaoMenuCarrinho)
                                {
                                    case 1: carrinho.mostrarProdutosCarrinho(); break;

                                    case 2:
                                        System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA COMPRAR");
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
                       valorPagamento = leia.nextDouble();
         
                        while(!carrinho.validaPagamento(carrinho.totalProdutosPagar(), valorPagamento)){
                                System.out.println("O valor estÃ¡ a menor poderia adicionar novamente ? ");
                                System.out.printf("\nEntre com o valor de pagamento : ");
                                valorPagamento = leia.nextDouble();
                        }
                        carrinho.Pagamento(valorPagamento);
                    break;

         }
    }



}




}
