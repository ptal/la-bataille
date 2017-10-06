/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 * This class enables you to create a Card with a value and a color
 * It's mainly used in the Deck which is in a way a factory of many cards
 * It's also used when a user draw a Card.
 * The value of a Card will give the winner
 * @author Timothé Pardieu
 */
public class Card
{
    private String color;
    private int value;

    /**
     * Constructor in order to have two main variables
     * @param color the color of the card (color means Heart, Spade, Club and Diamond)
     * @param value the value represents the number from 2 to 10 + 11 to 14 which represents the Queen, King, As..
     */
    public Card(String color, int value)
    {
        this.color = color;
        this.value = value;
    }

    /**
     * Verify if it's a King, Queen... and binding the value to a String
     * @param value the value of the card
     * @return the value in String mode in order to print "4" or "King".
     */
    private String verifyName(int value)
    {
        switch (value)
        {
            case 11:
                return "Valet";
            case 12:
                return "Roi";
            case 13:
                return "Reine";
            case 14:
                return "As";
            default:
                return String.valueOf(value);
        }
    }

    /**
     * @return the value of the card (2,3,4...9..)
     */
    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        String card = "*" + String.format("%-14s", "------------").replace(' ', '-') + "*\n"
                + String.format("%-15s", "| " + color + "") + "|\n"
                + String.format("%-15s", "| " + verifyName(value) + "") + "|\n"
                + String.format("%-15s", "| " + "") + "|\n"
                + String.format("%-15s", "| " + "") + "|\n"
                + String.format("%-15s", "| " + "") + "|\n"
                + "*" + String.format("%-14s", "------------").replace(' ', '-') + "*\n";
        return card;
    }
}
