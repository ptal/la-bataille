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
public class JeuTest extends TestCase {
    
    public JeuTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(JeuTest.class);
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
     * Test of getJoueur1 method, of class Jeu.
     */
    public void testGetJoueur1() {
        System.out.println("getJoueur1");
        Jeu instance = null;
        Joueur expResult = null;
        Joueur result = instance.getJoueur1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJoueur1 method, of class Jeu.
     */
    public void testSetJoueur1() {
        System.out.println("setJoueur1");
        Joueur joueur1 = null;
        Jeu instance = null;
        instance.setJoueur1(joueur1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJoueur2 method, of class Jeu.
     */
    public void testGetJoueur2() {
        System.out.println("getJoueur2");
        Jeu instance = null;
        Joueur expResult = null;
        Joueur result = instance.getJoueur2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJoueur2 method, of class Jeu.
     */
    public void testSetJoueur2() {
        System.out.println("setJoueur2");
        Joueur joueur2 = null;
        Jeu instance = null;
        instance.setJoueur2(joueur2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaquet method, of class Jeu.
     */
    public void testGetPaquet() {
        System.out.println("getPaquet");
        Jeu instance = null;
        Carte[] expResult = null;
        Carte[] result = instance.getPaquet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialiserPaquet method, of class Jeu.
     */
    public void testInitialiserPaquet() {
        System.out.println("initialiserPaquet");
        Jeu instance = null;
        instance.initialiserPaquet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of melangerCartes method, of class Jeu.
     */
    public void testMelangerCartes() {
        System.out.println("melangerCartes");
        Jeu instance = null;
        instance.melangerCartes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of donnerCartes method, of class Jeu.
     */
    public void testDonnerCartes() {
        System.out.println("donnerCartes");
        Jeu instance = null;
        instance.donnerCartes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lancerJeu method, of class Jeu.
     */
    public void testLancerJeu() {
        System.out.println("lancerJeu");
        Jeu instance = null;
        instance.lancerJeu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficheGagnant method, of class Jeu.
     */
    public void testAfficheGagnant() {
        System.out.println("afficheGagnant");
        Jeu instance = null;
        instance.afficheGagnant();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficheGagnantManche method, of class Jeu.
     */
    public void testAfficheGagnantManche() {
        System.out.println("afficheGagnantManche");
        Jeu instance = null;
        instance.afficheGagnantManche();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
