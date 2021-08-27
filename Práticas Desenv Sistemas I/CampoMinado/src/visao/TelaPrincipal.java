package visao;

import modelo.Tabuleiro;

import javax.swing.*;


public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {

		Tabuleiro tabuleiroFacil = new Tabuleiro(8, 10, 20);
		add(new PainelTabuleiro(tabuleiroFacil));

		configs();
	}

	private void configs() {
		setTitle("Campo Minado");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setJMenuBar(createMenuBar());
		setUndecorated(true);
		setLocationByPlatform(true);
		setVisible(true);
	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("Inicio");
		JMenuItem newItem = new JMenuItem("Novo Jogo");
		fileMenu.add(newItem);
		JMenuItem openItem = new JMenuItem("Histórico");
		fileMenu.add(openItem);
		JMenuItem saveItem = new JMenuItem("Sobre");
		fileMenu.add(saveItem);
		JMenuItem sair = new JMenuItem("Sair");
		fileMenu.add(sair);
		return fileMenu;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		return menuBar;
	}

	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
