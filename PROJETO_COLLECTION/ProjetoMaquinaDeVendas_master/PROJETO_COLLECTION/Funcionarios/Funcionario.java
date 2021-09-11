package ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Funcionarios;

import ProjetoMaquinaDeVendas_master.PROJETO_COLLECTION.Autenticar.Autenticar;

public class Funcionario implements Autenticar {
	
	
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
}
