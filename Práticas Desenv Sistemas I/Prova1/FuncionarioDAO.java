
import java.util.List;

public interface FuncionarioDAO {
	public void salvar(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public void atualizar(Funcionario funcionario);

	public List<Funcionario> listar();

	public Funcionario buscarPorId(int id);

}
