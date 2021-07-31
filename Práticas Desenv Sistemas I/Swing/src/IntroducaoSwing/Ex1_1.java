package IntroducaoSwing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Ex1_1 implements ActionListener {
    JLabel label;
    JTextField  textField;

    public Ex1_1() {
        JFrame frame = new JFrame("Eh Primo?");
        frame.setVisible(true);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        textField = new JTextField(10);
        frame.add(textField);

        JButton button = new JButton("Executar");
        button.addActionListener(this);
        frame.add(button);

        label = new JLabel("");
        frame.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numero;

        try {
            numero = Integer.parseInt(textField.getText());
        }catch (NumberFormatException ex){
            label.setText("O valor informado não e um numero aceitavel.");
            return;
        }

        var ehPrimo = ehPrimo(numero);

        if (ehPrimo){
            label.setText("O número " + numero + " é primo!");
            return;
        }
        label.setText("O número " + numero + " não é primo!");
    }

    private static boolean ehPrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex1_1();
            }
        });
    }
}
