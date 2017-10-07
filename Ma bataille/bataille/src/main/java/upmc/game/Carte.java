/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author NICO
 */
public class Carte {
    private String couleur;
    private int valeur;
    
    public String getCouleur(){
        return couleur;
    }
    
    public int getValeur(){
        return valeur;
    }
    
    public String afficher()    {
        return couleur+" "+valeur;
    }
    
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    }
    
    public String toString(){
        return couleur+" "+valeur;
        
    }
    
    public boolean compareTo(Carte c2){
        Carte c1 = this;
        if(c1.valeur > c2.valeur){
            return true;
        }
        return false;
    }
}