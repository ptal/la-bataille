package upmc.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GameUI extends GUI {

    private final JPanel panel;
    private final JLabel labelPlayer1;

    public GameUI() {
        super();
        this.panel = new JPanel();
        this.add(panel, BorderLayout.CENTER);

        this.labelPlayer1 = new JLabel(this.bataille.getJ1().getNom());
        this.panel.add(labelPlayer1,BorderLayout.CENTER);

        this.setVisible(true);
    }
}
