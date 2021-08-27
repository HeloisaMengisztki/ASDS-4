package visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import historico.Historico;
import modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.adicionarBotaoCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.adicionarObservadorEventos(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if (e.isGanhou()) {
					var historico = new Historico();
					JOptionPane.showMessageDialog(this, "Parab�ns! Voc� ganhou!");
				}
				else
					JOptionPane.showMessageDialog(this, "Que pena... Voc� perdeu!");
				
				tabuleiro.reiniciar();
			});
		});
	}
}
