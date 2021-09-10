package Projeto;

import java.text.NumberFormat;

public class Produto {
	
	private String nome;
	private float preco;
	private String validade;
	private int quantidade;
	
	public Produto(String nome, float preco, String validade, int quantidade)
	{
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		this.quantidade = quantidade;
		
	}
	
	public String formatarMoeda()
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(2);
		String formatoMoeda = nf.format(preco);
		return formatoMoeda;
	}
	
	public void listaProdutos()
	{
		System.out.println("\n"+nome+"\nPreço: "+this.formatarMoeda()+"\nValidade: "+validade);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
