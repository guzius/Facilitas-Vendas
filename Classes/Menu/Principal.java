package ProjetoMaquinaDeVendas.Classes.Menu;

import java.util.Scanner;

import ProjetoMaquinaDeVendas.Classes.Carrinho_Pagamento.CarrinhodeCompras;
import ProjetoMaquinaDeVendas.Classes.Funcionarios.Funcionario;
import ProjetoMaquinaDeVendas.Classes.Produtos.CatalogodeProdutos;

public class Principal {

	
	private CarrinhodeCompras carrinho;
	private CatalogodeProdutos catalogo;

	public Principal(CarrinhodeCompras carrinho, CatalogodeProdutos catalogo) {
		super();
		this.carrinho = carrinho;
		this.catalogo = catalogo;
	}

	public void entrada() throws Exception{
		
		int opcao;
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|            SEJA BEM-VINDO            |");
		System.out.println(
			"| 01 - Cliente                         |\n" +
			"| 02 - Funcionario                     |");
		System.out.println("+--------------------------------------+");
		System.out.print("Opcao escolhida: ");
		opcao = leitor.nextInt();
		
		switch(opcao)
		{
		case 1:
			Cliente cliente = new Cliente(carrinho,catalogo);
			cliente.cliente();
			break;
		case 2:
			Funcionario funcionario = new Funcionario(carrinho,catalogo);
			funcionario.funcionario();
			break;
		default:
			System.out.println("Opção Inválida! Escolha outra Opção: ");
			opcao = leitor.nextInt();
			
		}

	}
}
