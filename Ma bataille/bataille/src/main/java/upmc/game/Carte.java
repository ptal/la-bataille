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
    
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    }
    
    /*public String getCouleur(){
        return couleur;
    }*/
    
    public int getValeur(){
        return valeur;
    }
       
    /*public boolean compareTo(Carte c2){
        if(this.valeur > c2.valeur){
            return true;
        }
        return false;
    }*/
    
    public boolean superieur(Carte c2){
        return this.valeur>c2.valeur;
    }
    public boolean inferieur(Carte c2){
        return this.valeur<c2.valeur;
    }
    
    public String toString(){
        return couleur+" "+valeur;
        
    }
}