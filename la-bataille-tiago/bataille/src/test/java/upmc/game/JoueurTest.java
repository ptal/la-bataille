/**
 *
 * @author Tiago
 */

package upmc.game;

import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class JoueurTest {
    
    @Test
    public void testGetPoint() {
        int x=1;
        Carte c = new Carte(1,x); //Creation d'une carte
        c.getValeur();
        assertTrue(c.getValeur()== x);
    }

    @Test
    public void testToString()
    {
        String nom = "Joueur";
        Joueur j = new Joueur(nom); 
        Assert.assertEquals(nom, j.toString());
    }
}
