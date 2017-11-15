package upmc.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author OmarAbdalla
 */
public class CarteTest extends TestCase {
    
    public CarteTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CarteTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getCouleur method, of class Carte.
     */
    public void testGetCouleur() {
        System.out.println("getCouleur");
        Carte instance = null;
        String expResult = "";
        String result = instance.getCouleur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValeur method, of class Carte.
     */
    public void testGetValeur() {
        System.out.println("getValeur");
        Carte instance = null;
        int expResult = 0;
        int result = instance.getValeur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comparateur method, of class Carte.
     */
    public void testComparateur() {
        System.out.println("comparateur");
        Carte carte2 = null;
        Carte instance = null;
        int expResult = 0;
        int result = instance.comparateur(carte2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Carte.
     */
    public void testToString() {
        System.out.println("toString");
        Carte instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
