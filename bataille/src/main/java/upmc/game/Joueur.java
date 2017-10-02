/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 * La classe joueur représente un joueur avec son paquet de carte
 * 
 * @author Nicolas
 */
public class Joueur {
    //--
    // Attributs
    //--
    private String nom = "default";
    private Deck deck = new Deck(false);
    private boolean abandon = false;
    private int point = 0;
    
    //--
    // Constructeurs
    //--
    /**
     * Constructeur d'un joueur avec un paquet vide,
     * qui prends en parametre son nom
     */
    public Joueur(String parNom) {
        this.nom = parNom;
    }
    
    //--
    // Fonctions
    //--
    /**
     * Affiche le joueur, son nombre de cartes et ses points
     */
    public String toString() {
        return this.nom+"("+this.deck.nbCartes()+" cartes) : "+this.point+" points";
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
     * Affiche le nombre de carte
     */
    public String afficheNbCartes() {
        return "Le joueur "+this.nom+" possede "+this.deck.nbCartes()+" cartes";
    }
    
    /**
     * Change le nom du joueur pour le nom en parametre
     */
    public void setNom(String parNom) {
        this.nom = parNom;
    }
    
    /**
     * Fait passer l'attribut abandon du joueur a true
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
    public void ajouterCarte(Carte parCarte) {
        this.deck.ajouterCarte(parCarte);
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
