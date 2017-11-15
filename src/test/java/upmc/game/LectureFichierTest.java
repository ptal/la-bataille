package upmc.game;

import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author OmarAbdalla
 */
public class LectureFichierTest extends TestCase {
    
    public LectureFichierTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LectureFichierTest.class);
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
     * Test of lirePseudo method, of class LectureFichier.
     */
    public void testLirePseudo() {
        System.out.println("lirePseudo");
        LectureFichier instance = new LectureFichier();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.lirePseudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
