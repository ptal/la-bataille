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
        msgInitJeuEtMelange(deck);

        //Choix du mode de jeu
        modeJeu = choixModeJeu(modeJeu);
        
        //Choix du nom des joueurs
        choixPseudoJoueur(joueur1, joueur2, modeJeu);
        
        //Distribution égale des cartes entre les deux joueurs
        distributionCartes(joueur1, joueur2, deck);

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
                switch (resultatCombat) {
                    case 1:
                        System.out.println(joueur1.afficheNom()+" gagne le combat\n");
                        joueur1.gagnePoint();
                        //Le joueur 1 gagne les cartes
                        while(!deckTempo.estVide())
                            joueur1.ajouterCarte(deckTempo.derniereCarte());
                        bataille = false;
                        break;
                    case -1:
                        System.out.println(joueur2.afficheNom()+" gagne le combat\n");
                        joueur2.gagnePoint();
                        //Le joueur 2 gagne les cartes
                        while(!deckTempo.estVide())
                            joueur2.ajouterCarte(deckTempo.derniereCarte());
                        bataille = false;
                        break;
                    default:
                        System.out.println("Bataille !\n");
                        //Les deux joueurs posent une carte en plus et on revient au debut de la boucle
                        //avec cette fois plus de cartes dans le deck tempo jusqu'a qu'un joueur gagne
                        if(!joueur1.deckVide())
                            deckTempo.ajouterCarte(joueur1.tireCarte());
                        if(!joueur2.deckVide())
                            deckTempo.ajouterCarte(joueur2.tireCarte());
                        bataille = true;
                        break;
                }

                //si bataille on passe cette etape
                if(!bataille) {
                    //Demande si les joueurs veulent continuer, abandonner ou afficher des stats
                    choixSuiteJoueur(joueur1, joueur2);
                    //Si c'est un mode de jeu a 2 joueurs
                    if(modeJeu == 1 && !joueur1.boolAbandon()) {
                        choixSuiteJoueur(joueur2, joueur1);
                    }
                }
            }
            //Si mode de jeu rapide même code, mais juste affichage score au fur et a mesure
            else {
                //Comparaison
                resultatCombat = carte1.compare(carte2);
                //Si joueur 1 gagne le combat
                switch (resultatCombat) {
                    case 1:
                        joueur1.gagnePoint();
                        //Le joueur 1 gagne les cartes
                        while(!deckTempo.estVide())
                            joueur1.ajouterCarte(deckTempo.derniereCarte());
                        bataille = false;
                        break;
                    case -1:
                        joueur2.gagnePoint();
                        //Le joueur 2 gagne les cartes
                        while(!deckTempo.estVide())
                            joueur2.ajouterCarte(deckTempo.derniereCarte());
                        bataille = false;
                        break;
                    default:
                        if(!joueur1.deckVide())
                            deckTempo.ajouterCarte(joueur1.tireCarte());
                        if(!joueur2.deckVide())
                            deckTempo.ajouterCarte(joueur2.tireCarte());
                        bataille = true;
                        break;
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
     * Affiche le message d'explication au debut et melange le deck de cartes
     */
    public static void msgInitJeuEtMelange(Deck deck) {
        System.out.println("Jeu de la bataille!\n");
        System.out.println("Le jeu se joue en tour durant lesquels les deux joueurs jouent leurs cartes en meme temps.");
        System.out.println("Quand un des deux joueurs n'a plus de cartes ou se rend, le jeu s'arrete.");
        deck.melange();
    }
    
    /**
     * Demande recursivement au joueur le mode de jeu qu'il veut
     */
    public static int choixModeJeu(int modeJeu) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nChoisissez votre mode de jeu parmis les 2 suivants :");
        System.out.println(" 1. Deux joueurs\n 2. Contre IA\n 3. Mode rapide contre IA");
        System.out.println("Votre choix : ");
        modeJeu = scan.nextInt();
        
        if(modeJeu != 1 && modeJeu != 2 && modeJeu != 3)
            modeJeu = choixModeJeu(modeJeu);
        
        return modeJeu;
    }
    
    /**
     * Récupère le pseudo des joueurs en passant par un menu et les attribue
     */
    public static void choixPseudoJoueur(Joueur joueur1, Joueur joueur2, int modeJeu) {
        MenuPseudo menu = new MenuPseudo();
        LecturePseudo lecturePseudo;
        ArrayList<String> pseudos;
        
        lecturePseudo = menu.modeLecturePseudo();
        if(modeJeu == 1)
            pseudos = lecturePseudo.lirePseudo(false); //Sans IA
        else
            pseudos = lecturePseudo.lirePseudo(true); //Avec IA
        attribuePseudo(joueur1, joueur2, pseudos);
    }
    
    /**
     * Distribue toute les cartes d'un deck aux deux joueurs de maniere egale
     */
    public static void distributionCartes(Joueur joueur1, Joueur joueur2, Deck deck) {
        while(!deck.estVide()) {
            if(deck.nbCartes()%2==0)
                joueur1.ajouterCarte(deck.derniereCarte());
            else
                joueur2.ajouterCarte(deck.derniereCarte());
        }
    }
    
    /**
     * Demande au joueur ce qu'il veut faire pour la suite et agit en consequence
     */
    public static void choixSuiteJoueur(Joueur joueur, Joueur autreJoueur) {
        Scanner scanChoix = new Scanner(System.in);
        String choix = "undefined";
        
        System.out.println("Chaque joueur peut maintenant quoi faire :");
        System.out.println(" - entree : continuer\n - q+entree : abandonner\n - s+entree : afficher ses stats");

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
     * Attribue les noms aux différents joueurs
     */
    public static void attribuePseudo(Joueur joueur1, Joueur joueur2, ArrayList<String> tabPseudo) {
        joueur1.setNom(tabPseudo.get(0));
        joueur2.setNom(tabPseudo.get(1));
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


