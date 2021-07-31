package aula1;

import java.util.ArrayList;

public interface PessoaDAO {
	
	public void inserir(Pessoa pessoa);
	
	public void remover(Pessoa pessoa);
	
	public void atualizar(Pessoa pessoa);
	
	public ArrayList<Pessoa> listar();
}
