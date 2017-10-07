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

import jdk.nashorn.internal.ir.JoinPredecessorExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bataille {

  private static ArrayList<Carte> pioche;
  private int scoreLimite;
  private Scanner choixJoueur;
  private Scanner choixJoueur2;
  private Scanner choixJeu;
  private Joueur j1;
  private Joueur j2;
  private int nbTour;
  private Carte c1,c2;

  public static void main(String[] args) {
    Bataille b = new Bataille(10);
    b.jouer();
  }

  public Bataille() {
    this.scoreLimite = 20;
    this.choixJoueur = new Scanner(System.in);
    this.choixJoueur2 = new Scanner(System.in);
    this.choixJeu = new Scanner(System.in);
    this.j1 = new Joueur();
    this.j2 = new Joueur();
    this.nbTour = 1;
  }

  public Bataille(int scoreLimite) {
    this.scoreLimite = scoreLimite;
    this.choixJoueur = new Scanner(System.in);
    this.choixJoueur2 = new Scanner(System.in);
    this.choixJeu = new Scanner(System.in);
    this.j1 = new Joueur();
    this.j2 = new Joueur();
    this.nbTour = 1;
  }

  public void jouer() {
    System.out.println("C'est le jeu de la bataille!\n");
    System.out.println("Joueur 1, saisissez votre nom :");

    this.j1.setNom(choixJoueur.nextLine());
    this.choixMultijoueur();
    this.creerJeuDeCarte();
    this.distributionDesCartes();

    //La Partie
    boolean partieFini=false;
    while(!joueurAGagnerLaPartie(j1) && !joueurAGagnerLaPartie(j2) && !partieFini) {
      partieFini = this.UnTour();
    }
    this.affichageVainqueurDeLaPartie();
  }

  public boolean UnTour() {
    System.out.println("Tour "+this.nbTour+" ==============");
    //Afficher les cartes de chaque joueurs
    System.out.println("carte de "+j1.getNom()+" : "+this.j1.getCartesEnMain() +" "+this.j1.getCartesEnMain().size());
    System.out.println("carte de "+j2.getNom()+" : "+this.j2.getCartesEnMain());

    //TOUR JOUEUR 1
    this.c1 = tourJoueur(this.j1);
    if(this.c1 == null) return true;

    //TOUR JOUEUR 2
    this.c2 = tourJoueur(this.j2);
    if(this.c2 == null) return true;

    if(this.c1.compareA(this.c2) > 0) { //Si la carte du joueur 1 est meilleur que celle du joueur 2 alors joueur 1 gagne la manche
      this.j1.ajouterCarteEnMain(this.c1);
      this.j1.ajouterCarteEnMain(this.c2);
      System.out.println(j1.getNom()+" remporte le tour");
      this.j1.gagneUnPoint();
    }
    else if(this.c1.compareA(this.c2) < 0) { //Si la carte du joueur 2 est meilleur que celle du joueur 1 alors joueur 2 gagne la manche
      this.j2.ajouterCarteEnMain(this.c1);
      this.j2.ajouterCarteEnMain(this.c2);
      System.out.println(j2.getNom()+" remporte le tour");
      this.j2.gagneUnPoint();
    } else {
      Bataille.grandeBataille(this.j1,this.j2,this.c1,this.c2);
    }

    this.affichageDuScore();
    this.nbTour++;
    return false;
  }

  public Carte tourJoueur(Joueur j) {
    System.out.println(j.getNom()+", à votre tour : (1 ou autre) pour jouer , (2) pour quitter.");
    Carte c = null;
    String choixJoueur = choixJeu.nextLine();
    if(choixJoueur.equals("2")) {
      return c;
    }
    else {
      c = j.jouerCarte();
      System.out.println(j.getNom()+" joue la carte "+c.toString());
    }
    return c;
  }

  public void distributionDesCartes() {
    System.out.println("Distribution des cartes...");
    while(pioche.size()!=0) {
      int pos1 = (int) (Math.random() *(pioche.size()));
      this.j1.ajouterCarteEnMain(pioche.get(pos1));
      pioche.remove(pos1);
      int pos2 = (int) (Math.random() *(pioche.size()));
      this.j2.ajouterCarteEnMain(pioche.get(pos2));
      this.pioche.remove(pos2);
    }
  }

  public void creerJeuDeCarte() {
    this.pioche = new ArrayList<Carte>();
    for(int i=0 ; i<4 ; i++) { //Coeur , Carreau , Trefle , Pique : 4
      for(int j=1 ; j<=13 ; j++) { //1 , 2 , 3 ... Valet , Reine , Roi : 13
        pioche.add(new Carte(Carte.couleurs[i],j));
      }
    }
  }

  public void choixMultijoueur() {
    int choix=0;
    while(choix!=1 && choix!=2) {
      System.out.println("Jouer avec un deuxième joueur (1) ou avec l'IA ? (2)");
      choix = choixJoueur.nextInt();
      if(choix==1) {
        System.out.println("Joueur 2, saisissez votre nom :");
        this.j2.setNom(choixJoueur2.nextLine());
      } else if(choix==2) {
        this.j2.setNom("IA");
        this.j2.setEstHumain(false);
      } else {
        System.out.print("Erreur : ");
      }
    }
  }

  public static void grandeBataille(Joueur j1, Joueur j2, Carte c1, Carte c2) {
    ArrayList<Carte> tas = new ArrayList<Carte>();
    tas.addAll(Arrays.asList(c1,c2));
    System.out.println("BATAILLE !!!\n");
    do {
      c1 = j1.jouerCarte();
      tas.add(c1);
      System.out.println(j1.getNom() + " joue la carte " + c1.toString());
      c2 = j2.jouerCarte();
      tas.add(c2);
      System.out.println(j2.getNom() + " joue la carte " + c2.toString());
      if (c1.compareA(c2) > 0) {
        j1.ajouterPlusieursCartesEnMain(tas);
        System.out.println(j1.getNom()+" remporte la bataille");
      }
      else if (c1.compareA(c2) < 0) {
        j2.ajouterPlusieursCartesEnMain(tas);
        System.out.println(j2.getNom()+" remporte la bataille");
      }
    } while(c1.compareA(c2) == 0);
  }

  public boolean joueurAGagnerLaPartie(Joueur j) {
    return j.getScore() >= this.scoreLimite;
  }

  public void affichageDuScore() {
    System.out.println("++++++++++++++++++++++++++");
    System.out.println("Score de "+j1.getNom()+" : "+j1.getScore());
    System.out.println("Score de "+j2.getNom()+" : "+j2.getScore());
    System.out.println("++++++++++++++++++++++++++\n");
  }

  public void affichageVainqueurDeLaPartie() {
    System.out.println("-------------");
    if(this.joueurAGagnerLaPartie(j1)) System.out.println(this.j1.getNom()+" a gagné la partie !");
    else System.out.println(this.j2.getNom()+" a gagné la partie !");
    System.out.println("-------------");
  }
}
