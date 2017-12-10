package upmc.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Adrien on 10/12/2017.
 */
public class SelectPlayersUI extends GUI {

    protected static final int widthWindow = 600;
    protected static final int heightWindow = 400;
    protected JPanel panel;
    protected JLabel labelPlayer1;
    protected JLabel labelPlayer2;
    protected JTextField textFieldPlayer1;
    protected JTextField textFieldPlayer2;
    protected JButton buttonAccept;
    protected JToggleButton aloneOrTwoPlayersButton;
    protected int state;

    public SelectPlayersUI() {
        super(widthWindow,heightWindow);
        this.panel = new JPanel();
        this.add(panel,BorderLayout.CENTER);

        this.aloneOrTwoPlayersButton = new JToggleButton("Jouer contre un ami");
        this.panel.add(aloneOrTwoPlayersButton);

        this.labelPlayer1 = new JLabel("Nom joueur 1 : ");
        this.panel.add(labelPlayer1,BorderLayout.CENTER);

        this.textFieldPlayer1 = new JTextField();
        this.textFieldPlayer1.setColumns(10);
        this.panel.add(textFieldPlayer1, BorderLayout.CENTER);

        this.labelPlayer2 = new JLabel("Nom joueur 2 : ");
        this.panel.add(labelPlayer2,BorderLayout.CENTER);
        this.labelPlayer2.setVisible(false);

        this.textFieldPlayer2 = new JTextField();
        this.textFieldPlayer2.setColumns(10);
        this.panel.add(textFieldPlayer2, BorderLayout.CENTER);
        this.textFieldPlayer2.setVisible(false);

        this.buttonAccept = new JButton("Valider");
        this.panel.add(buttonAccept, BorderLayout.CENTER);


        this.buttonAccept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String player1value = textFieldPlayer1.getText();
                String player2value;
                if(state == ItemEvent.SELECTED) {
                    player2value = textFieldPlayer2.getText();
                } else {
                    player2value = "IA";
                }
                bataille.setPlayers(player1value,player2value);
                JFrame newFrame = new GameUI();
            }
        });
        this.aloneOrTwoPlayersButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                    labelPlayer2.setVisible(true);
                    textFieldPlayer2.setVisible(true);
                } else {
                    System.out.println("Deselected");
                    labelPlayer2.setVisible(false);
                    textFieldPlayer2.setVisible(false);

                }
            }
        });

        this.setVisible(true);
    }

}

