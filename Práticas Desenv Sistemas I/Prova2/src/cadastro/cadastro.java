package IntroducaoSwing;

import Imagens.Ex2_3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ex1_4 implements ActionListener {
    JTextField frase;
    JTextField invertida;

    public Ex1_4() {
        JFrame frame = initialSettings();

        placeEntryTextField(frame);

        invertida = new JTextField(10);
        invertida.setEditable(false);
        frame.add(invertida);

        placeButton(frame, "Inverter");
    }

    private JFrame initialSettings() {
        JFrame frame = new JFrame("Inverter");
        frame.setVisible(true);
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        return frame;
    }

    private void placeEntryTextField(JFrame frame) {
        JLabel label = new JLabel("Digite uma palavra: ");
        frame.add(label);

        frase = new JTextField(10);
        frame.add(frase);
    }

    private void placeButton(JFrame frame, String nome) {
        JButton adicionar = new JButton(nome);
        adicionar.addActionListener(this);
        frame.add(adicionar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ehBotao("Inverter", e)) {
            String palavra = frase.getText();
            StringBuilder builder = new StringBuilder();
            var palavraInvertida = builder.append(palavra).reverse();
            invertida.setText(palavraInvertida.toString());
            return;
        }
    }

    private boolean ehBotao(String botao, ActionEvent e) {
        return e.getActionCommand().equalsIgnoreCase(botao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex2_3();
            }
        });
    }
}