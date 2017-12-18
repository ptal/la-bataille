package upmc.UI;

import upmc.game.Bataille;
import upmc.game.Card;
import upmc.game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

        this.j1Name = new JLabel(bataille.getP1().getName()+"(score : "+bataille.getP1().getScore()+")");
        this.j2Name = new JLabel(bataille.getP2().getName()+"(score : "+bataille.getP2().getScore()+")");
        Font f = new Font("nom joueur", Font.BOLD, 30);
        this.j1Name.setFont(f);
        this.j2Name.setFont(f);

        this.j1Panel = new HandUI();
        this.j2Panel = new HandUI();
        this.table = new JPanel();

        this.add(j2Panel,BorderLayout.NORTH);
        this.add(table,BorderLayout.CENTER);
        this.add(j1Panel,BorderLayout.SOUTH);

        this.j1Panel.add(j1Name);
        this.j2Panel.add(j2Name);

        this.bataille.createCardGame();
        this.bataille.cardDistribution();
        this.displayCards(this.j1Panel.getPPanelCards(),bataille.getP1());
        this.displayCards(this.j2Panel.getPPanelCards(),bataille.getP2());

        this.table.setBackground(new Color(29,137,60));
    }

    public void displayCards(final JPanel panelCible, Player j) {
        ArrayList<Card> cards = j.getCardsInTheHand();
        for(final Card c : cards) {
            final JPanel carte = new JPanel();
            carte.setBackground(Color.WHITE);
            carte.setPreferredSize(new Dimension(70, 110));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/upmc/UI/img/"+c.getColor()+".png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel picLabel = new JLabel(imageIcon);
            picLabel.setPreferredSize(new Dimension(60, 60));
            carte.add(picLabel);
            JLabel number = new JLabel(c.nameValue());
            carte.add(number);
            carte.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) throws NullPointerException {
                    super.mouseClicked(e);
                    if(panelCible == j1Panel.getPPanelCards()) bataille.setCardJ1(c);
                    else bataille.setCardJ2(c);
                    if(bataille.getCardJ1()!=null && bataille.getCardJ2()!=null) oneTurn();
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

    public void oneTurn() {
        this.table.removeAll();
        table.add(createACardView(bataille.getCardJ1()));
        table.add(createACardView(bataille.getCardJ2()));
        Player winnerOfTheTurn = bataille.aTurn();
        System.out.println(winnerOfTheTurn.getName()+" : "+winnerOfTheTurn.getScore());
        this.table.updateUI();
        this.nameOfPlayersLabelMAJ();
    }

    public void nameOfPlayersLabelMAJ() {
        this.j1Name.setText(bataille.getP1().getName()+"(score : "+bataille.getP1().getScore()+")");
        this.j2Name.setText(bataille.getP2().getName()+"(score : "+bataille.getP2().getScore()+")");
    }

    public JPanel createACardView(Card c) {
        JPanel cardView = new JPanel();
        cardView.setBackground(Color.WHITE);
        cardView.setPreferredSize(new Dimension(140, 220));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/upmc/UI/img/"+c.getColor()+".png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        JLabel picLabel = new JLabel(imageIcon);
        picLabel.setPreferredSize(new Dimension(140, 140));
        cardView.add(picLabel);
        JLabel number = new JLabel(c.nameValue());
        Font f1 = new Font("carte", Font.BOLD, 40);
        number.setFont(f1);
        cardView.add(number);
        return cardView;
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
