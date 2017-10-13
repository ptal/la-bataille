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
    
    private int compteurPts;
    private ArrayList<Carte> paquet;
    private String nom;
    
    public Joueur(String nom){
        this.nom = nom;
        compteurPts = 0;
        this.paquet = new ArrayList<Carte>();
    }
    public void gagnePoint(){
        compteurPts++;
    }
    public void tireCartePaquet(Carte c) {
        this.paquet.remove(c);
    }
    public void ajoutCartePaquet(Carte c) {
        this.paquet.add(c);
    }
    public int getPoint(){
        return compteurPts;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
}