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
     * Test of setCouleur method, of class Carte.
     */
    public void testSetCouleur() {
        System.out.println("setCouleur");
        String couleur = "";
        Carte instance = null;
        instance.setCouleur(couleur);
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
     * Test of setValeur method, of class Carte.
     */
    public void testSetValeur() {
        System.out.println("setValeur");
        int valeur = 0;
        Carte instance = null;
        instance.setValeur(valeur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comparateur method, of class Carte.
     */
    public void testComparateur() {
        System.out.println("comparateur");
        Carte carte = null;
        Carte instance = null;
        int expResult = 0;
        int result = instance.comparateur(carte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
