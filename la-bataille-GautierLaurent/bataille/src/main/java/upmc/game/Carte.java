/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author sena-
 */
public class Carte {
    private String couleur;
    private int valeur;
    

    
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCouleur(){
        return couleur;
    }

    public int getValeur(){
        return valeur;
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    
    public Carte Compare(Carte c){
        if(this.getValeur()>c.getValeur()){
            return this;
        }
        else{
            return c;
        }
    }
    
    
    public String toString(){
        return "La valeur de la carte est : "+this.valeur+"\nLa couleur de la carte est : "+this.couleur;
    }
    
    
    
}
