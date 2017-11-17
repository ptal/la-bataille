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
    
    public void name(String name) {
        this.joueur = name;
    }
    
    public int nbrCarte(){
        return jeu.size();
    }
    
    public void msgPointJoueur1(Joueur joueur1, int x) {
        System.out.println(joueur1+" gagne "+x+" point");
    }
    
    public void msgPointJoueur2(Joueur joueur2, int x) {
        System.out.println(joueur2+" gagne "+x+" point");
    }
}