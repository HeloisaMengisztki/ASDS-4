package aula1;

public class Pessoa {
	private int id;
	private String primeiroNome;
	private String ultimoNome;
	private int idade;
	private String profissao;
	
	public Pessoa() {}
	
	public Pessoa(int id, String primeiroNome, String ultimoNome, int idade, String profissao) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.idade = idade;
		this.profissao = profissao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
}
