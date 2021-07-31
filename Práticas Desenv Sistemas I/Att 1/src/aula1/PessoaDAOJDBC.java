package aula1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PessoaDAOJDBC implements PessoaDAO {

	private JDBCUtil banco;

	public PessoaDAOJDBC() {
		banco = new JDBCUtil();
	}

	@Override
	public void inserir(Pessoa pessoa) {
		String sql = "insert into pessoa values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement preparedStatement = banco.getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, pessoa.getId());
			preparedStatement.setString(2, pessoa.getUltimoNome());
			preparedStatement.setString(3, pessoa.getPrimeiroNome());
			preparedStatement.setInt(4, pessoa.getIdade());
			preparedStatement.setString(5, pessoa.getProfissao());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Pessoa pessoa) {
		String sql = "delete from pessoa where id=?;";

		try {
			PreparedStatement preparedStatement = banco.getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, pessoa.getId());

			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Pessoa pessoa) {


		String sql = "update pessoa set primeiroNome=?, ultimoNome=?, idade=?, profissao=? where id=?;";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, pessoa.getPrimeiroNome());
			preparedStatement.setString(2, pessoa.getUltimoNome());
			preparedStatement.setInt(3, pessoa.getIdade());
			preparedStatement.setString(4, pessoa.getProfissao());
			preparedStatement.setInt(5, pessoa.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Pessoa> listar() {

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "select * from pessoa;";

		try {
			Statement statement = banco.getConnection().createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt(1));
				pessoa.setUltimoNome(resultSet.getString(2));
				pessoa.setPrimeiroNome(resultSet.getString(3));
				pessoa.setIdade(resultSet.getInt(4));
				pessoa.setProfissao(resultSet.getString(5));

				pessoas.add(pessoa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pessoas;
	}
}