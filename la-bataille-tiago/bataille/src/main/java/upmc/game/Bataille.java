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
    public static void main(String[] args) {
    
    int choix = 0;
    boolean ordinateur = false;
    Joueur joueur1 = new Joueur ("");
    Joueur joueur2 = new Joueur ("");
    ArrayList<String> pseudo;
    
    
    choix = MenuPseudo.modeLecturePseudo(choix);
   
    if (choix == 1) {
        pseudo = LectureConsole.lirePseudo(ordinateur);
        pseudoJoueur(joueur1, joueur2, pseudo);
    }
    
    else {
        ordinateur = true;
        pseudo = LectureConsole.lirePseudo(ordinateur);
        pseudoJoueur(joueur1, joueur2, pseudo);
       
    }
    
    //Tableau de cartes
    ArrayList<Carte> jeu = new ArrayList<Carte>();
    
    //Création des cartes
    System.out.println("C'est le jeu de la bataille!\n");
    
    for (int j = 1; j<=4; j++) {
        for (int v = 1; v<=13; v++) {
            Carte c = new Carte(j,v);
            jeu.add(c);
        }
    }

    Collections.shuffle(jeu); //Mélange les cartes du jeu
      
       
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
    partie(joueur1 , joueur2); //Lancement de la partie   
        
    //Continuer à tirer une carte / Quitter
    while (finPartie(joueur1, joueur2)) {
       
        System.out.println("[1] Tirer la prochaine Carte");
        System.out.println("[2] Quitter");
        System.out.flush();
        choix = console.nextInt();
 
        if (choix == 1 ) {
            partie(joueur1 , joueur2);
        }
        
        else {
            System.exit(0);  
        }
    }
            System.exit(0);
    }
  
    public static boolean finPartie(Joueur joueur1, Joueur joueur2){
        //Gagnant de la partie
        if ((joueur1.nbrCarte() == 0) || (joueur2.nbrCarte()==0)) {
            
            
        if (joueur1.getPoint() > joueur2.getPoint()) {
            System.out.println ("Le joueur "+joueur1+" a gagner la partie avec : "+joueur1.getPoint());
        } 
        else {
            System.out.println ("Le joueur "+joueur2+" a gagner la partie avec : "+joueur2.getPoint());
        }
            return false;
        }
        else {
            return true;
        }
    }
  
    public static void partie(Joueur joueur1, Joueur joueur2) {
        System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
        System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
        // Première Comparaison
        switch (joueur1.getCarte().comparateurBataille(joueur2.getCarte())) {
                
            case 1:    
                System.out.println("----------- Bataille ! -----------");
                tireCarte(joueur1, joueur2);
                System.out.println (joueur1 + " tire la carte " + joueur1.getCarte().getCouleur());
                System.out.println (joueur2 + " tire la carte " + joueur2.getCarte().getCouleur());
        
                if (joueur1.getCarte().comparateurValeur(joueur2.getCarte())) {
                    joueur1.gagnePoint();
                    joueur1.gagnePoint();
                    tireCarte(joueur1, joueur2);
                    joueur1.msgPointJoueur1(joueur1,2);
                }
            
                else {
                    joueur2.gagnePoint();
                    joueur2.gagnePoint();
                    tireCarte(joueur1, joueur2);
                    joueur2.msgPointJoueur2(joueur2,2);
                }; break;
            
            case 2:
                joueur1.gagnePoint();
                tireCarte(joueur1, joueur2);
                joueur1.msgPointJoueur1(joueur1,1);
                break;
                    
            case 3: 
                joueur2.gagnePoint();
                tireCarte(joueur1, joueur2);
                joueur2.msgPointJoueur2(joueur2,1);
                break;
        }
    }
  
    public static void pseudoJoueur(Joueur joueur1, Joueur joueur2, ArrayList<String> pseudo) {
        joueur1.nom(pseudo.get(0));
        joueur2.nom(pseudo.get(1));
    }
    
    public static void tireCarte(Joueur joueur1, Joueur joueur2) {
        joueur1.tireCarte(joueur1.getCarte());
        joueur2.tireCarte(joueur2.getCarte());
    }  
}