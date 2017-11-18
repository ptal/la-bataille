package upmc.game;

import java.util.Optional;
import static org.junit.Assert.*;

import org.junit.*;

public class CarteTest {
    private Carte carte;
  
    @Before
    public void CreationJeu() {
      carte = new Carte(5,Carte.COULEURS[2]);
    }
  
    @Test
    public void testCarteInferieure() {
        Carte carteTest = new Carte(1,Carte.COULEURS[1]);
        
        int comparaison = carte.compare(carteTest);
        boolean result = comparaison==1;

        assertTrue(result);
    }
    
    @Test
    public void testCarteSuperieure() {
        Carte carteTest = new Carte(11,Carte.COULEURS[1]);
        
        int comparaison = carte.compare(carteTest);
        boolean result = comparaison==-1;

        assertTrue(result);
    }
    
    @Test
    public void testCarteEgale() {
        Carte carteTest = new Carte(5,Carte.COULEURS[1]);
        
        int comparaison = carte.compare(carteTest);
        boolean result = comparaison==0;

        assertTrue(result);
    }
}
