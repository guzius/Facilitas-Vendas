package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Funcionarios;

import java.util.Scanner;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Menu.Entrada;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Autenticar.Autenticar;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.CarrinhodeCompras;
import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Classes.Produtos.CatalogodeProdutos;

public class Funcionario implements Autenticar {
	
	private int desejaContinuar=0;
	private String nome;

	public Funcionario(String nome,String senha) {
		this.nome = nome;
	}
	
	@Override
	public boolean FuncAutenticar(String senha) {
		if(Autenticar.senhaAcesso.equals(senha)) {
			return true;
		}else {
		return false;
		}
	}
	
	public void funcionario() throws Exception
	{
		 String usuario, senha;
		 int opcaoMenuFuncionario = 0, produtoID;
		 
		 Scanner leia = new Scanner(System.in);
		 CatalogodeProdutos catalogo = new CatalogodeProdutos();
	       CarrinhodeCompras carrinho = new CarrinhodeCompras();
		
    	System.out.println("--------   Administtrativo  ----------");
    	System.out.print("Qual o seu nome : ");
    	usuario = leia.next();
    	System.out.print("Qual a sua senha : ");
    	senha = leia.next();
    	
    	Funcionario funcionario = new Funcionario(usuario,senha);
    	if(funcionario.FuncAutenticar(senha)) {
    		System.out.println("\n\nUsuario Autenticado");
    	do {
    		System.out.println("Digite a opcao desejada\n");
            System.out.println("-1 Adicionar Produto");
            System.out.println("-2 Remover Produto");
            
            System.out.print("Entre com a opcao : ");
            opcaoMenuFuncionario = leia.nextInt();
            
            while(!(opcaoMenuFuncionario==1 || opcaoMenuFuncionario==2)) {
            	System.out.print("\nOp��o invalida ! ");
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
            	System.out.printf("Deseja fazer mais algum processo ?");
            	System.out.printf("\n 1 - Sim\n 2 - N�o ");
            	System.out.print("\nOp��o Escolhida :");
            	desejaContinuar = leia.nextInt();
            	
            	while(!(desejaContinuar==1 || desejaContinuar==2)) {
            		System.out.print("\nOp��o invalida ! ");
            		System.out.print("\nOp��o Escolhida :");
                	desejaContinuar = leia.nextInt();
            	}
            	
    		}while(desejaContinuar==1);
  
       }else {
    		System.out.println("Erro na autenticacao");
    		Entrada entrada = new Entrada();
        	entrada.entrada();
    	 }
    	System.out.println("\nSaindo da parte administrativa!\n");
    	Entrada entrada = new Entrada();
    	entrada.entrada();
	}
}
