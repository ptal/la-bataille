/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class Carte {
    private int num;
    private String couleur;
    
    // CONSTRUCTEURS
    public Carte(){
        this.num=0;
        this.couleur="Joker";
    }
    public Carte( int pNum, String pCouleur ){
        this.num = pNum;
        this.couleur = pCouleur;
    }
    
    //METHODES
    public int getNum(){
        return this.num;
    }
    public String getCouleur(){
        return this.couleur;
    }
    
    public String compare(Carte cCarte_adverse, Joueur pJoueur_1, Joueur pJoueur_2, ArrayList pCartes_a_gagner, int pCondition_de_victoire){
        
        String resultat;
        Joueur gagnant=pJoueur_1;
        
        if(this.num==cCarte_adverse.num){
            resultat = "BATAILLE !";
        }else{
            if ( this.num < cCarte_adverse.num ){
                gagnant = pJoueur_2;

            }
            pCartes_a_gagner.add(this);
            pCartes_a_gagner.add(cCarte_adverse);
            resultat = gagnant + " gagne "+ pCartes_a_gagner.size()+ " cartes.";
            
            gagnant.gagne_cartes( pCartes_a_gagner, pCondition_de_victoire);
        }
        
        
        
        return resultat;
    }
    
    
    public String toString(){
        String numero=new String();
        numero="le " + numero.valueOf(this.num);
        switch(this.num){
            case 11:
                numero="le valet";
                break;
            case 12 :
                numero="la reine";
                break;
            case 13 : 
                numero="le roi";
                break;
            case 14 :
                numero="l'As";
                break;
        }
        String str=  numero + " de " +couleur;
        return str;
    }
}
