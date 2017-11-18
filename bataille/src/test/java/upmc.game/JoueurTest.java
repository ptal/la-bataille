package upmc.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 18/11/2017.
 */
public class JoueurTest extends TestCase {

    private Joueur j1 = new Joueur("Adrien",true);
    private Joueur j2 = new Joueur("Toto",false);
    private Carte c1 = new Carte("trefle",12);
    private Carte c2 = new Carte("coeur",1);
    private Carte c3 = new Carte("pique",4);

    public JoueurTest() {
        this.j1.ajouterPlusieursCartesEnMain(new ArrayList() {{
            add(c1);
            add(c2);
            add(c3);
        }});
        this.j2.ajouterPlusieursCartesEnMain(new ArrayList() {{
            add(c3);
            add(c1);
            add(c2);
        }});
    }

    @Test
    public void testJouerCarte() throws Exception {
        assertEquals(this.j1.jouerCarte(),c1);
        assertEquals(this.j2.jouerCarte(),c3);
    }

    @Test
    public void testGetNom() throws Exception {
        assertEquals(this.j1.getNom(),"Adrien");
    }

    @Test
    public void getScore() throws Exception {
        assertEquals(this.j2.getScore(),0);
        this.j2.gagneUnPoint();
        this.j2.gagneUnPoint();
        assertEquals(this.j2.getScore(),2);
    }

    @Test
    public void testEstHumain() throws Exception {
        assertTrue(this.j1.estHumain());
        assertFalse(this.j2.estHumain());
    }

}