package visao;

import java.awt.GridLayout;
import java.sql.Time;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import historico.Historico;
import jogo.Tabuleiro;

public class TelaTabuleiro extends JPanel {

	public TelaTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.adicionarBotaoCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.adicionarObservadorEventos(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if (e.isGanhou()) {
					var historico = new Historico(
							new Date(System.currentTimeMillis()),
							new Time(System.currentTimeMillis()),
							new Time(System.currentTimeMillis()),
							tabuleiro.getNivel(),
							"Vitória"
					);
					JOptionPane.showMessageDialog(this, "Parabéns! Você ganhou!");
				}
				else {
					var historico = new Historico(
							new Date(System.currentTimeMillis()),
							new Time(System.currentTimeMillis()),
							new Time(System.currentTimeMillis()),
							tabuleiro.getNivel(),
							"Derrota"
					);
					JOptionPane.showMessageDialog(this, "Que pena... Você perdeu!");
				}
				
				tabuleiro.reiniciar();
			});
		});
	}
}
