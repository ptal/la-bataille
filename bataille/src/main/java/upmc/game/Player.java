package upmc.game;

import java.util.ArrayList;

/**
 * Created by Adrien on 12/09/2017.
 */
public class Player {

    private ArrayList<Card> cardsInTheHand;
    private int score;
    private String name;
    private boolean isHuman;

    public Player() {
        this.score = 0;
        this.cardsInTheHand = new ArrayList<Card>();
        this.isHuman = true;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.cardsInTheHand = new ArrayList<Card>();
        this.isHuman = true;
    }

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.score = 0;
        this.cardsInTheHand = new ArrayList<Card>();
        this.isHuman = isHuman;
    }

    public Card playACard() {
        Card c = cardsInTheHand.get(0);
        cardsInTheHand.remove(cardsInTheHand.get(0));
        return c;
    }

    public void addCardToTheHand(Card c) {
        this.cardsInTheHand.add(c);
    }

    public void addMulitpleCardsInTheHand(ArrayList<Card> c) {
        this.cardsInTheHand.addAll(c);
    }

    public void winAPoint() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        this.isHuman = human;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCardsInTheHand() {
        return cardsInTheHand;
    }
}
