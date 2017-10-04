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
    
    private int valeur;
    private String forme;
    private String nom;
    
    public Carte() {
        this.generateRandomValue();
        this.generateColor();
    }
    
    public boolean compareCarte(Carte carte) {
        return this.valeur == carte.valeur;
    }
    
    @Override
    public String toString() {
        return this.nom + " de " + this.forme;
    }

    public int getValeur() {
        return this.valeur;
    }

    public String getForme() {
        return this.forme;
    }

    private void generateRandomValue() {
        Random rand = new Random();
        this.valeur = rand.nextInt(13) + 1;
        switch (this.valeur) {
            case 1: this.nom = "As";break;
            case 11: this.nom = "Valet";break;
            case 12: this.nom = "Dame";break;
            case 13: this.nom = "Roi";break;
            default: this.nom = String.valueOf(this.valeur);
        }
    }

    private void generateColor() {
        String formes[] = {"Coeur", "Pique", "Trefle", "Carreau"};
        Random rand = new Random();

        this.forme = formes[rand.nextInt(4)];
    }
}
