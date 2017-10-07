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
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("C'est le jeu de la bataille!\n");

        System.out.println("But du jeu : \n Etre le premier à avoir 100 points. \n Vous marquez 1 point dès que vous avez un nombre supérieur à votre adversaire \n Bonne chance :) \n\n");

        Tools tools = new Tools();

        //Initialisation des deux joueurs
        InitPlayers players = new InitPlayers();

        int nbPlayer = players.choose_type_player();

        while (nbPlayer == 0) {
            nbPlayer = players.choose_type_player();
        }

        players.add_name_players(nbPlayer);

        String player1 = InitPlayers.player1;
        String player2 = InitPlayers.player2;

        // INITIALISATION DU PAQUET DE CARTES
        ArrayList<Carte> deckPack = new ArrayList<Carte>();
        ArrayList<Carte> mixDeckPack = new ArrayList<Carte>();
        ArrayList<Carte> deck1 = new ArrayList<Carte>();
        ArrayList<Carte> deck2 = new ArrayList<Carte>();

        //Création d'un array list en cas de bataille
        ArrayList<Carte> bataille = new ArrayList<Carte>();

        for (int i = 0; i < Carte.cardsColor.length; i++) {
            for (int j = 0; j < Carte.cardsValues.length; j++) {
                Carte carte = new Carte(Carte.cardsColor[i], Carte.cardsValues[j]);
                deckPack.add(carte);
            }
        }


        // Mélange du pacquet de carte et distribution des cartes
        for (int k = 0; k < 52; k++) {
            int random = (int) (Math.random() * (51 - k));
            mixDeckPack.add(deckPack.get(random));
            deckPack.remove(deckPack.get(random));
            if (k % 2 == 0) {
                deck1.add(mixDeckPack.get(k));
            } else {
                deck2.add(mixDeckPack.get(k));
            }
        }

        //Distribution des pacquets de carte aux joueurs
        Joueur game1 = new Joueur(deck1, player1);
        Joueur game2 = new Joueur(deck2, player2);

        String decision = tools.menu(player1);

        String decision1 = tools.menu(player2);

        while (decision.equals("") && decision1.equals("")) {

            Carte carte1 = game1.viewCarte();
            Carte carte2 = game2.viewCarte();

            System.out.println("-------------------------------\n" + player1 + " tire une carte : " + carte1 + "\n-------------------------------");

            System.out.println(player2 + " tire une carte : " + carte2 + "\n-------------------------------\n");

            int result = carte1.compare_cards(carte2);

            if (result == 1) {
                game1.score(1);
                game1.add_card(carte1);
                game1.add_card(carte2);
                game1.suppr_card();
                game2.suppr_card();

                for (int b = 0; b < bataille.size(); b++) {
                    game2.add_card(bataille.get(b));
                }
                bataille.clear();

            } else if (result == 2) {
                game2.score(1);
                game2.add_card(carte1);
                game2.add_card(carte2);
                game1.suppr_card();
                game2.suppr_card();

                for (int b = 0; b < bataille.size(); b++) {
                    game2.add_card(bataille.get(b));
                }
                bataille.clear();
            } else {
                System.out.println("----------------\n" +
                        "|  BATAILLE !  |\n" +
                        "----------------\n");
                bataille.add(carte1);
                bataille.add(carte2);
                game1.suppr_card();
                game2.suppr_card();
            }


            System.out.println("Scores :");
            System.out.println("-------------------------------\n");
            System.out.println(game1.viewScore());
            System.out.println(game2.viewScore());


            if (game1.score() == 100 || game2.score() == 100) {
                System.out.println("La partie est fini ! \n Voici les scores :");
                System.out.println("-------------------------------\n");
                System.out.println(game1.viewScore());
                System.out.println(game2.viewScore());

                break;
            }

            decision = tools.menu(player1);

            decision1 = tools.menu(player2);

            while(decision.equals("error") ||  decision1.equals("error")){
                System.out.println("Erreur lors de la saisie, veuillez recommencez");

                decision = tools.menu(player1);

                decision1 = tools.menu(player2);
            }
        }


        if (game1.score() == 100 || game1.score() > game2.score() || game1.view_nb_card()>game2.view_nb_card()) {
            System.out.println("///////////////////////////////\n" +
                    player1 + " a gagné\n" +
                    "///////////////////////////////\n");
        } else if (game2.score() == 100 || game1.score() < game2.score() || game1.view_nb_card()<game2.view_nb_card()) {
            System.out.println("///////////////////////////////\n" +
                    player2 + " a gagné\n" +
                    "///////////////////////////////\n");
        }

    }
}
