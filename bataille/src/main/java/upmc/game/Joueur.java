/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Joueur {
    
    private ArrayList<Carte> cards = new ArrayList<Carte>();
    private String name;
    private int points;

    public Carte pick(int index) {
        Carte card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public Carte getLastCard() {
        return this.cards.get(this.cards.size()-1);
    }

    public void showCards() {
        int i = 0;
        for (Carte carte: cards) {
            System.out.println(i + ": " + carte.toString());
            i++;
        }
    }

    public ArrayList<Carte> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points++;
    }
}
