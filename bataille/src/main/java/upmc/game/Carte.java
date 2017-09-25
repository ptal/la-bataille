/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 * @author licence
 */
public class Carte {
    //--
    // Attributs
    //--
    private int num;
    private String couleur;
    
    //--
    // Constructeurs
    //--
    /**
     * Constructeur par défaut
     */
    public Carte(int parNum, String parCouleur) {
        this.num = parNum;
        this.couleur = parCouleur;
    }
    
    //--
    // Fonctions
    //--
    /**
     * Fonctions qui affiche la carte avec sa couleur et sa valeur
     */
    public String toString() {
        return this.num+" de "+this.couleur;
    }
    /**
     * Fonction qui compare deux instances de Carte
     * Retourne :
     * 1 si carte supérieure à carte adverse
     * 0 si même valeur
     * -1 si carte inférieure à carte adverse
     */
    public int compareTo(Carte carteAdverse) {  
        if(this.num > carteAdverse.num)
            return 1;
        else if (this.num < carteAdverse.num)
            return -1;
        else
            return 0;
    }
}
