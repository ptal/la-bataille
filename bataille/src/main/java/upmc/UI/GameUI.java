package upmc.UI;

import upmc.game.Bataille;
import upmc.game.Card;
import upmc.game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private Card cardJ1;
    private Card cardJ2;

    public GameUI(Bataille bataille) {
        this.setLayout(new BorderLayout());
        this.bataille = bataille;

        this.j1Name = new JLabel(bataille.getP1().getName());
        this.j2Name = new JLabel(bataille.getP2().getName());

        this.j1Panel = new HandUI();
        this.j2Panel = new HandUI();
        this.table = new JPanel();

        this.add(j2Panel,BorderLayout.NORTH);
        this.add(table,BorderLayout.CENTER);
        this.add(j1Panel,BorderLayout.SOUTH);

        this.j1Panel.add(j1Name);
        this.j2Panel.add(j2Name);

        this.bataille.createCardGame();
        this.bataille.cardDistribution()
        ;
        this.displayCards(this.j1Panel.getPPanelCards(),bataille.getP1());
        this.displayCards(this.j2Panel.getPPanelCards(),bataille.getP2());

        this.table.setBackground(new Color(29,137,60));
    }

    public void displayCards(JPanel panelCible, Player j) {
        ArrayList<Card> cards = j.getCardsInTheHand();
        for(Card c : cards) {
            JPanel carte = new JPanel();
            carte.setBackground(Color.WHITE);
            carte.setPreferredSize(new Dimension(70, 110));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/upmc/UI/img/"+c.getColor()+".png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel picLabel = new JLabel(imageIcon);
            picLabel.setPreferredSize(new Dimension(60, 60));
            carte.add(picLabel);
            JLabel number = new JLabel(Integer.toString(c.getNumber()));
            carte.add(number);
            carte.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    JPanel panel = (JPanel)e.getSource();
                    panel.setBorder(BorderFactory.createLineBorder(Color.green,3));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    JPanel panel = (JPanel)e.getSource();
                    panel.setBorder(BorderFactory.createEmptyBorder());
                }
            });
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
