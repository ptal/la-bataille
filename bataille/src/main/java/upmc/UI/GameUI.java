package upmc.UI;

import upmc.game.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GameUI extends JPanel {

    private JLabel j1Name;
    private JLabel j2Name;

    public GameUI(Bataille bataille) {
        this.j1Name = new JLabel(bataille.getJ1().getNom());
        this.j2Name = new JLabel(bataille.getJ2().getNom());
        this.add(j1Name);
        this.add(j2Name);
    }

    public JLabel getJ1Name() {
        return j1Name;
    }

    public void setJ1Name(String n) {
        this.j1Name.setName(n);
    }

    public JLabel getJ2Name() {
        return j2Name;
    }

    public void setJ2Name(String n) {
        this.j2Name.setName(n);
    }
}
