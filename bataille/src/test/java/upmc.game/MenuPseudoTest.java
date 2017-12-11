package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Adrien on 18/11/2017.
 */
public class MenuPseudoTest extends TestCase {

    private ReadPseudo lp1 = new ReadConsole();
    private ReadPseudo lp2 = new ReadFile();

    public MenuPseudoTest() {

    }

    @Test
    public void testModeLecturePseudo() throws Exception {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new MenuPseudo().readPseudoMode().getClass(), lp2.getClass());

        input = "2";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(new MenuPseudo().readPseudoMode().getClass(), lp1.getClass());
    }

}