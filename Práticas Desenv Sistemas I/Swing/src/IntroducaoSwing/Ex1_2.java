package IntroducaoSwing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ex1_2 implements ActionListener {
    JLabel label;
    JTextField textFieldX;
    JTextField textFieldY;

    public Ex1_2() {
        JFrame frame = initialSettings();

        placeTextFields(frame);

        placeButtons(frame);

        label = new JLabel("");
        frame.add(label);
    }

    private JFrame initialSettings() {
        JFrame frame = new JFrame("Operações Matemáticas");
        frame.setVisible(true);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        return frame;
    }

    private void placeTextFields(JFrame frame) {
        JLabel label = new JLabel("Digite dois números: ");
        frame.add(label);

        textFieldX = new JTextField(5);
        frame.add(textFieldX);

        textFieldY = new JTextField(5);
        frame.add(textFieldY);
    }

    private void placeButtons(JFrame frame) {
        JButton somar = new JButton("Somar");
        somar.addActionListener(this);
        frame.add(somar);

        JButton multiplicar = new JButton("Multiplicar");
        multiplicar.addActionListener(this);
        frame.add(multiplicar);

        JButton subtrair = new JButton("Subtrair");
        subtrair.addActionListener(this);
        frame.add(subtrair);

        JButton dividir = new JButton("Dividir");
        dividir.addActionListener(this);
        frame.add(dividir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x;
        int y;

        try {
            x = Integer.parseInt(textFieldX.getText());
            y = Integer.parseInt(textFieldY.getText());
        } catch (NumberFormatException ex) {
            label.setText("O valor informado não e um valor aceitavel.");
            return;
        }

        calculaResultado("Somar", "+", e, x, y, (x+y));
        calculaResultado("Multiplicar", "x", e, x, y, (x*y));
        calculaResultado("Subtrair", "-", e, x, y, (x-y));
        calculaResultado("Dividir", "/", e, x, y, (x/y));
    }

    private void calculaResultado(String botao, String operador, ActionEvent e, int x, int y, int resultado) {
        if (e.getActionCommand().equalsIgnoreCase(botao)) {
            label.setText("Resultado: " + x + operador + y + " = " + resultado);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex1_2();
            }
        });
    }
}
