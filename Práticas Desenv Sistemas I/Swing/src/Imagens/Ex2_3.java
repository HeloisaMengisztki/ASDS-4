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
    ArrayList<ImageIcon> cartasViradas = new ArrayList<>();
    Map<Integer, ImageIcon> imagInt = new HashMap<>();
    Map<Integer, ImageIcon> clicks = new HashMap<>();

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
            placeButton(frame, imagInt.get(0), i);
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
        boolean igual = false;

        var buttonClicked = (JButton) e.getSource();
        var buttonPlace = (Integer) buttonClicked.getClientProperty("id");

        var imgButton = imagInt.get(ordem.get(buttonPlace));
        if(clicks.containsKey(buttonPlace)){
            return;
        }

        clicks.put(buttonPlace, imgButton);
        buttonClicked.setIcon(imgButton);

        if(clicks.size() == 2){

            var images = clicks.values();
            var iguais = images.equals(images.stream().findFirst());

            if (iguais) {
                cartasViradas.add(imgButton);//ver pontuação para não estourar, calcular com as cartasViradas;
            }else{
                viraCartas(clicks);
            }

            clicks.clear();
        }
    }

    private void viraCartas(Map<Integer, ImageIcon> clicks) {
        for (int i = 0; i < clicks.size(); i++) {
            //placeButton(frame, imagInt.get(0), i); //pegar botão pelo id e set img para a zero
        }
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
