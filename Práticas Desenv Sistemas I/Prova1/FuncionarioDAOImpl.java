import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    JDBC banco = new JDBC();

    @Override
    public void salvar(Funcionario funcionario) {
        String sql = "insert into funcionario values(?,?,?,?);";

        PreparedStatement preparedStatement = banco.prepareStatement(sql);
        try {
            preparedStatement.setInt(1, funcionario.getId());
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setString(3, funcionario.getProfissao());
            preparedStatement.setInt(4, funcionario.getSalario());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remover(Funcionario funcionario) {
        String sql = "delete from funcionario where id = " + funcionario.getId() + ";";
        executeUpdateSemRetorno(sql);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
//        String sql = "update funcionario set nome = " + funcionario.getNome() + ", profissao = " + funcionario.getProfissao() + ", salario = " + funcionario.getSalario() +
//                "where id = " + funcionario.getId() + ";";
        String sql = "update funcionario set nome = ?, profissao = ?, salario = ? where id = ?";

        PreparedStatement preparedStatement = banco.prepareStatement(sql);
        try {
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getProfissao());
            preparedStatement.setInt(3, funcionario.getSalario());
            preparedStatement.setInt(4, funcionario.getId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Funcionario> listar() {
        String sql = "Select * from funcionario;";
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Statement statement = banco.getStatement(sql);

        try {
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt(1));
                funcionario.setNome(result.getString(2));
                funcionario.setProfissao(result.getString(3));
                funcionario.setSalario(result.getInt(4));

                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    @Override
    public Funcionario buscarPorId(int id) {
        String sql = "Select * from funcionario where id = " + id + ";";
        Funcionario funcionario = new Funcionario();
        PreparedStatement statement = banco.prepareStatement(sql);

        try {
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                funcionario.setId(result.getInt(1));
                funcionario.setNome(result.getString(2));
                funcionario.setProfissao(result.getString(3));
                funcionario.setSalario(result.getInt(4));

                return funcionario;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return funcionario;
    }

    private void executeQuerySemRetorno(String sql) {
        Statement statement = banco.getStatement(sql);
        try {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void executeUpdateSemRetorno(String sql) {
        Statement statement = banco.getStatement(sql);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
