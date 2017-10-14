/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;

/**
 *
 * @author NICO
 */
public class Joueur {
    
    private int points = 0; //Compteur de points
    private String joueur; //Joueur
    private ArrayList<Carte> jeu;
    
    public Joueur(String nom) {
        jeu = new ArrayList<Carte>();
        joueur = nom;
    }
    
    //Tire une carte
    public void tireCarte(Carte c){
        jeu.remove(c);
    }
    
    //Ajoute une carte
    public void ajoutCarte(Carte c) {
        jeu.add(c);
    }
    
    //Incrémentation points
    public void gagnePoint(){
        this.points++;
    }
    

    public int nbPts(){
        return points;
    }

    public Carte getCarte() {
        return jeu.get(0);   
    }
   
    public String toString() {
        return joueur;
    }   
    
}