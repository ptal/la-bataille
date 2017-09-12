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
public class Joueur {
    
    private Carte[] cartes;
    
    public Joueur() {
        
    }
    
    private int generateRandomValue() {
        Random rand = new Random();
        return rand.nextInt(13) + 1;
    }
    
    private String generateRandomForme() {
        String formes[] = {"Coeur", "Pique", "Trefle", "Carreau"};
        Random rand = new Random();
        
        return formes[rand.nextInt(3)];
    }
    
    private String generateRandomColor() {
        String couleurs[] = {"Rouge", "Noir"};
        Random rand = new Random();
        
        return couleurs[rand.nextInt(3)];
    }
    
    public void pioche() {
        // Ajoute au tableau de cartes une carte générée
        System.out.println(this.generateRandomValue());
        System.out.println(this.generateRandomForme());
        System.out.println(this.generateRandomColor());
    }
}
