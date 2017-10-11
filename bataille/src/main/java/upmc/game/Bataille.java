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

import java.util.Scanner;

/**
 * Bataille est la classe qui contient la fonction principale du jeu de bataille
 * 
 * @author Nicolas BOULLET
 */
public class Bataille {
    public static void main(String[] args) {
        //Initialisation variables
        Scanner scan = new Scanner(System.in);
        int modeJeu = 0;
        int resultatCombat = 0;
        boolean bataille = false;
        Deck deckTempo = new Deck(false);
        Deck deck = new Deck(true);
        Joueur joueur1 = new Joueur("Default1");
        Joueur joueur2 = new Joueur("Default2");
        Carte carte1;
        Carte carte2;
        
        //Initialisation du jeu
        System.out.println("Jeu de la bataille!\n");
        System.out.println("Le jeu se joue en tour durant lesquels les deux joueurs jouent leurs cartes en meme temps.");
        System.out.println("Quand un des deux joueurs n'a plus de cartes ou se rend, le jeu s'arrete.");
        deck.melange();
        
        //Choix du mode de jeu
        while(modeJeu != 1 && modeJeu != 2 && modeJeu != 3) {
            System.out.println("\nChoisissez votre mode de jeu parmis les 2 suivants :");
            System.out.println(" 1. Deux joueurs\n 2. Contre IA\n 3. Mode rapide contre IA");
            System.out.println("Votre choix : ");
            modeJeu = scan.nextInt();
        }
        scan.nextLine(); //vide la ligne
        
        //Choix du nom des joueurs
        System.out.println("Entre le nom du Joueur 1 : ");
        joueur1.setNom(scan.nextLine());
        if(modeJeu == 1) {
            System.out.println("Entre le nom du Joueur 2 : ");
            joueur2.setNom(scan.nextLine());
        }
        else {
            joueur2.setNom("IA");
        }
        
        //Distribution égale des cartes entre les deux joueurs
        while(!deck.estVide()) {
            if(deck.nbCartes()%2==0)
                joueur1.ajouterCarte(deck.derniereCarte());
            else
                joueur2.ajouterCarte(deck.derniereCarte());
        }
        
        //Boucle de jeu principale
        while(!joueur1.deckVide() && !joueur2.deckVide() && !joueur1.boolAbandon() && !joueur2.boolAbandon()) {
            //Les joueurs tirent leurs cartes puis elles sont place dans une pile temporaire pour la suite
            carte1 = joueur1.tireCarte();
            carte2 = joueur2.tireCarte();
            deckTempo.ajouterCarte(carte1);
            deckTempo.ajouterCarte(carte2);
            
            if(modeJeu != 3) {
                //Comparaison
                if(!bataille)
                    System.out.println("\n------");
                System.out.println(carte1.toString()+"("+joueur1.afficheNom()+") VS "+carte2.toString()+"("+joueur2.afficheNom()+")");
                resultatCombat = carte1.compare(carte2);

                //Si joueur 1 gagne le combat
                if(resultatCombat == 1) {
                    System.out.println(joueur1.afficheNom()+" gagne le combat\n");
                    joueur1.gagnePoint();
                    //Le joueur 1 gagne les cartes
                    while(!deckTempo.estVide())
                        joueur1.ajouterCarte(deckTempo.derniereCarte());

                    bataille = false;
                }
                //Si joueur 2 gagne le combat
                else if(resultatCombat == -1) {
                    System.out.println(joueur2.afficheNom()+" gagne le combat\n");
                    joueur2.gagnePoint();
                    //Le joueur 2 gagne les cartes
                    while(!deckTempo.estVide())
                        joueur2.ajouterCarte(deckTempo.derniereCarte());

                    bataille = false;
                }
                //Si bataille
                else {
                    System.out.println("Bataille !\n");
                    //Les deux joueurs posent une carte en plus et on revient au debut de la boucle 
                    //avec cette fois plus de cartes dans le deck tempo jusqu'a qu'un joueur gagne
                    if(!joueur1.deckVide())
                        deckTempo.ajouterCarte(joueur1.tireCarte());
                    if(!joueur2.deckVide())
                        deckTempo.ajouterCarte(joueur2.tireCarte());
                    bataille = true;
                }

                //si bataille on passe cette etape
                if(!bataille) {
                    //Demande si les joueurs veulent continuer ou abandonner
                    System.out.println("Chaque joueur peut maintenant quoi faire :");
                    System.out.println(" - entree : continuer\n - q+entree : abandonner\n - s+entree : afficher ses stats");
                    choixJoueur(joueur1, joueur2);
                    //Si c'est un mode de jeu a 2 joueurs
                    if(modeJeu == 1) {
                        choixJoueur(joueur2, joueur1);
                    }
                }
            }
            //Si mode de jeu rapide même code, mais juste affichage score au fur et a mesure
            else {
                //Comparaison
                resultatCombat = carte1.compare(carte2);
                //Si joueur 1 gagne le combat
                if(resultatCombat == 1) {
                    joueur1.gagnePoint();
                    //Le joueur 1 gagne les cartes
                    while(!deckTempo.estVide())
                        joueur1.ajouterCarte(deckTempo.derniereCarte());
                    bataille = false;
                }
                //Si joueur 2 gagne le combat
                else if(resultatCombat == -1) {
                    joueur2.gagnePoint();
                    //Le joueur 2 gagne les cartes
                    while(!deckTempo.estVide())
                        joueur2.ajouterCarte(deckTempo.derniereCarte());
                    bataille = false;
                }
                //Si bataille
                else {
                    if(!joueur1.deckVide())
                        deckTempo.ajouterCarte(joueur1.tireCarte());
                    if(!joueur2.deckVide())
                        deckTempo.ajouterCarte(joueur2.tireCarte());
                    bataille = true;
                }
                if(bataille)
                    System.out.println("Bataille !");
                System.out.println(joueur1.toString()+"\n"+joueur2.toString());
            }
        }
        
        //Affiche le joueur gagnant
        afficheGagnant(joueur1, joueur2);
        
    }
    
    /**
     * Demande au joueur ce qu'il veut faire et agit en consequence
     */
    public static void choixJoueur(Joueur joueur, Joueur autreJoueur) {
        Scanner scanChoix = new Scanner(System.in);
        String choix = "undefined";
        
        while(!choix.equals("") && !choix.equals("q")) {
            System.out.println(joueur.afficheNom()+" : Que voulez-vous faire ? ");
            choix = scanChoix.nextLine();
            
            System.out.println("Choix : "+choix);
            //abandonne
            if(choix.equals("q")) {
                joueur.abandonne();
                System.out.println("Le joueur "+joueur.afficheNom()+" abandonne !");
            }
            //Affiche les stats
            else if(choix.equals("s")) {
                System.out.println(joueur.toString());
                System.out.println(autreJoueur.toString());
            }
        }
    }
    
    /**
     * Affiche le gagnant
     */
    public static void afficheGagnant(Joueur joueur1, Joueur joueur2) {
        //Si abandon
        if(joueur1.boolAbandon())
            System.out.println(joueur1.afficheNom()+" a perdu par abandon ! "+joueur2.afficheNom()+" a gagné !");
        else if(joueur2.boolAbandon())
            System.out.println(joueur2.afficheNom()+" a perdu par abandon ! "+joueur1.afficheNom()+" a gagné !");
        //Si plus de cartes
        else if(joueur1.deckVide())
            System.out.println(joueur2.afficheNom()+" a gagné car, "+joueur1.afficheNom()+" n'a plus de cartes !");
        else if(joueur2.deckVide())
            System.out.println(joueur1.afficheNom()+" a gagné car, "+joueur2.afficheNom()+" n'a plus de cartes !");
        
        System.out.println("===================");
        System.out.println("Score final : ");
        System.out.println(joueur1.toString()+" | "+joueur2.toString());
        System.out.println("===================");
    }
}


