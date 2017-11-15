package upmc.game;

import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author OmarAbdalla
 */
public class JoueurTest extends TestCase {
    
    public JoueurTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(JoueurTest.class);
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
     * Test of getScore method, of class Joueur.
     */
    public void testGetScore() {
        System.out.println("getScore");
        Joueur instance = null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Joueur.
     */
    public void testGetNom() {
        System.out.println("getNom");
        Joueur instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarte method, of class Joueur.
     */
    public void testGetCarte() {
        System.out.println("getCarte");
        Joueur instance = null;
        ArrayList<Carte> expResult = null;
        ArrayList<Carte> result = instance.getCarte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tireUneCarte method, of class Joueur.
     */
    public void testTireUneCarte() {
        System.out.println("tireUneCarte");
        Carte carte = null;
        Joueur instance = null;
        instance.tireUneCarte(carte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouteUneCarte method, of class Joueur.
     */
    public void testAjouteUneCarte() {
        System.out.println("ajouteUneCarte");
        Carte carte = null;
        Joueur instance = null;
        instance.ajouteUneCarte(carte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gagner method, of class Joueur.
     */
    public void testGagner() {
        System.out.println("gagner");
        Joueur instance = null;
        instance.gagner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
