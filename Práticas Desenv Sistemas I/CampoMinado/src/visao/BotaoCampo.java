package visao;

import modelo.Campo;
import modelo.CampoObservador;
import modelo.Eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotaoCampo extends JButton implements CampoObservador, MouseListener {

	private final Campo campo;

	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(PadroesCoresImagens.BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(1));
		
		addMouseListener(this);
		campo.adicionarObservador(this);
	}

	@Override
	public void ocorreuEvento(Campo campo, Eventos evento) {
		switch(evento) {
			case ABRIR:
				aplicarEstiloAbrir();
				break;
			case MARCAR:
				aplicarEstiloMarcar();
				break;
			case EXPLODIR:
				aplicarEstiloExplodir();
				break;
			default:
				aplicarEstiloPadrao();
		}
		
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
	}

	private void aplicarEstiloAbrir() {
		
		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		if (campo.isMinado()) {
			aplicarEstiloExplodir();
			return;
		}
		
		setBackground(PadroesCoresImagens.BG_ABERTO);
		setForeground(Color.gray);
		
		String valor = !campo.vizinhancaSegura() ?
				Integer.toString(campo.minasNaVizinhanca()) : null;
					
		setText(valor);
	}
	
	private void aplicarEstiloMarcar() {
		setBackground(PadroesCoresImagens.BG_MARCAR);
		setForeground(Color.BLACK);
		setText("B");
	}
	
	private void aplicarEstiloExplodir() {
		setBackground(Color.RED);
		setIcon(PadroesCoresImagens.ICON_BOMBA);
	}
	
	private void aplicarEstiloPadrao() {
		setBackground(PadroesCoresImagens.BG_PADRAO);
		setIcon(new ImageIcon());
		setBorder(BorderFactory.createBevelBorder(0));
		setText(null);
	}
	
	// Escuta os movimentos do mouse:
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1)
			campo.abrir();
		else
			campo.alternarMarcacao();
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
