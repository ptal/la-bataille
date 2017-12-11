package upmc.UI;

import upmc.game.Bataille;
import upmc.game.Carte;
import upmc.game.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Adrien on 10/12/2017.
 */
public class GameUI extends JPanel {

    private Bataille bataille;
    private JLabel j1Name;
    private JLabel j2Name;
    private HandUI j1Panel;
    private HandUI j2Panel;
    private JPanel table;

    public GameUI(Bataille bataille) {
        this.setLayout(new BorderLayout());
        this.bataille = bataille;

        this.j1Name = new JLabel(bataille.getJ1().getNom());
        this.j2Name = new JLabel(bataille.getJ2().getNom());

        this.j1Panel = new HandUI();
        this.j2Panel = new HandUI();
        this.table = new JPanel();

        this.add(j2Panel,BorderLayout.NORTH);
        this.add(table,BorderLayout.CENTER);
        this.add(j1Panel,BorderLayout.SOUTH);

        this.j1Panel.add(j1Name);
        this.j2Panel.add(j2Name);

        this.bataille.creerJeuDeCarte();
        this.bataille.distributionDesCartes()
        ;
        this.displayCards(this.j1Panel.getPPanelCards(),bataille.getJ1());
        this.displayCards(this.j2Panel.getPPanelCards(),bataille.getJ2());

        this.table.setBackground(new Color(29,137,60));
    }

    public void displayCards(JPanel panelCible, Joueur j) {
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

class HandUI extends JPanel {

    private JPanel pPanelCards;

    public HandUI() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.pPanelCards = new JPanel();
        this.add(pPanelCards);
    }

    public JPanel getPPanelCards() {
        return pPanelCards;
    }
}
