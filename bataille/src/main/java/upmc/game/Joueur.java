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
    
    public void affCartes() {
	    for (Carte carte: this.cartes) {
	        System.out.println(carte.getValeur() + ", " + carte.getForme());
	    }
	}

	public int getNbCartes() {
	    return this.cartes.size();
	}

	public void pioche() {
        this.cartes.add(new Carte());
    }
}