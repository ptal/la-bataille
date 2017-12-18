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
import java.util.Arrays;
import java.util.Scanner;

public class Bataille {

    private static ArrayList<Card> deck;
    private int limitScore;
    private Scanner playerChoice1;
    private Scanner playerChoice2;
    private Scanner GameChoice;
    private Player p1;
    private Player p2;
    private int nbTurns;
    private Card cardJ1, cardJ2;

    public Bataille(int limitScore) {
        this.limitScore = limitScore;
        this.playerChoice1 = new Scanner(System.in);
        this.playerChoice2 = new Scanner(System.in);
        this.GameChoice = new Scanner(System.in);
        this.p1 = new Player();
        this.p2 = new Player();
        this.nbTurns = 1;
    }

    public static void main(String[] args) {
        Bataille b = new Bataille(10);
        b.play();
    }

    public void play() {
        System.out.println("C'est le jeu de la bataille!\n");
        this.selectPseudo();
        this.createCardGame();
        this.cardDistribution();

        //La Partie
        boolean gameIsOver = false;
        while (!playerWonTheGame(p1) && !playerWonTheGame(p2) && !gameIsOver) {
            gameIsOver = this.OneTurn();
        }
        this.displayWinner();
    }

    public boolean OneTurn() {
        System.out.println("Tour " + this.nbTurns + " ==============");
        //Afficher les cartes de chaque joueurs
        System.out.println("carte de " + p1.getName() + " : " + this.p1.getCardsInTheHand() + " " + this.p1.getCardsInTheHand().size());
        System.out.println("carte de " + p2.getName() + " : " + this.p2.getCardsInTheHand());

        //TOUR JOUEUR 1
        this.cardJ1 = PlayerTurn(this.p1);
        if (this.cardJ1 == null) return true;

        //TOUR JOUEUR 2
        this.cardJ2 = PlayerTurn(this.p2);
        if (this.cardJ2 == null) return true;

        if (this.cardJ1.compareA(this.cardJ2) > 0) { //Si la carte du joueur 1 est meilleur que celle du joueur 2 alors joueur 1 gagne la manche
            this.p1.addCardToTheHand(this.cardJ1);
            this.p1.addCardToTheHand(this.cardJ2);
            System.out.println(p1.getName() + " remporte le tour");
            this.p1.winAPoint();
        } else if (this.cardJ1.compareA(this.cardJ2) < 0) { //Si la carte du joueur 2 est meilleur que celle du joueur 1 alors joueur 2 gagne la manche
            this.p2.addCardToTheHand(this.cardJ1);
            this.p2.addCardToTheHand(this.cardJ2);
            System.out.println(p2.getName() + " remporte le tour");
            this.p2.winAPoint();
        } else {
            this.bigBataille();
        }
        this.displayScore();
        this.nbTurns++;
        return false;
    }

    public Player aTurn() {
        Player winnerOfTheTurn = whoWinTheTurn();
        if(winnerOfTheTurn==this.p1) playerWinsCards(this.p1);
        else if(winnerOfTheTurn==this.p2) playerWinsCards(this.p2);
        else System.out.println("Bataille !");
        this.resetCards();
        return winnerOfTheTurn;
    }

    public void resetCards() {
        this.cardJ1 = null;
        this.cardJ2 = null;
    }

    public void playerWinsCards(Player p) {
        p.winAPoint();
        p.addCardToTheHand(this.cardJ1);
        p.addCardToTheHand(this.cardJ2);
    }

    public Player whoWinTheTurn() {
        Player winnerOfTurn = null;
        if(whichCardIsBetter(this.cardJ1,this.cardJ2)==this.cardJ1) {
            this.p1.addCardToTheHand(cardJ1);
            this.p1.addCardToTheHand(cardJ2);
            winnerOfTurn = this.p1;
        }
        else if(whichCardIsBetter(this.cardJ1,this.cardJ2)==this.cardJ2) {
            this.p2.addCardToTheHand(cardJ1);
            this.p2.addCardToTheHand(cardJ2);
            winnerOfTurn = this.p2;
        }
        return winnerOfTurn;
    }

    public Card whichCardIsBetter(Card c1 , Card c2) {
        Card bestCard = null;
        if(c1.compareA(c2)>0) bestCard = c1;
        else if(c1.compareA(c2)<0) bestCard = c2;
        return bestCard;
    }

    public void selectPseudo() {
        ReadPseudo lp = new MenuPseudo().readPseudoMode();
        ArrayList<String> pseudoList = lp.readPseudo();
        System.out.println(pseudoList);
        this.p1.setName(pseudoList.get(0));
        this.p2.setName(pseudoList.get(1));
    }

    public void setPlayers(String nameP1 , String nameP2) {
        this.p1.setName(nameP1);
        this.p2.setName(nameP2);
        if(nameP2=="IA") this.p2.setHuman(false);
    }

    public Card PlayerTurn(Player p) {
        Card c = null;
        if (p.isHuman()) {
            System.out.println(p.getName() + ", à votre tour : (1 ou autre) pour play , (2) pour quitter.");
            String playerChoice = GameChoice.nextLine();
            if (playerChoice.equals("2")) {
                return c;
            }
        }
        c = p.playACard();
        System.out.println(p.getName() + " joue la carte " + c.toString());
        return c;
    }

    public void cardDistribution() {
        System.out.println("Distribution des cartes...");
        this.p1.addCardToTheHand(new Card("Trefle", 3)); // A ENLEVER
        this.p2.addCardToTheHand(new Card("Trefle", 3)); // A ENLEVER
        while (deck.size() != 0) {
            int pos1 = (int) (Math.random() * (deck.size()));
            this.p1.addCardToTheHand(deck.get(pos1));
            deck.remove(pos1);
            int pos2 = (int) (Math.random() * (deck.size()));
            this.p2.addCardToTheHand(deck.get(pos2));
            this.deck.remove(pos2);
        }
    }

    public void createCardGame() {
        this.deck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) { //Coeur , Carreau , Trefle , Pique : 4
            for (int j = 1; j <= 13; j++) { //1 , 2 , 3 ... Valet , Reine , Roi : 13
                deck.add(new Card(Card.colors[i], j));
            }
        }
    }

    public void bigBataille() {
        ArrayList<Card> stack = new ArrayList<Card>();
        stack.addAll(Arrays.asList(this.cardJ1, this.cardJ2));
        System.out.println("BATAILLE !!!\n");
        do {
            //Player 1
            this.cardJ1 = this.PlayerTurn(p1);
            stack.add(this.cardJ1);
            //Player 2
            this.cardJ2 = this.PlayerTurn(p2);
            stack.add(this.cardJ2);

            if (this.cardJ1.compareA(this.cardJ2) > 0) {
                p1.addMulitpleCardsInTheHand(stack);
                System.out.println(this.p1.getName() + " remporte la bataille");
                p1.winAPoint();
            } else if (this.cardJ1.compareA(this.cardJ2) < 0) {
                this.p2.addMulitpleCardsInTheHand(stack);
                System.out.println(this.p2.getName() + " remporte la bataille");
                p2.winAPoint();
            }
        } while (this.cardJ1.compareA(this.cardJ2) == 0);
    }

    public boolean playerWonTheGame(Player j) {
        return j.getScore() >= this.limitScore;
    }

    public void displayScore() {
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("Score de " + p1.getName() + " : " + p1.getScore());
        System.out.println("Score de " + p2.getName() + " : " + p2.getScore());
        System.out.println("++++++++++++++++++++++++++\n");
    }

    public void displayWinner() {
        System.out.println("-------------");
        if (this.playerWonTheGame(p1)) System.out.println(this.p1.getName() + " a gagné la partie !");
        else System.out.println(this.p2.getName() + " a gagné la partie !");
        System.out.println("-------------");
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Card getCardJ1() {
        return cardJ1;
    }

    public void setCardJ1(Card cardJ1) {
        this.cardJ1 = cardJ1;
    }

    public Card getCardJ2() {
        return cardJ2;
    }

    public void setCardJ2(Card cardJ2) {
        this.cardJ2 = cardJ2;
    }
}
