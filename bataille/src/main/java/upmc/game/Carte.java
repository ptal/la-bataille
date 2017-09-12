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
    private String color;
    private int valeur;
    
    public Carte (String color, int valeur){
        this.color = color;
        this.valeur = valeur;
    }
    
    public String toString (){
        return "Couleur = " + color + "\nValeur = " + valeur;
    }
}
