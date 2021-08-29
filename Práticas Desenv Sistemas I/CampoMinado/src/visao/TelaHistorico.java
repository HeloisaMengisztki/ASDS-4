package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaHistorico extends JPanel {
    private final GridBagConstraints constrains = new GridBagConstraints();
    private final GridBagLayout grid = new GridBagLayout();
    public final int horizontal = GridBagConstraints.HORIZONTAL;
    public final JTable table = montaTabelaHistorico();

    public TelaHistorico() {
        setLayout(grid);

        addComponent(new JLabel(getTextoTitulo()), 0, 0);
        addComponent(getSelectNiveis(), 1, 5);
        addComponent(montaTabelaHistorico(), 2, 5);
    }

    private JTable montaTabelaHistorico() {
        Object [][] dados = {
                {"20/05/2021", "00:00:12", "Fácil"},
                {"21/05/2021", "00:00:15", "Médio"},
                {"22/05/2021", "00:00:18", "Difícil"}
        };

        String [] colunas = {"Data", "Duração", "Nível"};
        return new JTable(dados, colunas);
    }

    private JComboBox getSelectNiveis() {
        String[] niveis = { "Fácil", "Médio", "Difícil", "Status" };

        var petList = new JComboBox(niveis);
        petList.setSelectedIndex(2);
        petList.addActionListener((event) -> BuscaInfoBanco(event));
        return petList;
    }

    private void BuscaInfoBanco(ActionEvent event) {
        switch (event.getActionCommand()){
            case "Fácil":
               //busca infos do banco
            case "Médio":
                //busca infos do banco
            case "Difícil":
                //busca infos do banco
        }
    }

    private String getTextoTitulo() {
        return "<html><h1>Histórico</h1></html>";
    }

    private void addComponent(Component comp, int row, int height) {
        constrains.fill = horizontal;
        constrains.gridy = row;
        constrains.gridx = 0;
        constrains.weightx = 0;
        constrains.weighty = height;
        constrains.insets = new Insets(5,5,5,5);

        grid.addLayoutComponent(comp, constrains);
        add(comp);
    }
}
