package visao;

import historico.Historico;
import historico.HistoricoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaHistorico extends JPanel {
    private final GridBagConstraints constrains = new GridBagConstraints();
    private final GridBagLayout grid = new GridBagLayout();
    public final int horizontal = GridBagConstraints.HORIZONTAL;
    public final int both = GridBagConstraints.BOTH;
    public final HistoricoRepository repository = new HistoricoRepository();
    public final JTable table = populaTodaTabelaHisotrico();


    public TelaHistorico() {
        setLayout(grid);

        addComponent(new JLabel(getTextoTitulo()), 0,0, 0, horizontal);
        addComponent(getSelectNiveis(), 1, 0,0, horizontal);
        addComponent(montaScrollPane(), 2, 1,10, both);
    }

    private JScrollPane montaScrollPane(){
        var scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 37, 407, 79);

        return  scrollPane;
    }

    private JTable populaTodaTabelaHisotrico(){
        var dados = repository.getAll();

        return montaTabelaHistorico(dados);
    }

    private JTable montaTabelaHistorico(List<Historico> dados) {
        String[] colunas = {"Data", "Duração", "Nível", "Status"};

        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(colunas);

        for (Historico hist : dados) {
            Object h[] = new Object[4];
            h[0] = hist.getData();
            h[1] = hist.getDuracao();
            h[2] = hist.getNivel();
            h[3] = hist.getStatus();
            table.addRow(h);
        }

        return new JTable(table);
    }

    private JComboBox getSelectNiveis() {
        String[] niveis = {"Fácil", "Médio", "Difícil"};

        var petList = new JComboBox(niveis);
        petList.setSelectedIndex(2);
        petList.addActionListener((event) -> BuscaInfoBanco(event));
        return petList;
    }

    private void BuscaInfoBanco(ActionEvent event) {
        JComboBox comboBox = (JComboBox) event.getSource();

        var selected = comboBox.getSelectedItem().toString();

        switch (selected) {
            case "Fácil":
                montaTabelaFiltros("Fácil");
                break;
            case "Médio":
                montaTabelaFiltros("Médio");
                break;
            case "Difícil":
                montaTabelaFiltros("Difícil");
                break;
        }
    }

    private void montaTabelaFiltros(String nivel) {
        table.clearSelection();

        var dados = repository.getAllFiltered(nivel);
        montaTabelaHistorico(dados);
    }


    private String getTextoTitulo() {
        return "<html><h1>Histórico</h1></html>";
    }

    private void addComponent(Component comp, int row, int width, int height, int fill) {
        constrains.fill = fill;
        constrains.gridy = row;
        constrains.gridx = 0;
        constrains.weightx = width;
        constrains.weighty = height;
        constrains.insets = new Insets(5, 5, 5, 5);

        grid.addLayoutComponent(comp, constrains);
        add(comp);
    }
}
