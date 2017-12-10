package upmc.UI;

import upmc.game.Bataille;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GUI extends JFrame {

    protected static final String windowName = "Jeu de la bataille";
    protected int widthWindow;
    protected int heightWindow;
    protected Bataille bataille;

    public static void main(String[] args) {
        new SelectPlayersUI();
    }

    public GUI() {
        super(windowName);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.widthWindow = screenSize.width;
        this.heightWindow = screenSize.height;
        this.settings();
    }

    public GUI(int width, int height) {
        super(windowName);
        this.widthWindow = width;
        this.heightWindow = height;
        this.settings();
    }

    public void settings() {
        this.setSize(widthWindow, heightWindow);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.bataille = new Bataille(5);
    }

}
