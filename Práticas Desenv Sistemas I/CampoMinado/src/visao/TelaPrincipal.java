package visao;

import modelo.Tabuleiro;

import javax.swing.*;


public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		
		Tabuleiro tabuleiroFacil = new Tabuleiro(8, 10, 20);

		//todo implementar nivel

		add(new TelaSelecaoNivel(tabuleiroFacil));
		add(new PainelTabuleiro(tabuleiroFacil));

		configs();
	}

	private void configs() {
		setTitle("Campo Minado");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
