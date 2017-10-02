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

public class Bataille
{
    private Joueur joueur1;
    private Joueur joueur2;
    private int nbCartes = 52;
    private ArrayList<Carte> carteJouees = new ArrayList<Carte>();
    private int pointsJoueur = 0;
    private int pointsBot = 0;

    public Bataille() {
        this.joueur1 = new Joueur();
        this.joueur2 = new Joueur();
        generate2PACks();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    private void generate2PACks() {
        for (int i = 0; i < nbCartes/2; i++) {
            getJoueur1().getCartes().add(new Carte());
            getJoueur2().getCartes().add(new Carte());
        }
    }

    public int getNbCartes() {
        return nbCartes;
    }

    public void getWinnerRound(Carte carteJoueur, Carte carteBot) {

        if (carteJoueur.getValeur() > carteBot.getValeur()) {
            System.out.println("Vous avez gagné: " + carteJoueur.toString() + " contre " + carteBot.toString());
            pointsJoueur++;
        }
        else if(carteJoueur.getValeur() < carteBot.getValeur()) {
            System.out.println("Vous avez perdu: "  + carteJoueur.toString() + " contre " + carteBot.toString());
            pointsBot++;
        }
        else {
            System.out.println("Égalité: " + carteJoueur.toString() + " contre " + carteBot.toString());
        }
        System.out.print("\n");
        this.nbCartes -= 2;
    }

    public void getGagnant() {
        if (pointsJoueur > pointsBot) {
            System.out.println("Fin ! Vous avez gagné avec " + pointsJoueur + " points contre " + pointsBot);
        }
        else if(pointsBot > pointsJoueur) {
            System.out.println("Fin ! Vous avez perdu avec " + pointsJoueur + " points contre " + pointsBot);
        }
        else {
            System.out.println("Fin ! Égalité.");
        }
    }

    public static void main(String[] args)
    {
        Bataille bataille = new Bataille();
        Joueur j1 = bataille.getJoueur1();
        Joueur j2 = bataille.getJoueur2();

        while (bataille.getNbCartes() -2 != 0) {
            System.out.println("Choisissez une de vos cartes à piocher: ");
            j1.affCartes();

            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            while (choice > j1.getCartes().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }

            Carte carteJoueur1 = j1.pioche(choice);

            int randomCarte = (int) Math.random() * 27;
            Carte carteBot = j2.pioche(randomCarte);

            bataille.getWinnerRound(carteJoueur1, carteBot);
        }
        bataille.getGagnant();
          /*
        System.out.println("C'est le jeu de la bataille!\n");
        System.out.print("Veuillez entrer un choix : ");
        System.out.flush();
        Scanner console = new Scanner(System.in);
        String choice = console.nextLine();
        System.out.println("\nL'utilisateur a choisi : \"" + choice + "\"");
        System.out.println("C'est terminé :-(\n\nIl n'y a pas beaucoup de fonctionnalités...");
        */


    }
}
