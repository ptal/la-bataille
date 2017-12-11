package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Adrien on 18/11/2017.
 */
public class CardTest extends TestCase {

    private Card c1;
    private Card c2;
    private Card c3;

    public CardTest() {
        this.c1 = new Card("pique", 5);
        this.c2 = new Card("coeur", 12);
        this.c3 = new Card("trefle", 12);
    }

    @Test
    public void testCompareA() throws Exception {
        if (c1.compareA(c2) >= 0 || c2.compareA(c3) != 0 || c3.compareA(c1) <= 0) {
            fail();
        }
    }

    @Test
    public void testnomValeur() throws Exception {
        assertEquals(c1.nameValue(), "5");
        assertEquals(c2.nameValue(), "reine");
        assertEquals(c2.nameValue(), c3.nameValue());
    }

}
