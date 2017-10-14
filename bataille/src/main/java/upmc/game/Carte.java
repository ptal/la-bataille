/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Random;

/**
 *
 * @author licence
 */
public class Carte {
    
    private int value;
    private String form;
    private String name;
    
    public Carte() {
        this.generateRandomValue();
        this.generateColor();
    }
    
    @Override
    public String toString() {
        return this.name + " de " + this.form;
    }

    public int getValue() {
        return this.value;
    }

    private void generateRandomValue() {
        Random rand = new Random();
        this.value = rand.nextInt(13) + 1;
        switch (this.value) {
            case 1: this.name = "As";break;
            case 11: this.name = "Valet";break;
            case 12: this.name = "Dame";break;
            case 13: this.name = "Roi";break;
            default: this.name = String.valueOf(this.value);
        }
    }

    private void generateColor() {
        String formes[] = {"Coeur", "Pique", "Trefle", "Carreau"};
        Random rand = new Random();

        this.form = formes[rand.nextInt(4)];
    }
}
