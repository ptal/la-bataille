package upmc.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class enables you to get extra methods and mainly the checkWinner method (in order to be re-used)
 * It will compare which player is the winner and will do all the step in case of equality even if one of the player has
 * - no more cards
 * - only 1 cards
 * - at least 2 cards in his hand
 * @author Timothé Pardieu
 */
public class WarUtility
{
    //NB : all the arrayList are called alXXXX where al means array list (personnal convention to know when we are dealing with an arraylist)
    /**
     * Checking who is winning and give the cards to the winner
     *
     * @param j1            player 1
     * @param j2            player 2
     * @param j1CardChosen  the card which have been chosen by player 1
     * @param j2CardChosen  the card which have been chosen by player 2
     * @param alCardsInGame the cards in battle
     */
    public static void checkWinner(Player j1, Player j2, Card j1CardChosen, Card j2CardChosen, ArrayList<Card> alCardsInGame)
    {
        //If the Player 1 wins
        if (j1CardChosen.getValue() > j2CardChosen.getValue())
        {
            System.out.println(j1.getName() + " Gagne");
            //Push the winned cards to the start of the deck (not replay immediately)
            j1.getAlPlayerDeck().addAll(0, alCardsInGame);
        }
        //If the Player 2 wins
        if (j1CardChosen.getValue() < j2CardChosen.getValue())
        {
            System.out.println(j2.getName() + "Gagne");
            j2.getAlPlayerDeck().addAll(0, alCardsInGame);
        }
        //Equality / Battle
        if (j1CardChosen.getValue() == j2CardChosen.getValue())
        {
            System.out.println("----------------BATAILLE !! (Equalité)");
            //Check if the decks aren't empty
            if (j1.isEmpty() || j2.isEmpty())
            {
                //Checking who have more cards (winner)
                if (j1.getAlPlayerDeck().size() > j2.getAlPlayerDeck().size())
                {
                    System.out.println(j1.getName() + " Gagne");
                    j1.getAlPlayerDeck().addAll(0, alCardsInGame);
                } else
                {
                    System.out.println(j2.getName() + " Gagne");
                    j2.getAlPlayerDeck().addAll(0, alCardsInGame);
                }
            }

            //If the player has 1 or more cards..
            if (j1.getAlPlayerDeck().size() >= 1 && j2.getAlPlayerDeck().size() >= 1)
            {
                //Get a card
                Card cardTmp1 = j1.drawCard();
                Card cardTmp2 = j2.drawCard();
                alCardsInGame.add(cardTmp1);
                alCardsInGame.add(cardTmp2);
                //If he has more than or 2 cards..
                if (j1.getAlPlayerDeck().size() >= 2 && j2.getAlPlayerDeck().size() >= 2)
                {
                    //Get the valuable cards (one's that matters)
                    Card j1CardEquality = j1.drawCard();
                    Card j2CardEquality = j2.drawCard();
                    alCardsInGame.add(j1CardEquality);
                    alCardsInGame.add(j2CardEquality);
                    Collections.shuffle(alCardsInGame);
                    //Recursivity we call the same method
                    checkWinner(j1, j2, j1CardEquality, j2CardEquality, alCardsInGame);
                } else //If he has only one card left, that card become the main card
                {
                    Collections.shuffle(alCardsInGame);
                    checkWinner(j1, j2, cardTmp1, cardTmp2, alCardsInGame);
                }
            }

        }

        System.out.println("Carte J1 : \n" + j1CardChosen.toString() +
                " vs \n Carte J2 : \n" + j2CardChosen.toString());
        System.out.println(alCardsInGame.size() + " cartes emportées !");

        //Shuffle the decks
        Collections.shuffle(j1.getAlPlayerDeck());
        Collections.shuffle(j2.getAlPlayerDeck());

        //If one is loosing the round, the other one get a point
        if (j1.getAlPlayerDeck().size() == 0)
            j2.increaseScore();
        if (j2.getAlPlayerDeck().size() == 0)
            j1.increaseScore();
    }


    /**
     * Enables the user to choose the game he wants
     *
     * @param keyboardChoice the input
     * @return the value chosen by the user
     */
    public static int chooseGame(Scanner keyboardChoice)
    {
        System.out.println("*** BIENVENUE DANS LA BATAILLE ***");
        System.out.println("CHOISIR : ");
        System.out.println("(1) : JOUEUR VS JOUEUR");
        System.out.println("(2) : JOUEUR VS ORDI");
        System.out.println("(3) : STATS");
        System.out.print("Votre choix : ");
        System.out.flush();
        return Integer.parseInt(keyboardChoice.nextLine());


    }

    /**
     * Show the basic menu between each "player round"
     */
    public static void showMenu()
    {
        System.out.println("--Menu--");
        System.out.println("(1)/(Enter) : Tirer la prochaine carte");
        System.out.println("(2) : Quitter");
    }

    /**
     * Show the main menu, one more battle or quit
     */
    public static void showMenuPartie()
    {
        System.out.println("--Menu--");
        System.out.println("(1)/(Enter) : Continuer");
        System.out.println("(2) : Quitter");
    }

    /**
     * Checking if the user wants to quit the game
     *
     * @param menuChoice the user's choice
     */
    public static void isQuittingGame(String menuChoice)
    {
        if (menuChoice.equals("2"))
        {
            System.out.println("VOUS AVEZ QUITTE.. AU REVOIR");
            try
            {
                Thread.sleep(1000);//Sleep for 3 seconds, wait a bit...
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.exit(0); //Quit
        }

    }
}
