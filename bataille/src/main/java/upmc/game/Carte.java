/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author licence
 */
public class Carte {
    
    private int valeur;
    private String couleur;
    private String forme;
    
    public Carte(int valeur, String couleur, String forme) {
        this.valeur = valeur;
        
        //TODO vérif entrées
        this.couleur = couleur;
        this.forme = forme;
    }
    
    public boolean compareCarte(Carte carte) {
        return this.valeur == carte.valeur;
    }
    
    @Override
    public String toString() {
        return "Valeur: " + this.valeur + ", Forme: " + this.forme + ", Couleur: " + this.couleur;
    }
}
