package ProjetoMaquinasDeVenda;

public class CarrinhoDeCompras extends Menu{
	
	public CarrinhoDeCompras(int op) {
		super(op);
	}

	public void carrinho()
	{
		CarrinhoDeCompras[] vetor = new CarrinhoDeCompras[10];
		
		for(Menu roda:vetor)
		{
			System.out.println(roda);
		}
		

		System.out.println("\n**********************************************");

		
	}

}
