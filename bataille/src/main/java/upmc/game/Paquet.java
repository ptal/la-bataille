package upmc.game;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	
    private ArrayList<Carte> PaquetDeCarte = new ArrayList<Carte>();
    
    public Paquet() {
    	
    }
    
    //Retourne carte precise du paquet en cours
    public Carte getCard( int i ) {
    	
    	return PaquetDeCarte.get( i );
    	
    }
    
    //Ajoute une carte au paquet en cours
    public void addCard( Carte card ) {
    	
    	PaquetDeCarte.add( card );
    	
    }
    
    //Supprime une carte au paquet en cours
    public void removeCard( Carte card ) {
    	
    	PaquetDeCarte.remove( card );
    	
    }
    
    //Retourne le nombre de cartes restantes du paquet en cours
    public int nbCard() {
    	
    	return PaquetDeCarte.size();
    	
    }
    
    //Melange les cartes du paquet en cours
    public void melange() {
    	
    	Collections.shuffle( PaquetDeCarte );
    	
    }
    
    
    
}
