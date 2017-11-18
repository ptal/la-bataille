package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Adrien on 18/11/2017.
 */
public class CarteTest extends TestCase {

    private Carte c1;
    private Carte c2;
    private Carte c3;

    public CarteTest() {
        this.c1 = new Carte("pique",5);
        this.c2 = new Carte("coeur",12);
        this.c3 = new Carte("trefle",12);
    }
    @Test
    public void testCompareA() throws Exception {
        if(c1.compareA(c2)>=0 || c2.compareA(c3)!=0 || c3.compareA(c1)<=0) {
            fail();
        }
    }

    @Test
    public void testnomValeur() throws Exception {
        assertEquals(c1.nomValeur(),"5");
        assertEquals(c2.nomValeur(),"reine");
        assertEquals(c2.nomValeur(),c3.nomValeur());
    }

}
