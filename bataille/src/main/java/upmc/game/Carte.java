/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 * La classe Carte modelise une carte avec son numero et sa couleur
 * @author Nicolas BOULLET
 */
public class Carte {
    //--
    // Attributs
    //--
    public static String COULEURS[] = {"pique", "trefle", "coeur", "carreau"};
    public static int NUM_MAX = 13;
    
    private int valeur;
    private String couleur;
    
    //--
    // Constructeurs
    //--
    /**
     * Constructeur prenant le numero et la couleur
     */
    public Carte(int parNum, String parCouleur) {
        this.valeur = parNum;
        this.couleur = parCouleur;
    }
    
    //--
    // Fonctions
    //--
    /**
     * Fonctions qui affiche la carte avec sa couleur et sa valeur
     */
    public String toString() {
        String numFinal = "";
        
        //Transformation pour la compréhension de l'utilisateur
        if(this.valeur == 11)
            numFinal = "valet";
        else if(this.valeur == 12)
            numFinal = "dame";
        else if(this.valeur == 13)
            numFinal = "roi";
        else 
            numFinal = Integer.toString(this.valeur); //Sinon on laisse un chiffre
        
        return numFinal+" de "+this.couleur;
    }
    
    /**
     * Fonction qui compare deux instances de Carte
     * Retourne :
     * 1 si carte supérieure à carte adverse
     * 0 si même valeur
     * -1 si carte inférieure à carte adverse
     */
    public int compare(Carte carteAdverse) {  
        if(this.valeur > carteAdverse.valeur)
            return 1;
        else if (this.valeur < carteAdverse.valeur)
            return -1;
        else
            return 0;
    }
}
