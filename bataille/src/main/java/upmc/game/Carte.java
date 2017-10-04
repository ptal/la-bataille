package upmc.game;

import java.util.Random;
public class Carte {
    
    private int valeur;
    private String forme;
    
    public Carte() {
        this.generateRandomValue();
        this.generateColor();
    }
    
    public boolean compareCarte(Carte carte) {
        return this.valeur == carte.valeur;
    }
    
    @Override
    public String toString() {
        return "Valeur: " + this.valeur + ", Couleur: " + this.forme ;
    }

    public int getValeur() {
        return this.valeur;
    }

    public String getForme() {
        return this.forme;
    }

    /**
     * Méthodes utilisées pour joueur
     */

    public void regenerateCard() {
        generateRandomValue();
        generateRandomValue();
    }

    private void generateRandomValue() {
        Random rand = new Random();
        this.valeur = rand.nextInt(13) + 1;
    }

    private void generateColor() {
        String formes[] = {"Trèfle", "Carreau", "Coeur", "Pique"};
        Random rand = new Random();

        this.forme = formes[rand.nextInt(4)];
    }
}