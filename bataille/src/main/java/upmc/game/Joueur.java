package upmc.game;

/**
 *
 * @author fiquetg
 */
public class Joueur {
    private String nom ;
   
    private Paquet deck = new Paquet(false);
    private boolean abandon = false;
    private int point = 0;
   
    public Joueur(String pnom) {
        this.nom = pnom;
    }
    
    public String toString() {
        if (this.deck.nbCartes() <= 1 && this.point <= 1) 
            return this.nom+" : "+this.deck.nbCartes()+" carte / "+this.point+" point";
        else if (this.deck.nbCartes() > 1 && this.point <= 1)
            return this.nom+" : "+this.deck.nbCartes()+" cartes / "+this.point+" point";
        else if (this.deck.nbCartes() <= 1 && this.point > 1)
            return this.nom+" : "+this.deck.nbCartes()+" carte / "+this.point+" points";
        else
            return this.nom+" : "+this.deck.nbCartes()+" cartes / "+this.point+" points";
    }
    
    /**
     * Affiche le nom du joueur
     */
    public String afficheNom() {
        return this.nom;
    }
    
    /**
     * Affiche le score actuel du joueur
     */
    public String afficheScore() {
        return "Le score de "+this.nom+" est de "+this.point;
    }
    
    /**
     * Affiche le nombre de cartes
     */
    public String afficheNbCartes() {
        if (this.deck.nbCartes() <= 1)
            return "Le joueur "+this.nom+" possede "+this.deck.nbCartes()+" carte";
        else
            return "Le joueur "+this.nom+" possede "+this.deck.nbCartes()+" cartes";
    }
    
    /**
     * Change le nom du joueur
     */
    public void setNom(String pnom) {
        this.nom = pnom;
    }
    
    /**
     * Fait passer l'attribut abandon du joueur a vrai
     */
    public void abandonne() {
        this.abandon = true;
    }
    
    /**
     * Renvoie un boolean pour indiquer si le joueur a abandonner
     */
    public boolean boolAbandon() {
        if(this.abandon)
            return true;
        else
            return false;
    }
    
    /**
     * Indique par true si le deck du joueur est vide, false sinon
     */
    public boolean deckVide() {
        if(this.deck.estVide())
            return true;
        else
            return false;
    }
    
    /**
     * Ajoute une carte au debut du deck du joueur
     */
    public void ajouterCarte(Carte pCarte) {
        this.deck.ajouterCarte(pCarte);
    }
    
    /**
     * Tire une carte pour pouvoir la jouer
     */
    public Carte tireCarte() {
        return deck.derniereCarte();
    }
    
    /**
     * Ajoute un point au score du joueur
     */
    public void gagnePoint() {
        this.point++;
    }
}

