package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Adrien on 18/11/2017.
 */
public class PlayerTest extends TestCase {

    private Player j1 = new Player("Adrien", true);
    private Player j2 = new Player("Toto", false);
    private Card c1 = new Card("trefle", 12);
    private Card c2 = new Card("coeur", 1);
    private Card c3 = new Card("pique", 4);

    public PlayerTest() {
        this.j1.addMulitpleCardsInTheHand(new ArrayList() {{
            add(c1);
            add(c2);
            add(c3);
        }});
        this.j2.addMulitpleCardsInTheHand(new ArrayList() {{
            add(c3);
            add(c1);
            add(c2);
        }});
    }

    @Test
    public void testJouerCarte() throws Exception {
        assertEquals(this.j1.playACard(), c1);
        assertEquals(this.j2.playACard(), c3);
    }

    @Test
    public void testGetNom() throws Exception {
        assertEquals(this.j1.getName(), "Adrien");
    }

    @Test
    public void getScore() throws Exception {
        assertEquals(this.j2.getScore(), 0);
        this.j2.winAPoint();
        this.j2.winAPoint();
        assertEquals(this.j2.getScore(), 2);
    }

    @Test
    public void testEstHumain() throws Exception {
        assertTrue(this.j1.isHuman());
        assertFalse(this.j2.isHuman());
    }

}