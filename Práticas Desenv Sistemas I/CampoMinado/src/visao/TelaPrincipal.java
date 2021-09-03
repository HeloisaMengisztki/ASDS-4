package visao;

import jogo.Tabuleiro;

import javax.swing.*;
import java.awt.*;


public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        add(mainPanel);
        mainPanel.add(new TelaInformacoes(), "info");
        mainPanel.add(new TelaHistorico(), "historico");
        mainPanel.add(new TelaTabuleiro(new Tabuleiro(8,10,15)), "facil");
        mainPanel.add(new TelaTabuleiro(new Tabuleiro(10,12,30)), "medio");
        mainPanel.add(new TelaTabuleiro(new Tabuleiro(12,14,45)), "dificil");

        configs(cardLayout, mainPanel);
    }

    private void configs(CardLayout cardLayout, JPanel mainPanel) {
        setTitle("Campo Minado");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setJMenuBar(createMenuBar(cardLayout, mainPanel));
        setVisible(true);
    }

    private JMenuBar createMenuBar(CardLayout cardLayout, JPanel mainPanel) {
        BarraMenu menuBar = new BarraMenu();
        menuBar.add(menuBar.createMenu(cardLayout, mainPanel));
        return menuBar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TelaPrincipal frame = new TelaPrincipal();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
