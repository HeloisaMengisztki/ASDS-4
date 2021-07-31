package aula1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		PessoaDAO banco = new PessoaDAOJDBC();

		Pessoa pessoa = new Pessoa(2, "João", "Silva", 72, "carpinteiro");

		banco.inserir(pessoa);

		ArrayList<Pessoa> pessoas = banco.listar();

		for (Pessoa p : pessoas) {
			System.out.println(p.getId() + " - " + p.getPrimeiroNome());
		}		
		
		Pessoa pessoaAtt = new Pessoa(2, "João Maria", "Silva", 72, "Pintor");
		banco.atualizar(pessoaAtt);
		banco.remover(pessoa);
	}
}
