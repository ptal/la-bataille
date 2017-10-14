// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Bataille
{
  public static void main(String[] args)
  {
     
      
  // Création joueur N°1
  System.out.print("Veuillez entrer un nom pour le Joueur 1: ");
  System.out.flush();
  Scanner console = new Scanner(System.in);
  String j1 = console.nextLine();
  Joueur joueur1 = new Joueur (j1);
       
  // Création joueur N°2
  System.out.print("Veuillez entrer un nom pour le Joueur 2: ");
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
    
    System.out.print("Appuyez sur entrer pour tirer une carte");
    System.out.flush();
    console.nextLine();
        
    System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
    System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
           
        
  // Première Comparaison
  switch (joueur1.getCarte().comparateurvaleur(joueur2.getCarte()))
        
    {
    case 1:    
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        jeu.remove(joueur1.getCarte());
        jeu.remove(joueur2.getCarte());
        System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
        System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
        
        if (joueur1.getCarte().comparateur(joueur2.getCarte())) {
            joueur1.gagnePoint();
            joueur1.gagnePoint();
            joueur1.tireCarte(joueur1.getCarte());
            joueur2.tireCarte(joueur2.getCarte());
            jeu.remove(joueur1.getCarte());
            jeu.remove(joueur2.getCarte());
            System.out.println (joueur1 + " gagne 2 point");
        }
            
        else {
            joueur2.gagnePoint();
            joueur2.gagnePoint();
            joueur1.tireCarte(joueur1.getCarte());
            joueur2.tireCarte(joueur2.getCarte());
            jeu.remove(joueur1.getCarte());
            jeu.remove(joueur2.getCarte());
            System.out.println (joueur2 + " gagne 2 point");
            }; break;
            
    case 2:
        joueur1.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        jeu.remove(joueur1.getCarte());
        jeu.remove(joueur2.getCarte());
        System.out.println (joueur1 + " gagne 1 point"); 
        break;
                    
    case 3: 
        joueur2.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        jeu.remove(joueur1.getCarte());
        jeu.remove(joueur2.getCarte());
        System.out.println (joueur2 + " gagne 1 point"); 
        break;
    }
        
  //Demande au joueur si il veux continuer ou quitter
  
        
  int choice = 1; 
  
  while (jeu.size()!=0 && choice == 1) { 
    
      
  System.out.println("(1) Tirer la prochaine Carte");
  System.out.println("(2) Quitter");
  System.out.flush();
  choice = console.nextInt();
 
  
        
  if (choice == 1 ) {
    System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
    System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());

  
  }
        
  else {
    System.exit(0);  
  }
        
           
        while (jeu.size()!=0 && choice == 1) { 
                
    if (joueur1.getCarte().comparateur(joueur2.getCarte())) {
        
        joueur1.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        jeu.remove(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        jeu.remove(joueur1.getCarte()); //Supprime carte du jeu 
        jeu.remove(joueur2.getCarte());
        System.out.println ("Il ne reste que " + jeu.size() +" cartes a jouer");
        System.out.println (joueur1 + " gagne 1 point");
    }
        
    else {
        joueur2.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        jeu.remove(joueur1.getCarte());
        jeu.remove(joueur2.getCarte());
        System.out.println ("Il ne reste que " + jeu.size() +" cartes a jouer");
        System.out.println (joueur2 + " gagne 1 point");
    }
        
  }
        
  //Gagnant de la partie
    if (jeu.size() == 0) {
        joueur1.getPoint();
        joueur2.getPoint();
            
        if (joueur1.getPoint() == 52) {
            System.out.println ("Le joueur "+joueur1+" a gagner la partie !");
        }
            
        else {
            System.out.println ("Le joueur "+joueur2+" a gagner la partie !");
        }
    }     
       
  }
  
  }
  
}





