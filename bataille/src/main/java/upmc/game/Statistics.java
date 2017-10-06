package upmc.game;

/**
 * This class enables you to create a different battle.
 * It's an improvement from the main game.
 * It can be triggered by selecting the 3rd choice in the menu
 * It support the auto-run (IA vs IA) so we can use it to do some statistics
 * The program will invite you to enter how much runs you want and will display all the steps and the final result
 * (usage : test with 3 or 4 battles then with 20 runs to show that the winning rate will go to the 50%, demonstrate the randomness)
 * It extends the main WarGame because it's a "type of WarGame". We can use some inheriting from the WarGame class.
 * It can also be used as a unit-test in a way or to play a very quick game
 * @author Timothé Pardieu
 */
public class Statistics extends WarGame
{

    Player j1 = new Player();
    Player j2 = new Player();

    /**
     * Statistics is a type of WarGame
     *
     * @param j1 the first player
     * @param j2 the second one
     */
    public Statistics(Player j1, Player j2)
    {
        super();
        this.j1 = j1;
        this.j2 = j2;
    }

    /**
     * run the test (based on warGame)
     * @param numberOfIteration number of games we need to achieve
     */
    public void runStat(int numberOfIteration)
    {
        for (int i = 1; i < numberOfIteration + 1; i++)
        {
            //get a new deck
            j1.resetData();
            j2.resetData();
            Deck deck = new Deck();
            deck.splitDeck(deck, j1, j2);
            while (!j1.isEmpty() && !j2.isEmpty())//hands different from empty
            {
                playGame(j1, j2);
            }
        }
        System.out.println("Score final : Ordi2 => " + j1.getScore() + " vs Ordi1 => " + j2.getScore());
        System.out.println(j1.getName() + " a gagné " + String.format("%1$,.2f", j1.percentageScore(numberOfIteration)) + " % des matchs");
        System.out.println(j1.getName() + " a gagné " + String.format("%1$,.2f", j2.percentageScore(numberOfIteration)) + " % des matchs");
        WarUtility.isQuittingGame("2");
    }
}
