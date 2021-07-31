
import java.util.List;

public class Main {

	public static void imprimir(List<Funcionario> lista) {
		System.out.println("Imprimindo lista...");
		for(Funcionario funcionario : lista) {
			imprimirFuncionario(funcionario);
		}
		System.out.println("");
	}

	public static void imprimirFuncionario(Funcionario funcionario) {
		System.out.print(funcionario.getId() + " ");
		System.out.print(funcionario.getNome()+ " ");
		System.out.print(funcionario.getProfissao() + " ");
		System.out.println(funcionario.getSalario() );
	}
	

	public static void main(String[] args) {

		FuncionarioDAO banco = new FuncionarioDAOImpl(); 
			
		imprimir(banco.listar());

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setProfissao("Contador");
		funcionario.setSalario(1500);
		
		banco.salvar(funcionario);
		
		imprimir(banco.listar());
	
		System.out.println("Imprimindo antes de atualizar");
		Funcionario funcionario2  = banco.buscarPorId(1);
		imprimirFuncionario(funcionario2);
		
		funcionario2.setSalario(5000);
		banco.atualizar(funcionario2);
		
		System.out.println("Imprimindo depois de atualizar");
		imprimirFuncionario(banco.buscarPorId(1));
	
		System.out.println("\nImprimindo antes de remover");
		imprimir(banco.listar());

		banco.remover(funcionario2);
		
		System.out.println("Imprimindo depois de remover");
		imprimir(banco.listar());
		
	}

}

//SAIDA ESPERADA
//Imprimindo lista...
//1 Paulo Engenheiro 2000
//2 Andre Programador 2000
//3 Julia Gerente 2500
//4 Pedro Advogado 2500
//
//Imprimindo lista...
//1 Paulo Engenheiro 2000
//2 Andre Programador 2000
//3 Julia Gerente 2500
//4 Pedro Advogado 2500
//5 João Contador 1500
//
//Imprimindo antes de atualizar
//1 Paulo Engenheiro 2000
//Imprimindo depois de atualizar
//1 Paulo Engenheiro 5000
//
//Imprimindo antes de remover
//Imprimindo lista...
//1 Paulo Engenheiro 5000
//2 Andre Programador 2000
//3 Julia Gerente 2500
//4 Pedro Advogado 2500
//5 João Contador 1500
//
//Imprimindo depois de remover
//Imprimindo lista...
//2 Andre Programador 2000
//3 Julia Gerente 2500
//4 Pedro Advogado 2500
//5 João Contador 1500

