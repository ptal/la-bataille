package upmc.game;

import java.util.Scanner;

/**
 * This class enables you to get extra methods and mainly the checkWinner method (in order to be re-used)
 * It will compare which player is the winner and will do all the step in case of equality even if one of the player has
 * - no more cards
 * - only 1 cards
 * - at least 2 cards in his hand
 *
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
    public static void showContinueMenu()
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
                Thread.sleep(10000);//Sleep for 10 seconds, wait a bit...
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.exit(0); //Quit
        }

    }

    /**
     * Check if it's really a number (between 1 and 2)
     * @param choice the user's input
     * @return if it's a number or not.
     */
    protected static boolean isNumber(String choice)
    {
        return choice.matches("[1-2]");
    }
}
