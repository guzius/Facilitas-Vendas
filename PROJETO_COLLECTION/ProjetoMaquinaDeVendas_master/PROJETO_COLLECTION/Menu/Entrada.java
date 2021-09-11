package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Menu;

import java.util.Scanner;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Funcionarios.Funcionario;

public class Entrada {

	public void entrada() throws Exception{
		
		int opcao;
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|            SEJA BEM-VINDO            |");
		System.out.println(
			"| 01 - Cliente                         |\n" +
			"| 02 - Funcionário                     |");
		System.out.println("+--------------------------------------+");
		System.out.print("Opção escolhida: ");
		opcao = leitor.nextInt();
		
		switch(opcao)
		{
		case 1:
			Cliente cliente = new Cliente();
			cliente.cliente();
			break;
		case 2:
			Funcionario funcionario = new Funcionario("","");
			funcionario.funcionario();
			break;
		default:
			System.out.println("Opção Inválida! Escolha outra opção: ");
			opcao = leitor.nextInt();
			
		}

	}
}
