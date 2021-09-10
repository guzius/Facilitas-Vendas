package ProjetoMaquinaDeVendas.PROJETO_COLLECTION;


import ProjetoMaquinaDeVendas.Classes.Produtos.CatalogodeProdutos;
import ProjetoMaquinaDeVendas.Classes.CarrinhodeCompras;
import ProjetoMaquinaDeVendas.Classes.Produtos.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String args[])
    {
        int opcaoMenu=0,opcaoMenuCarrinho=0,produtoID;

        CatalogodeProdutos catalogo = new CatalogodeProdutos();
        CarrinhodeCompras carrinho = new CarrinhodeCompras();

        catalogo.apresentarCatalogoProdutos();






/*
        while (opcaoMenu<= 3)
        {

            System.out.println("-1 Visualizar meu carrinho");
            System.out.println("-2 Adicionar Produtos no carrinho");
            System.out.println("-3 Remover Produtos do carrinho");
            System.out.println("-4 Retornar ao menu principal");
            opcaoMenu = leia.nextInt();

             switch (opcaoMenu)
             {
                case 1:
                    do{

                        System.out.println("\n ------ Meu carrinho -------");
                        System.out.println("\n-1 Visualizar meu carrinho");
                        System.out.println("\n-2 Adicionar Produtos no carrinho");
                        System.out.println("\n-3 Remover Produtos do carrinho");
                        System.out.println("\n-4 Retornar ao menu principal");

                        opcaoMenuCarrinho = leia.nextInt();
                        switch (opcaoMenuCarrinho)
                        {
                            case 1: carrinho.mostrarProdutosCarrinho(); break;

                            case 2:
                                produtoID = leia.nextInt();
                                carrinho.AdicionarProdutoCarrinho(catalogo.getProdutodoCatalogo(2)); break;

                            case 3:
                                produtoID = leia.nextInt();
                                carrinho.removerProdutoCarrinho(produtoID);
                        }

                        }while (opcaoMenuCarrinho<3);
                 break;

                case 2:
                    break;
                case 3:
                    break;

         }
    }




        /* List<String> lista = new ArrayList<String>();
         List<Produto> produtos = new ArrayList<Produto>();

         lista.add("OKOK");
         lista.add("TESTANDO2");

        produtos.add(new Produto("chocolate",5.0,"25/10/2022",10));
        produtos.add(new Produto("banana",5.0,"25/10/2022",10));

        for (Produto a: produtos){
        System.out.println(a.getNome());
        }
        for (String a: lista){
            System.out.println(a);
        }

        for(int i=0; i< produtos.size(); i++){
            System.out.println("produto o " + produtos.get(i).getNome() + " está no index " + i);
        }
*/

}




}
