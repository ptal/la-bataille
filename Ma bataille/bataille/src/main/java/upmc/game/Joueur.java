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
public class Joueur {
    
    private int compteurPts;
    private Paquet paquet;
    private String nom;
    
    public Joueur(String nom){
        this.nom = nom;
        compteurPts = 0;
        paquet = new Paquet();
    }
      
    public Carte tireCarte(){
        return paquet.tireCartePaquet();
    }
    
    public void gagnePoint(){
        compteurPts++;
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
