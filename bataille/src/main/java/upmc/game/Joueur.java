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
public class Joueur {
    private int numero;
    private ArrayList tas_de_carte=new ArrayList();
    private int nombre_de_cartes_gagnees=0;
    private String nom;
    
    public Joueur(int pNumero, ArrayList pPaquet, String pNom){
        this.numero=pNumero;
        this.nom=pNom;
        this.distribution(pPaquet);
    }
    
    private void distribution(ArrayList pPaquet){
        int i=0;
        for(int j=0 ; j < pPaquet.size() ; j++){
            if( j % 2 == this.numero ){
                this.tas_de_carte.add( pPaquet.get(j) );
                j++;
            }
        }
    }
    
    public Carte joue(){
        Carte c = (Carte) this.tas_de_carte.get(0);
        this.tas_de_carte.remove(0);
        
        Bataille.affiche(this + " a tiré " + c);
        return c;
    }
    
    public String toString(){
        String str=this.nom;
        return str;
    }
    
    public int affiche_nombre_cartes_restantes(){
        return this.tas_de_carte.size();
    }
    
    public void gagne_cartes(ArrayList pCartes_gagnees, int pCondition_de_victoire){
        
        for(int i=0; i<pCartes_gagnees.size(); i++){
            if(pCondition_de_victoire==1){
                this.nombre_de_cartes_gagnees ++;
            }else{
                this.tas_de_carte.add(pCartes_gagnees.get(i));
            }
        }
    }
    
    public String compare_points( Joueur pJoueur_adverse , int pCondition_de_victoire){
        
        String str;
        int points_joueur;
        int points_joueur_adverse; 
        
        
        if(pCondition_de_victoire==1){
            points_joueur = this.nombre_de_cartes_gagnees;
            points_joueur_adverse = pJoueur_adverse.nombre_de_cartes_gagnees;
            
        }else{
            points_joueur = this.tas_de_carte.size();
            points_joueur_adverse = pJoueur_adverse.tas_de_carte.size(); 
        }
        
        str = this + " a " + points_joueur + " cartes.";
        str += "\n" + pJoueur_adverse + " a " + points_joueur_adverse + " cartes.";
        
        if(this.tas_de_carte.size()==0 || pJoueur_adverse.tas_de_carte.size()==0){
                str+= fin_de_partie(points_joueur_adverse, points_joueur, this, pJoueur_adverse); 
         }
        return str;
    }
    
    private String fin_de_partie(int points_joueur_adverse, int points_joueur, Joueur pJoueur, Joueur pJoueur_adverse){
        String str;
        Joueur gagnant=this;
        if(points_joueur_adverse == points_joueur){
            str="Incroyable ! Il y a égalité !";
        }else{
            if(points_joueur_adverse >points_joueur){
                gagnant=pJoueur_adverse;
            }
            str = "\n"+gagnant+" a gagné la partie !";
        }
        return str;
    }
}
