package test.upmc.game; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import upmc.game.Deck;
import upmc.game.Player;

import static org.junit.Assert.assertTrue;

/** 
* Deck Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 14, 2017</pre> 
* @version 1.0 
*/ 
public class DeckTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: splitDeck(Deck deck, Player j1, Player j2) 
* 
*/ 
@Test
public void testSplitDeck() throws Exception { 
    Player j1 = new Player();
    Player j2 = new Player();
    Deck deck = new Deck();

    deck.splitDeck(deck,j1,j2);

    assertTrue (j1.getAlPlayerDeck().size() == deck.getAlCards().size()/2);
    assertTrue (j2.getAlPlayerDeck().size() == deck.getAlCards().size()/2);

}


} 
