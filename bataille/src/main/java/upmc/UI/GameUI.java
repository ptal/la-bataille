package upmc.UI;

import upmc.game.Bataille;
import upmc.game.Carte;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GameUI extends JPanel {

    private Bataille bataille;
    private JLabel j1Name;
    private JLabel j2Name;

    public GameUI(Bataille bataille) {
        this.j1Name = new JLabel(bataille.getJ1().getNom());
        this.j2Name = new JLabel(bataille.getJ2().getNom());
        this.bataille = bataille;
        this.setBackground(new Color(29,137,60));
        this.add(j1Name,BorderLayout.SOUTH);
        this.add(j2Name,BorderLayout.NORTH);
        this.bataille.creerJeuDeCarte();
        this.bataille.distributionDesCartes();
        afficheCartes();
    }

    public void afficheCartes() {
        System.out.println("lol");
        ArrayList<Carte> jeuDeCarteJ1 = bataille.getJ1().getCartesEnMain();
        for(Carte c : jeuDeCarteJ1) {
            System.out.println(c.getNombre());
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            p.setPreferredSize(new Dimension(70, 110));

            ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/upmc/UI/img/"+c.getCouleur()+".png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

            JLabel picLabel = new JLabel(imageIcon);
            picLabel.setPreferredSize(new Dimension(60, 60));
            p.add(picLabel);
            JLabel nombre = new JLabel(Integer.toString(c.getNombre()));
            p.add(nombre);
            this.add(p);
        }
    }

}
