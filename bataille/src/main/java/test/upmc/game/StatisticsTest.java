package test.upmc.game;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import upmc.game.Deck;
import upmc.game.Player;
import upmc.game.Statistics;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Statistics Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>nov. 14, 2017</pre>
 */
public class StatisticsTest {

    private Player j1 = new Player();
    private Player j2 = new Player();
    private Deck deck = new Deck();


    @Before
    public void before() throws Exception {
        deck.splitDeck(deck, j1, j2);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: runStat(int numberOfIteration)
     */
    @Test
    public void testRunStat() throws Exception {

        int[] number = new int[]{2,12,0};
        for (int numb : number) {

            Statistics statistics = new Statistics(j1, j2);
            statistics.runStat(numb);
            assert (j1.percentageScore(numb) >= 0 && j1.percentageScore(numb) <= 100 );
            j1.setScore(0);
            j2.setScore(0);

        }

    }


} 
