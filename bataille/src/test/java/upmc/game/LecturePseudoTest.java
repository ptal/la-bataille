/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author licence
 */
public class LecturePseudoTest extends TestCase {
    
    public LecturePseudoTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LecturePseudoTest.class);
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
     * Test of lirePseudo method, of class LecturePseudo.
     */
    public void testLirePseudo() {
        System.out.println("lirePseudo");
        LecturePseudo instance = new LecturePseudoImpl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.lirePseudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LecturePseudoImpl implements LecturePseudo {

        public ArrayList<String> lirePseudo() {
            return null;
        }
    }
    
}
