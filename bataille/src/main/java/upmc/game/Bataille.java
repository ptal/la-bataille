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

public class Bataille {
    private Joueur joueur1;
    private Joueur joueur2;
    private int nbCartes = 52;
    private ArrayList<Carte> carteJouees = new ArrayList<Carte>();
    private int pointsJoueur = 0;
    private int pointsBot = 0;
    private int nbJoueurs;

    public Bataille() {
        nbJoueurs = askNbJoueurs();
        this.joueur1 = new Joueur();
        this.joueur2 = new Joueur();
        generate2PACks();
        if (nbJoueurs == 1) {
            gameUnJoueur(this);
        } else {
            gameDeuxJoueurs(this);
        }
    }

    private int askNbJoueurs() {
        System.out.println("Veuillez entrer le nombre de joueurs (1/2):");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice > 2 || choice <= 0) {
            System.out.println("Veuillez entrer une valeur correcte:");
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        }
        return choice;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    // TODO: Vérification Cartes déja tirées
    private void generate2PACks() {
        for (int i = 0; i < nbCartes / 2; i++) {
            getJoueur1().getCartes().add(new Carte());
            getJoueur2().getCartes().add(new Carte());
        }
    }

    public int getNbCartes() {
        return nbCartes;
    }

    public void getWinnerRound(Carte carteJoueur, Carte carteBot) {

        if (carteJoueur.getValeur() > carteBot.getValeur()) {
            System.out.println("Joueur 1 gagne avec: " + carteJoueur.toString() + " contre " + carteBot.toString());
            pointsJoueur++;
        } else if (carteJoueur.getValeur() < carteBot.getValeur()) {
            System.out.println("Joueur 1 perd avec: " + carteJoueur.toString() + " contre " + carteBot.toString());
            pointsBot++;
        } else {
            System.out.println("Égalité: " + carteJoueur.toString() + " contre " + carteBot.toString());
        }
        System.out.print("\n");
        this.nbCartes -= 2;
    }

    public void getGagnant() {
        if (pointsJoueur > pointsBot) {
            System.out.println("Fin ! Joueur 1 gagne avec " + pointsJoueur + " points contre " + pointsBot);
        } else if (pointsBot > pointsJoueur) {
            System.out.println("Fin ! Joueur 1 perd avec " + pointsJoueur + " points contre " + pointsBot);
        } else {
            System.out.println("Fin ! Égalité.");
        }
    }

    public void gameUnJoueur(Bataille bataille) {
        Joueur j1 = bataille.getJoueur1();
        Joueur j2 = bataille.getJoueur2();

        while (bataille.getNbCartes() - 2 != 0) {
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
    }

    public void gameDeuxJoueurs(Bataille bataille) {
        Joueur j1 = bataille.getJoueur1();
        Joueur j2 = bataille.getJoueur2();

        while (bataille.getNbCartes() - 2 != 0) {
            System.out.println("Joueur 1, choisissez une de vos cartes à piocher: ");
            j1.affCartes();

            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            while (choice > j1.getCartes().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }

            Carte carteJoueur1 = j1.pioche(choice);

            System.out.println("Joueur 2, choisissez une de vos cartes à piocher: ");
            j2.affCartes();

            console = new Scanner(System.in);
            choice = console.nextInt();
            while (choice > j1.getCartes().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }
            Carte carteJoueur2 = j2.pioche(choice);

            bataille.getWinnerRound(carteJoueur1, carteJoueur2);
        }
        bataille.getGagnant();
    }

    public static void main(String[] args) {
        Bataille bataille = new Bataille();
    }
}
