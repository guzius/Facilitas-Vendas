package ProjetoMaquinaDeVendas;


import ProjetoMaquinaDeVendas.Classes.Carrinho_Pagamento.CarrinhodeCompras;
import ProjetoMaquinaDeVendas.Classes.Menu.Principal;
import ProjetoMaquinaDeVendas.Classes.Produtos.CatalogodeProdutos;


public class Main {
    public static void main(String args[]) throws Exception {
    	CatalogodeProdutos catalogo = new CatalogodeProdutos();
		CarrinhodeCompras carrinho = new CarrinhodeCompras();
  
    	Principal principal = new Principal(carrinho,catalogo);
    	principal.entrada();
 
    }
}