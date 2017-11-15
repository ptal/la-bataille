/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author licence
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
     * Test of tireCarte method, of class Joueur.
     */
    public void testTireCarte() {
        System.out.println("tireCarte");
        Joueur instance = null;
        Carte expResult = null;
        Carte result = instance.tireCarte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterCarte method, of class Joueur.
     */
    public void testAjouterCarte() {
        System.out.println("ajouterCarte");
        Carte c = null;
        Joueur instance = null;
        instance.ajouterCarte(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compteur method, of class Joueur.
     */
    public void testCompteur() {
        System.out.println("compteur");
        Joueur instance = null;
        int expResult = 0;
        int result = instance.compteur();
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
     * Test of toString method, of class Joueur.
     */
    public void testToString() {
        System.out.println("toString");
        Carte c = null;
        Joueur instance = null;
        String expResult = "";
        String result = instance.toString(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
