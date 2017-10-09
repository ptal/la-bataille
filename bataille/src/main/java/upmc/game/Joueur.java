package tp_bataille;

import java.util.ArrayList;

public class Joueur {
	
	private ArrayList<Carte> main_joueur;
	// private String nom;
	
	public Joueur() {
		main_joueur = new ArrayList<Carte>();
	}
	
	
	/*public Joueur( String nom) {
		super();
		
		this.nom = nom;
	}*/


	public Carte tireCarte() {
		return main_joueur.remove(0);
	}
	
	public void ajouterCarte(Carte c) {
		main_joueur.add(c);
	}
	
	public int compteur() {
		return main_joueur.size();
	}
	
	public String toString(Carte c) {
		return "Carte : " + c.getCouleur() + " " + c.getValeur();		
	}

}
