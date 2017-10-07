package upmc.game;
import java.util.ArrayList;

public class Joueur {
    
    private int compteur = 0; //Compteur de points
    private String joueur; //Joueur
    private Carte paquet; //Paquet de carte
    private ArrayList<Carte> jeu;
    
    public Joueur(String nom) {
        jeu = new ArrayList<Carte>();
        joueur = nom;
    }
    
    //Tire une carte
    public Carte tireCarte(Carte c){
        jeu.remove(c);
        return null;
    }
    
    //Ajoute une carte
    public Carte ajoutCarte(Carte c) {
        jeu.add(c);
        return null;
    }
    
    //Incrémentation points
    public void gagnePoint(){
        compteur++;
    }
    
    //Accésseur point
    public int getPoint(){
        return compteur;
    }

    
    
}