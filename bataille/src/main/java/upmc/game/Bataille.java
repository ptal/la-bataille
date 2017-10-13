package upmc.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class is the main class (Entry point).
 * It generate and launch the battle after asking the user's choice by different menu
 * It won't stop until the user decided to quit (hit 2 in main menu). So it will ask if the user wants to do another game or quit
 * This class will trigger the creation of player, decks and will play the main game (draw - compare - give cards to the winner)
 *
 * @author Timothé Pardieu
 */
public class Bataille
{
    private Player player1 = null ,player2 = null;
    private Scanner keyboardChoice = new Scanner(System.in);


    public static void main(String[] args)
    {
        Bataille war = new Bataille();
        war.start();
    }

    /**
     * The main action, it enables the game to start a battle (choose a mode, draw a card, compare..)
     */
    private void start()
    {
        //Chosing the game mode & creating players (IA vs Player or Player vs Player)
        int gameModeSelected = WarUtility.chooseGame(keyboardChoice);
        //Select the game mode
        createPlayerDependingChoice(gameModeSelected);
        //Creating a new Deck
        instantiateDeckAndSplit(player1, player2);
        //methode
        startBasicGame();
    }

    /**
     * If the user has chosen the game mode 1 or 2 we launch a basic game.
     * > Ask the action (play or quit)
     * > Play the game
     * > Showing the winner
     * > Ask if the user wants one more battle
     */
    private void startBasicGame()
    {
        while (true) //Looping until the user quit
        {
            //Launching game while its end
            while (!player1.isEmpty() && !player2.isEmpty()) // play a round until one of the deck is empty
            {
                //Get the basic menu
                WarUtility.showMenu();
                //Get the choice for the menu and Quit if 2 is chosen
                WarUtility.isQuittingGame(keyboardChoice.nextLine());
                //else we play the game
                playGame(player1, player2);
                //Showing the game info
                System.out.println("> " + player1.gameInfo() + " \n> " + player2.gameInfo());
            }
            doOneMoreBattle();
        }
    }

    /**
     * Ask if the user want to do one more battle
     * If no the program quits,
     * else the hands of cards are reset and a new deck is instantiated and used
     */
    private void doOneMoreBattle()
    {
        //Show the menu if we do one more battle or not
        WarUtility.showContinueMenu();
        WarUtility.isQuittingGame(keyboardChoice.nextLine());

        //Reset the deck to the initial state (empty)
        player1.resetData();
        player2.resetData();

        //Creating a new deck
        instantiateDeckAndSplit(player1, player2);
    }

    /**
     * Instantiate a deck and split it by 2
     *
     * @param player1
     * @param player2
     */
    protected void instantiateDeckAndSplit(Player player1, Player player2)
    {
        Deck deck = new Deck();
        //Split by 2
        deck.splitDeck(deck, player1, player2);
    }

    /**
     * Depending the user's choice we ask for the name(s) and we create the player(s)
     * Or if it's 3 we create an instance of Statistics and run the special game mode associated
     * 1 -> Player vs Player
     * 2 -> Player vs IA
     * 3 -> Stat
     *
     * @param gameModeSelected the user's choice
     */
    private void createPlayerDependingChoice(int gameModeSelected)
    {
        String choice = "";
        MenuPseudo menuPseudo = new MenuPseudo();
        LecturePseudo lecturePseudo;
        ArrayList<String> alPseudos;

        switch (gameModeSelected)
        {
            case 1:  //Player vs Player
                lecturePseudo = menuPseudo.modeLecturePseudo();
                alPseudos = lecturePseudo.lirePseudo();

                player1 = new Player(alPseudos.get(0));
                player2 = new Player(alPseudos.get(1));

                //choice = askName("Joueur1");
                //player1 = new Player(choice);
                //choice = askName("Joueur2");
                //player2 = new Player(choice);
                break;
            case 2: //Player vs Ordi
                lecturePseudo = menuPseudo.modeLecturePseudo();
                alPseudos = lecturePseudo.lirePseudo();
                //choice = askName("Joueur1");
                player1 = new Player(alPseudos.get(0));
                player2 = new Player(); //IA
                break;
            case 3: //Statistique
                player1 = new Player("Ordi1");
                player2 = new Player("Ordi2"); //IA
                System.out.flush();
                System.out.print("ENTRER LE NOMBRE DE PARTIES A SIMULER : ");
                int numberOfGames = keyboardChoice.nextInt();
                Statistics s = new Statistics(player1, player2);
                s.runStat(numberOfGames);
                break;
        }

    }

    /**
     * @param j the Player to define
     * @return the user's choice
     */
    private String askName(String j)
    {
        System.out.print("ENTRER LE NOM DU JOUEUR " + j + " : ");
        return keyboardChoice.nextLine();
    }

    /**
     * "Heart of the program". This part deals with drawing a card or compare cards' value
     *
     * @param j1 the first player
     * @param j2 the second player
     */
    protected void playGame(Player j1, Player j2)
    {
        // Draw a card
        Card j1CardChosen = j1.drawCard();
        Card j2CardChosen = j2.drawCard();

        //Create the temporary deck (cards in game which have been played by the players)
        ArrayList<Card> alCardsInGame = new ArrayList<Card>();
        alCardsInGame.add(j1CardChosen);
        alCardsInGame.add(j2CardChosen);

        //Checking who's the winner
        checkWinner(j1, j2, j1CardChosen, j2CardChosen, alCardsInGame);
        manageScore(j1, j2);

    }


    /**
     * Check which player is the winner
     * Compare the value of j1's card and j2's card
     * In case of equality we reach the manageEquality method
     *
     * @param j1            player 1
     * @param j2            player 2
     * @param j1CardChosen  the j1's card drawn
     * @param j2CardChosen  the j2's card drawn
     * @param alCardsInGame the cards in play
     */
    private void checkWinner(Player j1, Player j2, Card j1CardChosen, Card j2CardChosen, ArrayList<Card> alCardsInGame)
    {
        //If the Player 1 wins
        if (j1CardChosen.getValue() > j2CardChosen.getValue())
        {
            //Push the won cards at the start of the deck (not replayed immediately)
            j1.addWonCards(alCardsInGame);
        } else
        {
            //If the Player 2 wins
            if (j1CardChosen.getValue() < j2CardChosen.getValue())
            {
                j2.addWonCards(alCardsInGame);
            } else
                //méthode Manage equality
                this.manageEquality(j1, j2, alCardsInGame);
        }

        System.out.println("Carte J1 : \n" + j1CardChosen.toString() + " vs \n Carte J2 : \n" + j2CardChosen.toString());
        System.out.println(alCardsInGame.size() + " cartes emportées !");

        //Shuffle the decks
        Collections.shuffle(j1.getAlPlayerDeck());
        Collections.shuffle(j2.getAlPlayerDeck());

    }


    //EQUALITY MANAGING

    /**
     * Managing the equality.
     * - If it's an equality but :
     * > one of the users has no more card in his hand
     * 1) The player with the most cards win
     * <p>
     * > if players has at least 1 card
     * 1) Both player put the equality-card in the pile (2 cards at stake)
     * 2) Each player draw a card and compare it to get the winner (4 cards at stake)
     * <p>
     * > if they have 2 or more cards we apply the rules which are :
     * 1) Both player put the equality-card in the pile (2 cards at stake)
     * 2) Each player draw a card and put it immediately in the same pile (4 cards at stake)
     * 3) Each player draw a new card and check who's the winner (6 cards at stake)
     * 3 bis) if it's an equality again we loop to 1)
     *
     * @param j1            the player 1
     * @param j2            the player 2
     * @param alCardsInGame the cards in play (at stake)
     */
    private void manageEquality(Player j1, Player j2, ArrayList<Card> alCardsInGame)
    {
        System.out.println("----------------BATAILLE !! (Equalité)");
        if (!manageEqualityNoMoreCards(j1, j2, alCardsInGame))
            manageEqualityWithOneCard(j1, j2, alCardsInGame);
    }


    /**
     * If the equality card is the last one of the hand
     *
     * @param j1            player 1
     * @param j2            player 2
     * @param alCardsInGame cards in play
     * @return if the hands are empty or not
     */
    private boolean manageEqualityNoMoreCards(Player j1, Player j2, ArrayList<Card> alCardsInGame)
    {
        //Check if the decks aren't empty
        if (j1.isEmpty() || j2.isEmpty())
        {
            //Checking who have more cards (winner)
            if (j1.getAlPlayerDeck().size() > j2.getAlPlayerDeck().size())
            {
                j1.addWonCards(alCardsInGame);
            } else
            {
                j2.addWonCards(alCardsInGame);
            }
            return true;
        }
        return false;
    }

    /**
     * Use if the player has one or more cards in his hand
     * > if players has at least 1 card
     * 1) Both player put the equality-card in the pile (2 cards at stake)
     * 2) Each player draw a card and compare it to get the winner (4 cards at stake)
     *
     * @param j1            player 1
     * @param j2            player 2
     * @param alCardsInGame the cards in play
     */
    private void manageEqualityWithOneCard(Player j1, Player j2, ArrayList<Card> alCardsInGame)
    {
        //If the player has 1 or more cards..
        if (j1.getAlPlayerDeck().size() >= 1 && j2.getAlPlayerDeck().size() >= 1)
        {
            //Get a card
            Card cardTmp1 = j1.drawCard();
            Card cardTmp2 = j2.drawCard();

            alCardsInGame.add(cardTmp1);
            alCardsInGame.add(cardTmp2);

            //If they haven't 2 cards we compare the card immediately
            if (!manageEqualityWithTwoOrMore(j1, j2, alCardsInGame))
            {
                Collections.shuffle(alCardsInGame);
                this.checkWinner(j1, j2, cardTmp1, cardTmp2, alCardsInGame);
            }

        }
    }

    /**
     * Use if the players has 2 or more cards (do the right rule)
     * > if they have 2 or more cards we apply the rules which are :
     * 1) Both player put the equality-card in the pile (2 cards at stake)
     * 2) Each player draw a card and put it immediately in the same pile (4 cards at stake)
     * 3) Each player draw a new card and check who's the winner (6 cards at stake)
     * 3 bis) if it's an equality again we loop to 1)
     *
     * @param j1            player 1
     * @param j2            player 2
     * @param alCardsInGame cards in play
     * @return if the player can do a true bataille (with at least 2 cards for each player)
     */
    private boolean manageEqualityWithTwoOrMore(Player j1, Player j2, ArrayList<Card> alCardsInGame)
    {
        //test if they have 2 cards and so do the "right" rule of "bataille"
        if (j1.getAlPlayerDeck().size() >= 2 && j2.getAlPlayerDeck().size() >= 2)
        {
            //Get the valuable cards (one's that matters)
            Card j1CardEquality = j1.drawCard();
            Card j2CardEquality = j2.drawCard();

            alCardsInGame.add(j1CardEquality);
            alCardsInGame.add(j2CardEquality);

            Collections.shuffle(alCardsInGame);
            //Recursivity we call the same method
            this.checkWinner(j1, j2, j1CardEquality, j2CardEquality, alCardsInGame);
            return true;
        } else //If he has only one card left, that card become the main card
        {
            return false;
        }
    }


    /**
     * Give to the right player a point
     *
     * @param j1 player 1
     * @param j2 player 2
     */
    private void manageScore(Player j1, Player j2)
    {
        //If one is loosing the round, the other one get a point
        if (j1.getAlPlayerDeck().size() == 0)
            j2.increaseScore();
        if (j2.getAlPlayerDeck().size() == 0)
            j1.increaseScore();
    }


}



