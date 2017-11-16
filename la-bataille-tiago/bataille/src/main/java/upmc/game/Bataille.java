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
   int choice = 1;
   Joueur joueur1 = new Joueur ("");
   Joueur joueur2 = new Joueur ("");
   
   MenuPseudo.modeLecturePseudo(choice); 
  
    if (choice == 1) {
        LectureConsole.lirePseudo();
        pseudoJoueur(joueur1, joueur2);
        
    }
    
    else {
        System.out.println("Fonctionnalité non disponible");
    }
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
    Scanner console = new Scanner(System.in); 
    System.out.print("Appuyez sur entrer pour tirer une carte");
    System.out.flush();
    console.nextLine();
    processus(joueur1 , joueur2);      
        

        
  //Demande au joueur si il veux continuer ou quitter
  

  while (endGame(joueur1, joueur2)) { 
    
      
  System.out.println("[1] Tirer la prochaine Carte");
  System.out.println("[2] Quitter");
  System.out.flush();
  choice = console.nextInt();
 
  
        
  if (choice == 1 ) {
      processus(joueur1 , joueur2);

  }
        
  else {
    System.exit(0);  
  }
       
        
     
       
  }
  System.exit(0);
  
  }
  
  public static boolean endGame(Joueur joueur1, Joueur joueur2){
        //Gagnant de la partie
    if ((joueur1.nbCard() == 0) || (joueur2.nbCard()==0)) {
        joueur1.getPoint();
        joueur2.getPoint();
            
        if (joueur1.getPoint() == 52) {
            System.out.println ("Le joueur "+joueur1+" a gagner la partie !");
        }
            
        else {
            System.out.println ("Le joueur "+joueur2+" a gagner la partie !");
        }
        return false;
    }else {
        return true;
    }
  }
  
  public static void processus(Joueur joueur1, Joueur joueur2) {
    System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
    System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
  // Première Comparaison
  switch (joueur1.getCarte().comparateurvaleur(joueur2.getCarte()))
        
    {
    case 1:    
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
        System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
        
        if (joueur1.getCarte().comparateur(joueur2.getCarte())) {
            joueur1.gagnePoint();
            joueur1.gagnePoint();
            joueur1.tireCarte(joueur1.getCarte());
            joueur2.tireCarte(joueur2.getCarte());
            System.out.println (joueur1 + " gagne 2 point");
        }
            
        else {
            joueur2.gagnePoint();
            joueur2.gagnePoint();
            joueur1.tireCarte(joueur1.getCarte());
            joueur2.tireCarte(joueur2.getCarte());
            System.out.println (joueur2 + " gagne 2 point");
            }; break;
            
    case 2:
        joueur1.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        System.out.println (joueur1 + " gagne 1 point"); 
        break;
                    
    case 3: 
        joueur2.gagnePoint();
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
        System.out.println (joueur2 + " gagne 1 point"); 
        break;
    }
  }
  
  
  
    public static void Pseudo(Joueur joueur1, Joueur joueur2, ArrayList<String> pseudo) {
        joueur1.name(pseudo.get(0));
        joueur2.name(pseudo.get(1));
    }
  
      public static void pseudoJoueur(Joueur joueur1, Joueur joueur2) {
        MenuPseudo menu = new MenuPseudo();
        LectureConsole lirePseudo;
        ArrayList<String> pseudo;
        pseudo = LectureConsole.lirePseudo(); //Sans IA
        Pseudo(joueur1, joueur2, pseudo);
}
      
}


  






