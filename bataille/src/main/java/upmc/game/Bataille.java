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

public class Bataille {
    private Joueur player1;
    private Joueur player2;
    private int nbCards = 52;
    private int nbPlayer;

    public Bataille() {
        nbPlayer = askNbJoueurs();
        this.player1 = new Joueur();
        this.player2 = new Joueur();
        generateTwoPacks();
        if (nbPlayer == 1) {
            onePlayerGame(this);
        } else {
            twoPlayerGame(this);
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

    public Joueur getPlayer1() {
        return player1;
    }

    public Joueur getPlayer2() {
        return player2;
    }

    // TODO: Vérification Cartes déja tirées
    private void generateTwoPacks() {
        for (int i = 0; i < nbCards / 2; i++) {
            getPlayer1().getCards().add(new Carte());
            getPlayer2().getCards().add(new Carte());
        }
    }

    public int getNbCards() {
        return nbCards;
    }

    public void getWinnerRound(Carte carteJoueur, Carte carteBot) {

        if (carteJoueur.getValue() > carteBot.getValue()) {
            System.out.println("Joueur 1 gagne avec: " + carteJoueur.toString() + " contre " + carteBot.toString());
            player1.addPoint();
        } else if (carteJoueur.getValue() < carteBot.getValue()) {
            System.out.println("Joueur 1 perd avec: " + carteJoueur.toString() + " contre " + carteBot.toString());
            player2.addPoint();
        } else {
            System.out.println("Égalité: " + carteJoueur.toString() + " contre " + carteBot.toString());
        }
        System.out.print("\n");
        this.nbCards -= 2;
    }

    public void getWinner() {
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println("Fin ! Joueur 1 gagne avec " + player1.getPoints() + " points contre " + player2.getPoints());
        } else if (player2.getPoints() > player1.getPoints()) {
            System.out.println("Fin ! Joueur 1 perd avec " + player1.getPoints() + " points contre " + player2.getPoints());
        } else {
            System.out.println("Fin ! Égalité.");
        }
    }

    public void onePlayerGame(Bataille bataille) {
        Joueur j1 = bataille.getPlayer1();
        Joueur j2 = bataille.getPlayer2();

        while (bataille.getNbCards() - 2 != 0) {
            System.out.println("Choisissez une de vos cartes à piocher: ");
            j1.showCards();

            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            while (choice > j1.getCards().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }

            Carte carteJoueur1 = j1.pick(choice);

            int randomCarte = (int) Math.random() * 27;
            Carte carteBot = j2.pick(randomCarte);

            bataille.getWinnerRound(carteJoueur1, carteBot);
        }
        bataille.getWinner();
    }

    public void twoPlayerGame(Bataille bataille) {
        Joueur j1 = bataille.getPlayer1();
        Joueur j2 = bataille.getPlayer2();

        while (bataille.getNbCards() - 2 != 0) {
            System.out.println("Joueur 1, choisissez une de vos cartes à piocher: ");
            j1.showCards();

            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            while (choice > j1.getCards().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }

            Carte carteJoueur1 = j1.pick(choice);

            System.out.println("Joueur 2, choisissez une de vos cartes à piocher: ");
            j2.showCards();

            console = new Scanner(System.in);
            choice = console.nextInt();
            while (choice > j1.getCards().size() - 1) {
                System.out.println("Veuillez choisir une valeur possible.");
                console = new Scanner(System.in);
                choice = console.nextInt();
            }
            Carte carteJoueur2 = j2.pick(choice);

            bataille.getWinnerRound(carteJoueur1, carteJoueur2);
        }
        bataille.getWinner();
    }

    public static void main(String[] args) {
        Bataille bataille = new Bataille();
    }
}
