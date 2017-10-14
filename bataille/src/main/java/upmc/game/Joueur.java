package upmc.game;

public class Joueur {
	
    private String name;
    private int pts;
    protected Paquet deck;		//A defaut d'utiliser des extends entre classes, attribut protected permet d'acceder au deck depuis le joueur
    
    public Joueur( String nom ) {
    	if( nom == "" ) {
    		name = "Anonyme";
    	} else {
    		name = nom;
    	}        
    }
    
    //Retourne le nom du joueur
    public String toString() {
    	
    	return name;
    	
    }
    
    //Creation du paquet (et reinitialisation des points en cas de restart)
    public void createPaquet() {
    	deck = new Paquet();
    	pts = 0;
    }
    
    //Compteur de points
    public void addPts() {
    	
        this.pts++;
        
    }
    
    //Retourne le nombre de pts
    public int nbPts() {
    	
    	return pts;
    	
    }
}
