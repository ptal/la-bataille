package upmc.game;
import java.util.ArrayList;

public class Joueur {
    
private int compteur = 0; //Compteur de points
private String joueur; 
private ArrayList<Carte> jeu; 
    
    public Joueur(String nom) {
        jeu = new ArrayList<Carte>();
        joueur = nom;
    }
    
    public void tireCarte(Carte c){
        jeu.remove(c);
    }
    
    public void ajoutCarte(Carte c) {
        jeu.add(c);
    }
    
    public void gagnePoint(){
        compteur++;
    }
    
    public int getPoint(){
        return compteur;
    }

    public Carte getCarte() {
        return jeu.get(0);   
    }
    
    public String toString() {
        return joueur;
    }
    
    public void nom(String nom) {
        this.joueur = nom;
    }
    
    public int nbrCarte(){
        return jeu.size();
    }
    
    public void msgPointJoueur(Joueur joueur, int x) {
        System.out.println(joueur+" gagne "+x+" point");
    }
    
    public void doublePoint(Joueur joueur) {
        for (int x=0; x<2; x++) {
            joueur.gagnePoint();
        }
    }
}