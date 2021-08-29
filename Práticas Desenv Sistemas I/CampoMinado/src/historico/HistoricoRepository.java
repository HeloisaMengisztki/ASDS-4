package historico;

import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.ArrayList;
        import java.util.List;
        import javax.swing.JOptionPane;

public class HistoricoRepository {
    private final String INSERT = "INSERT INTO HISTORICO (DATA, DURACAO, NIVEL, STATUS) VALUES (?,?,?)";
    private final String LIST = "SELECT * FROM HISTORICO";

    public void inserir(Historico historico) {
        if (historico != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setDate(1, historico.getData());
                pstm.setTime(2, historico.getDuracao());
                pstm.setString(3, historico.getNivel());
                pstm.setString(4, historico.getStatus());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso");
                FabricaConexao.fechaConexao(conn, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir contato no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            System.out.println("O contato enviado por parâmetro está vazio");
        }
    }

    public List<Historico> getAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Historico> historicos = new ArrayList<Historico>();
        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Historico historico = new Historico();

                historico.setData(rs.getDate("data"));
                historico.setDuracao(rs.getTime("duracao"));
                historico.setNivel(rs.getString("nivel"));
                historico.setStatus(rs.getString("status"));
                historicos.add(historico);
            }
            FabricaConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar historicos" + e.getMessage());
        }
        return historicos;
    }
}
