package upmc.game;

import jdk.nashorn.internal.codegen.types.Type;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 18/11/2017.
 */
public class LectureConsoleTest extends TestCase {

    @Test
    public void testChoixAdversaire() throws Exception {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new LectureConsole().choixAdversaire(),"IA");
    }

    @Test
    public void testSaisiePseudo() throws Exception {
        String input = "Adrien";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new LectureConsole().saisiePseudo(),input);
    }

}