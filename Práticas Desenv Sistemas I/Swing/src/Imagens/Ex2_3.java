package Imagens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Ex2_3 implements ActionListener {
    JLabel msg = new JLabel("");
    int qtdBotoes = 8;
    ArrayList<Integer> ordem = new ArrayList<>();
    ArrayList<JButton> botoes = new ArrayList<>();
    Map<Integer, ImageIcon> imagInt = new HashMap<>();
    Map<Integer, JButton> buttonInt = new HashMap<>();

    private JFrame initialSettings() {
        JFrame frame = new JFrame("Memória");
        frame.setVisible(true);
        frame.setSize(400, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        return frame;
    }

    public Ex2_3() {
        JFrame frame = initialSettings();

        iniciaImagens();
        montaMesaAleatorio();
        mostraMesaInicial(frame);

        iniciaJogo();
    }

    private void iniciaJogo() {
    }

    private void mostraMesaInicial(JFrame frame) {
        for (int i = 0; i < qtdBotoes; i++) {
            placeButton(frame, imagInt.get(ordem.get(i)), i);
        }
    }

    private void iniciaImagens() {
        imagInt.put(0, new ImageIcon("./img/memoria/carta1.png"));
        imagInt.put(1, new ImageIcon("./img/memoria/carta3.png"));
        imagInt.put(2, new ImageIcon("./img/memoria/carta4.png"));
        imagInt.put(3, new ImageIcon("./img/memoria/carta2.png"));
        imagInt.put(4, new ImageIcon("./img/memoria/carta5.png"));
    }

    private void montaMesaAleatorio() {
        for (int i = 1; i <= qtdBotoes / 2; i++) {
            ordem.add(i);
            ordem.add(i);
        }
        Collections.shuffle(ordem);
    }

    private void placeButton(JFrame frame, ImageIcon icon, int id) {
        JButton adicionar = new JButton(icon);
        adicionar.addActionListener(this);
        adicionar.putClientProperty("id", id);
        frame.add(adicionar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var aa = e.getSource();
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
