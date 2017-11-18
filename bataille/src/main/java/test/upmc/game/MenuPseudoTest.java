package test.upmc.game;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import upmc.game.MenuPseudo;

import java.util.Scanner;

/**
 * MenuPseudo Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>nov. 15, 2017</pre>
 */
public class MenuPseudoTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: modeLecturePseudo(Scanner keyboardChoice)
     */
    @Test
    public void testModeLecturePseudo() throws Exception {
        MenuPseudo menuPseudo = new MenuPseudo();
        assert (menuPseudo.modeLecturePseudo(new Scanner("2")) != null);




    }


}
