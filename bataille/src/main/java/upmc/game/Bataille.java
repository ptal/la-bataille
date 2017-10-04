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

    //Initialisation des deux joueurs
    InitPlayers players = new InitPlayers();
    players.addNamePlayers();

    String player1 = InitPlayers.player1;
    String player2 = InitPlayers.player2;

    // INITIALISATION DU PAQUET DE CARTES
    ArrayList<Carte> deckPack = new ArrayList<Carte>();
    ArrayList<Carte> mixDeckPack = new ArrayList<Carte>();
    ArrayList<Carte> deck1 = new ArrayList<Carte>();
    ArrayList<Carte> deck2 = new ArrayList<Carte>();

    for(int i = 0 ; i < Carte.cardsColor.length ; i++) {
      for(int j = 0 ; j < Carte.cardsValues.length; j++) {
        Carte carte = new Carte(Carte.cardsColor[i], Carte.cardsValues[j]);
        deckPack.add(carte);
      }
    }

    // Mélange du pacquet de carte et distribution des cartes
    for(int k=0; k<52; k++){
      int random = (int)(Math.random() * (51-k));
      mixDeckPack.add(deckPack.get(random));
      deckPack.remove(deckPack.get(random));
      if(k%2 == 0){
        deck1.add(mixDeckPack.get(k));
      }
      else {
        deck2.add(mixDeckPack.get(k));
      }
    }

    System.out.print(player1 + ", que voulez vous faire ? \n (1) tirer une carte \n (2) Quitter le jeu \n décision : ");
    System.out.flush();
    int decision = Integer.parseInt(console.nextLine());

    System.out.print(player2 + ", que voulez vous faire ? \n (1) tirer une carte \n (2) Quitter le jeu \n décision : ");
    System.out.flush();
    int decision1 = Integer.parseInt(console.nextLine());

    if (decision == 1 && decision1 == 1){
      System.out.println(player1 + " tire une carte : " + deck1.get(0));

      System.out.println(player2 + " tire une carte : " + deck2.get(0));

    }

  }
}
