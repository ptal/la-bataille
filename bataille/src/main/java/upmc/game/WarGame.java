package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is the main class (Entry point).
 * It generate and launch the battle after asking the user's choice by different menu
 * It won't stop until the user decided to quit (hit 2 in main menu). So it will ask if the user wants to do another game or quit
 * This class will trigger the creation of player, decks and will play the main game (draw - compare - give cards to the winner)
 * @author Timothé Pardieu
 */
public class WarGame
{
    Player player1, player2;
    Scanner keyboardChoice = new Scanner(System.in);


    public static void main(String[] args)
    {
        WarGame war = new WarGame();
        war.start();
    }

    /**
     * The main action, it enables to start a battle (choose a mode, draw a card, compare..)
     */
    private void start()
    {
        //Chosing the game mode & creating players (IA vs Player or Player vs Player)
        int menu = WarUtility.chooseGame(keyboardChoice);
        String choice = "";
        switch (menu)
        {
            case 1:  //Player vs Player
                System.out.print("ENTRER LE NOM DU JOUEUR1 : ");
                choice = keyboardChoice.nextLine();
                player1 = new Player(choice);

                System.out.print("ENTRER LE NOM DU JOUEUR2 : ");
                choice = keyboardChoice.nextLine();
                player2 = new Player(choice);
                break;
            case 2: //Player vs Ordi
                System.out.print("ENTRER LE NOM DU JOUEUR1 : ");
                choice = keyboardChoice.nextLine();
                player1 = new Player(choice);
                player2 = new Player(); //IA
                break;
            case 3: //Statistique
                player1 = new Player("Ordi1");
                player2 = new Player("Ordi2"); //IA
                System.out.print("ENTRER LE NOMBRE DE PARTIES A SIMULER : ");
                int numberOfGames = keyboardChoice.nextInt();
                Statistics s = new Statistics(player1, player2);
                s.runStat(numberOfGames);
                break;
        }

        //Creating a new Deck
        Deck deck = new Deck();
        //Split by 2
        deck.splitDeck(deck, player1, player2);

        while (true)
        {
            //Launching game while it's end
            while (!player1.isEmpty() && !player2.isEmpty()) // play a round until one of the deck is empty
            {
                //Get the basic menu
                WarUtility.showMenu();
                //Get the choice for the menu
                String menuChoice = keyboardChoice.nextLine();
                //Quit if 2 is chosen
                WarUtility.isQuittingGame(menuChoice);
                //else we play the game
                playGame(player1, player2);
                //Showing the game info
                System.out.println(player1.gameInfo());
                System.out.println(player2.gameInfo());
            }
            //Show the menu if we do one more battle or not
            WarUtility.showMenuPartie();
            String menuChoice = keyboardChoice.nextLine();
            WarUtility.isQuittingGame(menuChoice);
            //Reset the deck to the initial state (empty)
            player1.resetData();
            player2.resetData();
            //Creating a new deck
            deck = new Deck();
            deck.splitDeck(deck, player1, player2);
        }

    }

    /**
     * "Heart of the program". This part deals with drawing a card or compare cards' value
     * @param j1 the first player
     * @param j2 the second player
     */
    protected void playGame(Player j1, Player j2)
    {
        System.out.flush();

        // Draw a card
        Card j1CardChosen = j1.drawCard();
        Card j2CardChosen = j2.drawCard();

        //Create the temporary deck (cards in game which have been played by the players)
        ArrayList<Card> alCardsInGame = new ArrayList<>();
        alCardsInGame.add(j1CardChosen);
        alCardsInGame.add(j2CardChosen);

        //Checking who's the winner
        WarUtility.checkWinner(j1, j2, j1CardChosen, j2CardChosen, alCardsInGame);
    }


}



