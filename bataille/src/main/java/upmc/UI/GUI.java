package upmc.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GUI {

    public static void main(String[] args) {
        JFrame window = new JFrame("Jeu de la bataille");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(screenSize.width, screenSize.height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

    }
}
