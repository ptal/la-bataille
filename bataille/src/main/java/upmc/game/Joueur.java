/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Joueur {
    
    private ArrayList<Carte> cartes = new ArrayList<Carte>();
    private String nom;

    public Carte pioche(int index) {
        Carte carte = cartes.get(index);
        cartes.remove(index);
        return carte;
    }

    public Carte getLastCarte() {
        return this.cartes.get(this.cartes.size()-1);
    }

    public void affCartes() {
        int i = 0;
        for (Carte carte: cartes) {
            System.out.println(i + ": " + carte.toString());
            i++;
        }
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public String getNom() {
        return nom;
    }
}
