/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author licence
 */
public class Joueur {
    
    private ArrayList<Carte> cartes = new ArrayList<Carte>();

    public Joueur() {
        
    }
    
    public void pioche() {
        this.cartes.add(new Carte());
    }

    public void affCartes() {
        for (Carte carte: this.cartes) {
            System.out.println(carte.getValeur() + ", " + carte.getForme());
        }
    }

    public int getNbCartes() {
        return this.cartes.size();
    }
}
