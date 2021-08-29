package visao;

import javax.swing.*;
import java.awt.*;

public class TelaInformacoes extends JPanel {
    private final GridBagConstraints constrains = new GridBagConstraints();
    private final GridBagLayout grid = new GridBagLayout();
    public final int horizontal = GridBagConstraints.HORIZONTAL;

    public TelaInformacoes() {
        setLayout(grid);

        addComponent(new JLabel(getTextoTitulo()), 0, 0, 0);
        addComponent(new JLabel(PadroesCoresImagens.ICON_BOMBA), 1, 2, 1);
        addComponent(new JLabel(getTextoInfo()), 3, 0, 5);
    }

    private String getTextoTitulo() {
        return "<html><h1>Campo Minado</h1></html>";
    }

    private String getTextoInfo() {
        return "<html><br><p>A área de jogo consiste num campo de quadrados retangular. Cada quadrado pode ser revelado clicando sobre ele, e se o quadrado clicado contiver uma mina, então o jogo acaba. Se, por outro lado, o quadrado não contiver uma mina, uma de duas coisas poderá acontecer:</p>" +
                "<ol><li>Um n&uacute;mero aparece, indicando a quantidade de quadrados adjacentes que cont&ecirc;m minas;</li>\n" +
                "<li>Nenhum n&uacute;mero aparece. Neste caso, o jogo revela automaticamente os quadrados que se encontram adjacentes ao quadrado vazio, j&aacute; que n&atilde;o podem conter minas;</li>\n" +
                "</ol><p>O jogo &eacute; ganho quando todos os quadrados que n&atilde;o t&ecirc;m minas s&atilde;o revelados.</p>" +
                "<br></html>";
    }

    private void addComponent(Component comp, int row, int width, int height) {
        constrains.fill = horizontal;
        constrains.gridy = row;
        constrains.gridx = 0;
        constrains.weightx = width;
        constrains.weighty = height;
        constrains.insets = new Insets(5,50,5,50);

        grid.addLayoutComponent(comp, constrains);
        add(comp);
    }
}
