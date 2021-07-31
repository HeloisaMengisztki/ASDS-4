package Imagens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ex2_1 implements ActionListener {
    JLabel label;
    JLabel aviso;
    JTextField a;
    JTextField b;
    JTextField c;

    public Ex2_1() {
        JFrame frame = initialSettings();

        frame.add(new JLabel("Lado 1: "));
        a = new JTextField(5);
        frame.add(a);

        frame.add(new JLabel("Lado 2: "));
        b = new JTextField(5);
        frame.add(b);

        frame.add(new JLabel("Lado 3: "));
        c = new JTextField(5);
        frame.add(c);

        placeButton(frame, "Verificar");
        placeButton(frame, "Limpar");

        aviso = new JLabel("");
        frame.add(aviso);

        ImageIcon img = new ImageIcon("./img/triangulos/tri.jpg");
        label = new JLabel(img);
        frame.add(label);
    }

    private JFrame initialSettings() {
        JFrame frame = new JFrame("Triangulos");
        frame.setVisible(true);
        frame.setSize(150, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        return frame;
    }

    private void placeButton(JFrame frame, String nome) {
        JButton adicionar = new JButton(nome);
        adicionar.addActionListener(this);
        frame.add(adicionar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ehBotao("Verificar", e)) {
            calculaNumero();
            return;
        }

        if (ehBotao("Limpar", e)) {
            a.setText("");
            b.setText("");
            c.setText("");
        }
    }

    private void calculaNumero() {
        try {
            int x = Integer.parseInt(a.getText());
            int y = Integer.parseInt(b.getText());
            int z = Integer.parseInt(c.getText());

            boolean ehValido = ehTrianguloValido(x, y, z);
            if (!ehValido) {
                aviso.setText("Triangulo inválido!");

                ImageIcon error = new ImageIcon("./img/triangulos/erro.png");
                label.setIcon(error);
                return;
            }

            if (ehEquilatero(x, y, z)) {
                aviso.setText("Triangulo Equilátero!");
                label.setIcon(new ImageIcon("./img/triangulos/tri-equilatero.jpg"));
                return;
            }

            if (ehIsoceles(x, y, z)) {
                aviso.setText("Triangulo Isóceles!");
                label.setIcon(new ImageIcon("./img/triangulos/tri-isoceles.jpg"));
                return;
            }

            aviso.setText("Triangulo Escaleno!");
            label.setIcon(new ImageIcon("./img/triangulos/tri-escaleno.jpg"));

        } catch (NumberFormatException ex) {
            aviso.setText("Digite todos os valores!");

            ImageIcon error = new ImageIcon("./img/triangulos/erro.png");
            label.setIcon(error);
            return;
        }
    }

    private boolean ehEquilatero(int x, int y, int z) {
        return x == y && x == z;
    }

    private boolean ehIsoceles(int x, int y, int z) {
        return x == y || y == z || x == z;
    }

    private boolean ehTrianguloValido(int x, int y, int z) {
        if (condicaoExitencia(x, y, z) && condicaoExitencia(y, x, z) && condicaoExitencia(z, x, y)) {
            return true;
        }
        return false;
    }

    private boolean condicaoExitencia(int l1, int l2, int l3) {
        return (Math.abs(l2 - l3) < l1 && l1 < (l2 + l3));
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
