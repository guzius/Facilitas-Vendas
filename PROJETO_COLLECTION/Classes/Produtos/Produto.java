package ProjetoMaquinaDeVendas.Classes.Produtos;


public class Produto {

    private String nome;
    private Double preco;
    private String validade;
    private int quantidadeEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidadeEstoque;
    }

    public void setQuantidade(int quantidade) {
        this.quantidadeEstoque = quantidade;
    }

}
