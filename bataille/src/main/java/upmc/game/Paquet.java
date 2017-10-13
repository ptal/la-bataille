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
 *
 * @author NICO
 */
public class Paquet {
    private List<Carte> paquetCarte;
    private String[] valeur = {"Coeur", "Trefle", "Carreau", "Pique"};
    
    public Paquet(){
        paquetCarte = new ArrayList<Carte>();
        for (int i=0; i<4; i++){
            for(int j=1; j<=13; j++){
                paquetCarte.add(new Carte(valeur[i], j));
            }
        }
        Collections.shuffle(paquetCarte);
    }
    
    public Paquet(int nbCarte){
        paquetCarte = new ArrayList<Carte>();
        for (int i=1; i<nbCarte; i++){
            if(i<=13){
                paquetCarte.add(new Carte("Coeur", i));
            }
            if(i>13 && i<=26){
                paquetCarte.add(new Carte("Trefle", i - 13));
            }
            if(i>26 && i<=39){
                paquetCarte.add(new Carte("Carreau", i - 26));
            }
            if(i>39 && i<=52){
                paquetCarte.add(new Carte("Pique", i - 39));
            }
        }
    }

    public void tireCartePaquet(Carte c) {
        this.paquetCarte.remove(c);
    }
    public void ajoutCartePaquet(Carte c) {
        this.paquetCarte.add(c);
    }
    
     public String toString(){
        return paquetCarte.toString(); 
    }
}