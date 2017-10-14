/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


/**
 *
 * @author NICO
 */
public class Bataille
{
  public static void main(String[] args)
  {
     
      
    // Création joueur N°1
    System.out.print("Nom du Joueur 1: ");
    System.out.flush();
    Scanner console = new Scanner(System.in);
    String j1 = console.nextLine();
    Joueur joueur1 = new Joueur (j1);
       
    // Création joueur N°2
    System.out.print("Nom du Joueur 2: ");
    System.out.flush();
    String j2 = console.nextLine();
    Joueur joueur2 = new Joueur (j2);
  

    
    
    //Tableau de carte
    ArrayList<Carte> jeu = new ArrayList<Carte>();
    
    //Création d'une carte
    System.out.println("C'est le jeu de la bataille!\n");
    
    for (int j = 1; j<=4; j++) {
       
        for (int v = 1; v<=13; v++) {
             Carte c = new Carte(j,v);
             jeu.add(c);
        }
    }
    
   Collections.shuffle(jeu);
      
       
       for (int p = 0; p < 26; p++) { // Ajout carte Joueur 1
        joueur1.ajoutCarte(jeu.get(p));
           }
       
       for (int m = 26; m < 52; m++) { // Ajout carte Joueur 2
        joueur2.ajoutCarte(jeu.get(m));
           }
    
       while(joueur1.nbPts() != 52 || joueur2.nbPts() != 52 ){
       
       
            System.out.print("Appuyez sur entrer pour tirer une carte");
            System.out.flush();
            console.nextLine();
        
            System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
            System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
        
            
            if(joueur1.getCarte() == joueur2.getCarte()){
                
                 System.out.println (joueur1 + " tire la carte cachée " + joueur1.getCarte().getCouleur());
                 System.out.println (joueur2 + " tire la carte cachée " + joueur2.getCarte().getCouleur());
                 
                 System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
                 System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
         
            }
            else if (joueur1.getCarte().comparateur(joueur2.getCarte())) {
            
                joueur1.gagnePoint();
                joueur1.tireCarte(joueur1.getCarte());
                joueur2.tireCarte(joueur2.getCarte());
                System.out.println (joueur1 + " gagne 1 point");
            }
        
            else {
                joueur2.gagnePoint();
                joueur1.tireCarte(joueur1.getCarte());
                joueur2.tireCarte(joueur2.getCarte());
                System.out.println (joueur2 + " gagne 1 point");
            }
            
            
            System.out.println ("=====================");
            System.out.println (joueur1 + " à " +joueur1.nbPts()+" points." );
            System.out.println (joueur2 + " à " +joueur2.nbPts()+" points."  );
            System.out.println ("=====================" );
       }
       if(joueur1.nbPts() == 52){
           System.out.println ( "le joueur 1 à gagné !" );
  
       }
       else{
           System.out.println ( "le joueur 2 à gagné !" );
       }
  }
}