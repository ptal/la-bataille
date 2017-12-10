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
public class SelectPlayersUI extends JPanel {

    protected JLabel labelPlayer1;
    protected JLabel labelPlayer2;
    protected JTextField textFieldPlayer1;
    protected JTextField textFieldPlayer2;
    protected JButton buttonAccept;
    protected JToggleButton aloneOrTwoPlayersButton;
    protected int state;

    public SelectPlayersUI() {

        this.aloneOrTwoPlayersButton = new JToggleButton("Jouer contre un ami");
        this.add(aloneOrTwoPlayersButton);

        this.labelPlayer1 = new JLabel("Nom joueur 1 : ");
        this.add(labelPlayer1,BorderLayout.CENTER);

        this.textFieldPlayer1 = new JTextField();
        this.textFieldPlayer1.setColumns(10);
        this.add(textFieldPlayer1, BorderLayout.CENTER);

        this.labelPlayer2 = new JLabel("Nom joueur 2 : ");
        this.add(labelPlayer2,BorderLayout.CENTER);
        this.labelPlayer2.setVisible(false);

        this.textFieldPlayer2 = new JTextField();
        this.textFieldPlayer2.setColumns(10);
        this.add(textFieldPlayer2, BorderLayout.CENTER);
        this.textFieldPlayer2.setVisible(false);

        this.buttonAccept = new JButton("Valider");
        this.add(buttonAccept, BorderLayout.CENTER);

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

    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public JLabel getLabelPlayer1() {
        return labelPlayer1;
    }

    public JLabel getLabelPlayer2() {
        return labelPlayer2;
    }

    public JTextField getTextFieldPlayer1() {
        return textFieldPlayer1;
    }

    public JTextField getTextFieldPlayer2() {
        return textFieldPlayer2;
    }

    public JToggleButton getAloneOrTwoPlayersButton() {
        return aloneOrTwoPlayersButton;
    }

    public int getState() {
        return state;
    }
}

