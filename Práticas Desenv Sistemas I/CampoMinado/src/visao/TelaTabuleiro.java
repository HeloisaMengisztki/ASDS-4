package visao;

import java.awt.GridLayout;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import historico.Historico;
import historico.HistoricoRepository;
import jogo.Tabuleiro;

public class TelaTabuleiro extends JPanel {

    public TelaTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        var historico = new Historico(new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), tabuleiro.getNivel());

        tabuleiro.adicionarBotaoCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.adicionarObservadorEventos(e -> {

            SwingUtilities.invokeLater(() -> {
                Time time = new Time(System.currentTimeMillis());
                if (e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Parabéns! Você ganhou!");
                    historico.setFim(time);
                    historico.setStatus("Vitória");
                } else {
                    JOptionPane.showMessageDialog(this, "Que pena... Você perdeu!");
                    historico.setFim(time);
                    historico.setStatus("Derrota");
                }

                historico.calculaDuracao();
                var historicoRepository = new HistoricoRepository();
                historicoRepository.inserir(historico);

                tabuleiro.reiniciar();
            });
        });
    }
}
