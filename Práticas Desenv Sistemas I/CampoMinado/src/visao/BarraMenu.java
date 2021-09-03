package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BarraMenu extends JMenuBar {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public JMenu createMenu(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        JMenu menu = new JMenu("Inicio");

        AdicionaLvlsGame(menu);
        AdicionaAbaHistorico(menu);
        AdicionaAbaSobre(menu);
        AdicionaBotaoSair(menu);

        return menu;
    }

    private void AdicionaLvlsGame(JMenu menu) {
        JMenuItem jogo = new JMenu("Novo Jogo");

        var facil = new JMenuItem("Fácil");
        facil.addActionListener(this::RedirecionaJogo);
        jogo.add(facil);

        var medio = new JMenuItem("Médio");
        medio.addActionListener(this::RedirecionaJogo);
        jogo.add(medio);

        var dificil = new JMenuItem("Difícil");
        dificil.addActionListener(this::RedirecionaJogo);
        jogo.add(dificil);


        menu.add(jogo);
    }

    private void AdicionaBotaoSair(JMenu fileMenu) {
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener((event) -> System.exit(0));
        fileMenu.add(sair);
    }

    private void AdicionaAbaHistorico(JMenu fileMenu) {
        JMenuItem openItem = new JMenuItem("Histórico");
        openItem.addActionListener(event -> RedirecionaHistorico());
        fileMenu.add(openItem);
    }

    private void AdicionaAbaSobre(JMenu fileMenu) {
        JMenuItem saveItem = new JMenuItem("Sobre");
        saveItem.addActionListener((event) -> RedirecionaSobre());
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
    }

    private void RedirecionaSobre() {
        cardLayout.show(mainPanel, "info");
    }

    private void RedirecionaHistorico() {
        cardLayout.show(mainPanel, "historico");
    }

    private void redirecionaLevel(String nomeFrame) {
        cardLayout.show(mainPanel, nomeFrame);
        revalidate();
        repaint();
    }

    private void RedirecionaJogo(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Fácil" -> redirecionaLevel("facil");
            case "Médio" -> redirecionaLevel("medio");
            case "Difícil" -> redirecionaLevel("dificil");
        }
    }
}
