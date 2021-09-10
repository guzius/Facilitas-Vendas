package ProjetoMaquinaDeVendas-master;

import ProjetoMaquinaDeVendas2.VetorProduto;

import java.util.Scanner;

public class Menu extends VetorProduto {
	
	private int op;
	
	public Menu(int op)
	{
		this.op = op;
	}
	
	
	
	public int getOp() {
		return op;
	}



	public void setOp(int op) {
		this.op = op;
	}



	public void menuOpcoes()
	{
		String carrinho[] = new String[10];
		int totalPagar=0;
		int x=0;
		
		Scanner leia = new Scanner(System.in);
		while(op==2)
		{
			System.out.println("\n\t\t***Escolha sua opção***");
			System.out.println("\n1--Refrigerante \n2-- Chocolate \n3-- Água \n4-- Energético \n5-- M&M's");
			op = leia.nextInt();
			
			while(op<1 || op>5)
			{
				System.out.println("\nOpção Invalida!! Entre com uma nova opção: ");
				op = leia.nextInt();
			}
		
	
		switch(op)
		{
			case 1:
				carrinho[x] = "Refrigerante";
				totalPagar+=3;
				x++;
				break;
			case 2:
				carrinho[x] = "Chocolate";
				totalPagar+=3.99;
				x++;
				break;
			case 3:
				carrinho[x] = "Água";
				totalPagar+=2;
				x++;
				break;
			case 4:
				carrinho[x] = "Energético";
				totalPagar+=3.50;
				x++;
				break;
			case 5:
				carrinho[x] = "M&M's";
				totalPagar+=7.99;
				x++;
				break;
				
			default:
				System.out.println("\nOpção Inválida!!!");
				
		}
		System.out.println("\n\t\t***Deseja comprar continuar compra?*** \n1-- Sim \n2-- Não");
		op = leia.nextInt();
		}

		
	}


}
