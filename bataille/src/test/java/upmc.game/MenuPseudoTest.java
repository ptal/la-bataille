package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 18/11/2017.
 */
public class MenuPseudoTest extends TestCase {

    private LecturePseudo lp1 = new LectureConsole();
    private LecturePseudo lp2 = new LectureFichier();

    public MenuPseudoTest() {

    }

    @Test
    public void testModeLecturePseudo() throws Exception {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new MenuPseudo().modeLecturePseudo().getClass(), lp2.getClass());

        input = "2";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new MenuPseudo().modeLecturePseudo().getClass(), lp1.getClass());
    }

}