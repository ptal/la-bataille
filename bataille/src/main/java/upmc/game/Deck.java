/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La classe Deck représente un deck de carte
 * 
 * @author Nicolas BOULLET
 */
public class Deck {
    //--
    // Attributs
    //--
    private List<Carte> cartes = new ArrayList<Carte>();
    
    //--
    // Constructeurs
    //--
    /**
     * Constructeur par défaut faisant un deck en fonction des parametres propres au cartes.
     * Prends en parametre un boolean remplissage
     *  si false : cree un deck vide
     *  si true : rempli le deck de cartes 
     */
    public Deck(boolean remplissage) {
        if(remplissage==true){
            for(int iColor=0; iColor<Carte.COULEURS.length; iColor++) {
                for(int numCarte=1; numCarte<=Carte.NUM_MAX; numCarte++ ) {
                    Carte carteActuelle = new Carte(numCarte, Carte.COULEURS[iColor]);           
                    cartes.add(carteActuelle);
                }
            }
        }
    }
    
    //--
    // Fonctions
    //--
    /**
     * Fonction qui renvoie le nombre de carte
     */
    public int nbCartes() {
        return this.cartes.size();
    }
    
    /**
     * Fonction qui affiche le paquet de cartes en entier
     */
    public String toString() {
        String result="";
        
        for(int i=0; i<cartes.size(); i++){
            result+=(i+1)+" : "+cartes.get(i).toString()+"\n";
        }
        return result;
    }
    
    /**
     * Renvoie true si le deck est vide, false sinon 
     */
    public boolean estVide() {        
        if(this.cartes.size() == 0) 
            return true;
        else
            return false;
    }
    
    /**
     * Melange le deck
     */
    public void melange() {
        Collections.shuffle(this.cartes);
    }
    
    /**
     * Retourne la dernière cartes du deck et la supprime
     */
    public Carte derniereCarte() {
        return this.cartes.remove(cartes.size()-1);
    }
    
    /**
     *  Ajoute une carte au debut du deck
     */
    public void ajouterCarte(Carte parCarte) {
        this.cartes.add(0, parCarte);
    }
}
