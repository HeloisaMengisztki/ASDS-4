package IntroducaoSwing;

import Imagens.Ex2_3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ex1_3 implements ActionListener {
    JLabel label;
    JTextField maior;
    JTextField menor;
    JTextField media;
    JTextField valor;
    ArrayList<Integer> lista = new ArrayList<>();

    public Ex1_3() {
        JFrame frame = initialSettings();

        placeEntryTextField(frame);

        placeButton(frame, "Adicionar");

        frame.add(new JLabel("Maior: "));
        maior = new JTextField(5);
        maior.setEditable(false);
        frame.add(maior);

        frame.add(new JLabel("Menor: "));
        menor = new JTextField(5);
        menor.setEditable(false);
        frame.add(menor);

        frame.add(new JLabel("Média: "));
        media = new JTextField(5);
        media.setEditable(false);
        frame.add(media);

        placeButton(frame, "Calcular");

        label = new JLabel("");
        frame.add(label);
    }

    private JFrame initialSettings() {
        JFrame frame = new JFrame("Números");
        frame.setVisible(true);
        frame.setSize(150, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        return frame;
    }

    private void placeEntryTextField(JFrame frame) {
        JLabel label = new JLabel("Digite os números: ");
        frame.add(label);

        valor = new JTextField(5);
        frame.add(valor);
    }

    private void placeButton(JFrame frame, String nome) {
        JButton adicionar = new JButton(nome);
        adicionar.addActionListener(this);
        frame.add(adicionar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ehBotao("Adicionar", e)) {
            salvaNumero();
            valor.setText("");
            return;
        }

        if (ehBotao("Calcular", e) && !lista.isEmpty()) {
            organizaLista();
            montaResultado();
            lista.clear();
            return;
        }
    }

    private void montaResultado() {
        menor.setText("Menor: " + lista.get(0));
        maior.setText("Maior: " + lista.get(lista.size() - 1));
        media.setText("Média: " + calculaMedia());
    }

    private String calculaMedia() {
        Integer sum = 0;

        if (!lista.isEmpty()) {
            for (Integer mark : lista) {
                sum += mark;
            }
            return (String.valueOf(sum.doubleValue() / lista.size()));
        }
        return "";
    }

    private void organizaLista() {
        Collections.sort(lista);
    }

    private void salvaNumero() {
        try {
            int x = Integer.parseInt(valor.getText());
            lista.add(x);
        } catch (NumberFormatException ex) {
            label.setText("O valor informado \nnão e um valor aceitavel.");
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
