package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Adrien on 18/11/2017.
 */
public class ReadConsoleTest extends TestCase {

    @Test
    public void testChoixAdversaire() throws Exception {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new ReadConsole().choiceOpponent(), "IA");
    }

    @Test
    public void testSaisiePseudo() throws Exception {
        String input = "Adrien";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new ReadConsole().inputPseudo(), input);
    }

}