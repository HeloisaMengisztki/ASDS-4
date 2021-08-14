package Imagens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Ex2_3 implements ActionListener {
    JLabel msg = new JLabel("");

    int qtdBotoes = 8;
    ArrayList<Integer> ordem;
    Map<Integer, ImageIcon> allImages;

    ArrayList<ImageIcon> cartasViradas = new ArrayList<>();
    ArrayList<JButton> botoesVirar = new ArrayList<>();
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
    }

    private void mostraMesaInicial(JFrame frame) {
        for (int i = 0; i < qtdBotoes; i++) {
            placeButton(frame, allImages.get(0), i);
        }
    }

    private void iniciaImagens() {
        allImages = new HashMap<>();
        allImages.put(0, new ImageIcon("./img/memoria/carta1.png"));
        allImages.put(1, new ImageIcon("./img/memoria/carta3.png"));
        allImages.put(2, new ImageIcon("./img/memoria/carta4.png"));
        allImages.put(3, new ImageIcon("./img/memoria/carta2.png"));
        allImages.put(4, new ImageIcon("./img/memoria/carta5.png"));
    }

    private void montaMesaAleatorio() {
        ordem = new ArrayList<>();
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
        var buttonClicked = (JButton) e.getSource();
        var buttonPlace = (Integer) buttonClicked.getClientProperty("id");

        var imgButton = allImages.get(ordem.get(buttonPlace));
        if (clicks.containsKey(buttonPlace)) {
            return;
        }

        clicks.put(buttonPlace, imgButton);
        buttonClicked.setIcon(imgButton);
        botoesVirar.add(buttonClicked);

        var click = clicks.size();

        if (click >= 2 && verificaIgualdade(clicks)) {
            cartasViradas.add(imgButton);
            if (cartasViradas.size() == 4) {
                msg.setText("ganhou");
            }
            clicks.clear();
            botoesVirar.remove(0);
            botoesVirar.remove(0);
        } else if (click == 3) {
            viraCartas(botoesVirar);

            botoesVirar.remove(0);
            botoesVirar.remove(0);

            ArrayList<Integer> ids = new ArrayList<>(clicks.keySet());

            clicks.remove(ids.get(0));
            clicks.remove(ids.get(0));
        }
    }

    private boolean verificaIgualdade(Map<Integer, ImageIcon> clicks) {
        var images = clicks.values().toArray();
        var img1 = images[0];
        var img2 = images[1];

        return img1 == img2;
    }

    private void viraCartas(ArrayList<JButton> buttons) {
        for (int i = 0; i < 2; i++) {
            buttons.get(i).setIcon(allImages.get(0));
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
