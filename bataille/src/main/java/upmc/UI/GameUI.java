package upmc.UI;

import upmc.game.Bataille;
import upmc.game.Carte;
import upmc.game.Joueur;

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
    private JPanel j1Panel;
    private JPanel j2Panel;
    private JPanel table;
    private JPanel j1PanelCards;
    private JPanel j2PanelCards;

    public GameUI(Bataille bataille) {
        this.setLayout(new BorderLayout());
        this.j1Name = new JLabel(bataille.getJ1().getNom());
        this.j2Name = new JLabel(bataille.getJ2().getNom());
        this.bataille = bataille;

        this.j1Panel = new JPanel();
        this.j1Panel.setLayout(new BoxLayout(j1Panel,BoxLayout.Y_AXIS));
        this.j1PanelCards = new JPanel();
        this.j1Panel.add(j1PanelCards);

        this.j2Panel = new JPanel();
        this.j2Panel.setLayout(new BoxLayout(j2Panel,BoxLayout.Y_AXIS));
        this.j2PanelCards = new JPanel();
        this.j2Panel.add(j2PanelCards);

        this.table = new JPanel();
        this.add(j1Panel,BorderLayout.SOUTH);
        this.add(j2Panel,BorderLayout.NORTH);
        this.add(table,BorderLayout.CENTER);
        this.j1Panel.add(j1Name);
        this.j2Panel.add(j2Name);
        this.bataille.creerJeuDeCarte();
        this.bataille.distributionDesCartes();
        this.afficheCartes(j1PanelCards,bataille.getJ1());
        this.afficheCartes(j2PanelCards,bataille.getJ2());
        this.table.setBackground(new Color(29,137,60));

    }

    public void afficheCartes(JPanel panelCible,Joueur j) {
        ArrayList<Carte> jeuDeCarte = j.getCartesEnMain();
        for(Carte c : jeuDeCarte) {
            JPanel carte = new JPanel();
            carte.setBackground(Color.WHITE);
            carte.setPreferredSize(new Dimension(70, 110));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/upmc/UI/img/"+c.getCouleur()+".png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel picLabel = new JLabel(imageIcon);
            picLabel.setPreferredSize(new Dimension(60, 60));
            carte.add(picLabel);
            JLabel number = new JLabel(Integer.toString(c.getNombre()));
            carte.add(number);
            panelCible.add(carte);
        }
    }

}
