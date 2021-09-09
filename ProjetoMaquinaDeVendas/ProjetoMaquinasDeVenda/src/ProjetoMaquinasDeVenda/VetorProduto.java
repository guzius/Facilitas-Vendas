package ProjetoMaquinasDeVenda;

public class VetorProduto {

	public void vetorProdutos()
	{
		Produto[] vetor = new Produto[5];
		
		vetor[0] = new Produto("Refrigerante",3,"dez/2021",10);
		vetor[1] = new Produto("Chocolate",(float) 3.99,"abril/2022",22);
		vetor[2] = new Produto("Água",2,"set/2022",15);
		vetor[3] = new Produto("Energético",(float) 3.50,"maio/2022",8);
		vetor[4] = new Produto("M&M's",(float) 7.99,"abril/2022",24);
		
		for(Produto roda:vetor)
		{
			roda.listaProdutos();
		}
		
		System.out.println("\n**********************************************");

		
	}


}
