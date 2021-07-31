package Imagens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ex2_2 implements ActionListener {
    String calcular = "Calcular";
    JLabel label;
    JLabel aviso = new JLabel("");
    JTextField peso;
    JTextField altura;

    public Ex2_2() {
        JFrame frame = initialSettings();

        frame.add(new JLabel("Altura (cm): "));
        altura = new JTextField(5);
        frame.add(altura);

        frame.add(new JLabel("Peso (kg): "));
        peso = new JTextField(5);
        frame.add(peso);

        placeButton(frame, calcular);

        frame.add(aviso);
        ImageIcon img = new ImageIcon("./img/imc/imc.jpg");
        label = new JLabel(img);
        frame.add(label);
    }

    private JFrame initialSettings() {
        JFrame frame = new JFrame("IMC");
        frame.setVisible(true);
        frame.setSize(450, 400);
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
        try {
            double p = Double.parseDouble(peso.getText().replace(",", "."));
            double a = Double.parseDouble(altura.getText().replace(",", "."));

            double imc = calculaImc(p, a);

            if (imc < 17)
                label.setIcon(new ImageIcon("./img/imc/imc01.jpg"));
            else if (imc < 18.5)
                label.setIcon(new ImageIcon("./img/imc/imc02.jpg"));
            else if (imc < 25)
                label.setIcon(new ImageIcon("./img/imc/imc03.jpg"));
            else if (imc < 30)
                label.setIcon(new ImageIcon("./img/imc/imc04.jpg"));
            else if (imc < 35)
                label.setIcon(new ImageIcon("./img/imc/imc05.jpg"));
            else if (imc < 40)
                label.setIcon(new ImageIcon("./img/imc/imc06.jpg"));
            else
                label.setIcon(new ImageIcon("./img/imc/imc07.jpg"));


        } catch (NumberFormatException ex) {
            aviso.setText("Valores não válidos!");
        }
    }

    private double calculaImc(double peso, double altura) {
        return peso / (altura * altura) * 10000;
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
