package upmc.game;

/**
 * Created by Adrien on 12/09/2017.
 */
public class Card {

    static String[] colors = {"pique", "trefle", "coeur", "carreau"};
    private String color;
    private int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public int compareA(Card c) {
        return this.number - c.getNumber();
    }

    public String nameValue() {
        String nameValue;
        if (this.number == 11) nameValue = "valet";
        else if (this.number == 12) nameValue = "reine";
        else if (this.number == 13) nameValue = "roi";
        else nameValue = String.valueOf(this.number);
        return nameValue;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.nameValue() + " de " + this.color;
    }
}
