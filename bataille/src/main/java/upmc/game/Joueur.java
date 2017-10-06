package upmc.game;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Joueur {
    
    private ArrayList<Carte> cartes = new ArrayList<Carte>();
    private String nom;
    
    public String getNom() {
        return nom;
    }

    public Carte pioche(int index) {
        Carte carte = cartes.get(index);
        cartes.remove(index);
        return carte;
    }

    public void afficherCartes() {
        int i = 0;
        for (Carte carte: cartes) {
            System.out.println(i + ": " + carte.toString());
            i++;
        }
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }
    
    public Carte getderniereCarte() {
        return this.cartes.get(this.cartes.size()-1);
    }

}