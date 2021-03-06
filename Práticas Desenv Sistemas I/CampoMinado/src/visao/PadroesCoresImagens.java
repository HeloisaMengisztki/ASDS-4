package visao;

import javax.swing.*;
import java.awt.*;

public abstract class PadroesCoresImagens {

    private static ImageIcon getIconBomba(){
        var icon = new ImageIcon("C:\\Users\\NOTBOOK\\Desktop\\IFSC\\ADS4\\Práticas Desenv Sistemas I\\CampoMinado\\src\\images\\bomba.jpg");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    public static ImageIcon ICON_BOMBA = getIconBomba();
    public static Color BG_PADRAO = new Color(88, 88, 88);
    public static Color BG_ABERTO = new Color(246, 246, 246);
    public static Color BG_MARCAR = new Color(8, 179, 247);
    public static Color BG_EXPLODIR = new Color(169, 66, 68);
}
