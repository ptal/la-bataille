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
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 2a0aa9fd2b4ecdb54dbb9ee8ac1e295cb54597e8

public class Bataille
{
  public static void main(String[] args)
  {
    System.out.println("C'est le jeu de la bataille!\n");
<<<<<<< HEAD
    System.out.flush();
    Scanner console = new Scanner(System.in);
    System.out.println("Souhaitez vous lancer le mode interactif ?(1/Oui,2/Non)");
    int choice = console.nextInt();
    if(choice==1){
        System.out.println("l'utilisateur à choisit le mode interactif");
        System.out.println("Veuillez rentrer le nom du joueur 1");
        console.nextLine();
        String nomJoueur1 = console.nextLine();
        System.out.println("Veuillez rentrer le nom du joueur 2");
        String nomJoueur2 = console.nextLine();
        System.out.println("Installation des joueurs à la table");
        Joueur j1 = new Joueur(nomJoueur1);
        Joueur j2 = new Joueur(nomJoueur2);
        System.out.println("Ouverture du paquet de carte");
        ArrayList<Carte> Paquet= new ArrayList();
        String [] tabColor = {"Trefle","Pique","Coeur","Carreau"};
        int [] tabValue = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(String couleur: tabColor){
            for(int valeur: tabValue){
                Paquet.add(new Carte(couleur,valeur));
            }
        }
        System.out.println("Mélange du paquet de carte");
        for(int p=0;p<52;p++){
            int random= (int)(Math.random()*(51-0)+0);
            Paquet.set(random,Paquet.get(p));
        }
        System.out.println("Distribution des cartes");
        for(int k=0;k<52;k++){
            if(k%2 ==0){
                j1.addCarte(Paquet.get(k));
            }
            else{
                j2.addCarte(Paquet.get(k));
            }
        }
        Paquet.clear();
        System.out.println("Début de la phase de jeu");
        while(j1.getSizeMains()!=0 || j2.getSizeMains()!=0){
            System.out.println("C'est au tour de "+j1.getNom());
            System.out.println("Voulez vous tirer une carte ?(1/Oui,2/Quitter)");
            int continueLaPartiej1=console.nextInt();
            if(continueLaPartiej1==2){
                System.out.println("Fin de la partie");
                j1.defineWinner(j2);
                System.exit(0);
            }
            else{
            Carte c1 = j1.pullCarte();
            
            System.out.println("C'est au tour de "+j2.getNom());
            System.out.println("Voulez vous tirer une carte ?(1/Oui,2/Quitter)");
            int continueLaPartiej2=console.nextInt();
            if(continueLaPartiej2==2){
                System.out.println("Fin de la partie");
                j2.defineWinner(j1);
                System.exit(0);
            }
            else{
                Carte c2 = j2.pullCarte();
            if(c1.getValeur()==c2.getValeur()){
                Carte c3 = j1.pullCarte();
                Carte c4 = j2.pullCarte();
                Carte c5 = j1.pullCarte();
                Carte c6 = j2.pullCarte();
                if(c5.Compare(c6)==c5){
                    j1.roundWonBattle(c1,c2,c3,c4,c5,c6);
                    System.out.println("Le joueur "+j1.getNom()+" remporte cette manche avec la carte "+c5.getValeur());
                }
                else{
                    j2.roundWonBattle(c1, c2, c3, c4, c5, c6);
                    System.out.println("Le joueur "+j2.getNom()+" remporte cette manche avec la carte "+c6.getValeur());
                }
            }
            if(c1.Compare(c2)==c1){
                j1.roundWon(c1,c2);
                System.out.println("Le joueur "+j1.getNom()+" remporte cette manche avec la carte "+c1.getValeur());
            }
            else{
                j2.roundWon(c1, c2);
                System.out.println("Le joueur "+j2.getNom()+" remporte cette mancheavec la carte "+c2.getValeur());
            }
            System.out.println("Score de "+j1.getNom()+" est de : "+j1.getCptPoint());
            System.out.println("Score de "+j2.getNom()+" est de : "+j2.getCptPoint());
            }
            
            }
        j1.defineWinner(j2);
        }
            
        
    }
    else{
        System.out.println("Installation des joueurs à la table");
        Joueur j1 = new Joueur("Joueur 1");
        Joueur j2 = new Joueur("Ordinateur");
        System.out.println("Ouverture du paquet de carte");
        ArrayList<Carte> Paquet= new ArrayList();
        String [] tabColor = {"Trefle","Pique","Coeur","Carreau"};
        int [] tabValue = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(String couleur: tabColor){
            for(int valeur: tabValue){
                Paquet.add(new Carte(couleur,valeur));
            }
        }
        System.out.println("Mélange du paquet de carte");
        for(int p=0;p<52;p++){
            int random= (int)(Math.random()*(51-0)+0);
            Paquet.set(random,Paquet.get(p));
        }
        System.out.println("Distribution des cartes");
        for(int k=0;k<52;k++){
            if(k%2 ==0){
                j1.addCarte(Paquet.get(k));
            }
            else{
                j2.addCarte(Paquet.get(k));
            }
        }
        Paquet.clear();
        System.out.println("Début de la phase de jeu");
        while(j1.getSizeMains()!=0 || j2.getSizeMains()!=0){
            Carte c1 = j1.pullCarte();
            Carte c2 = j2.pullCarte();
            if(c1.getValeur()==c2.getValeur()){
                Carte c3 = j1.pullCarte();
                Carte c4 = j2.pullCarte();
                Carte c5 = j1.pullCarte();
                Carte c6 = j2.pullCarte();
                if(c5.Compare(c6)==c5){
                    j1.roundWonBattle(c1,c2,c3,c4,c5,c6);
                    System.out.println("Le joueur "+j1.getNom()+" remporte cette manche avec la carte "+c5.getValeur());
                }
                else{
                    j2.roundWonBattle(c1, c2, c3, c4, c5, c6);
                    System.out.println("Le joueur "+j1.getNom()+" remporte cette manche avec la carte "+c6.getValeur());
                }
            }
            if(c1.Compare(c2)==c1){
                j1.roundWon(c1,c2);
                System.out.println("Le joueur "+j1.getNom()+" remporte cette manche avec la carte "+c1.getValeur());
            }
            else{
                j2.roundWon(c1, c2);
                System.out.println("Le joueur "+j2.getNom()+" remporte cette manche avec la carte "+c2.getValeur());
            }
            System.out.println("Score de "+j1.getNom()+" est de : "+j1.getCptPoint());
            System.out.println("Score de "+j2.getNom()+" est de : "+j2.getCptPoint());
            }
        j1.defineWinner(j2);
      }
  }
    
      
}
  

=======
    System.out.print("Veuillez entrer un choix : ");
    System.out.flush();
    Scanner console = new Scanner(System.in);
    String choice = console.nextLine();
    System.out.println("\nL'utilisateur a choisi : \"" + choice + "\"");
    System.out.println("C'est terminé :-(\n\nIl n'y a pas beaucoup de fonctionnalités...");
  }
}
>>>>>>> 2a0aa9fd2b4ecdb54dbb9ee8ac1e295cb54597e8
