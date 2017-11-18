package upmc.game;

import junit.framework.TestCase;
import upmc.game.Carte;
/**
 *
 * @author OmarAbdalla
 */
public class CarteTest extends TestCase {
    
   private Carte c1;
    private Carte c2;
    private Carte c3;

    public CarteTest() {
        this.c1 = new Carte("coeur",3);
        this.c2 = new Carte("pique",4);
        this.c3 = new Carte("trefle",5);
    }
    
   public void testCarteInferieure() {
        
        
        int comparaison = c1.comparateur(c2);
        boolean result = comparaison==1;

        assertTrue(result);
    }
 public void testCarteSuperieure() {
       
        
        int comparaison = c2.comparateur(c1);
        boolean result = comparaison==-1;

        assertTrue(result);
    }
    
    
    public void testCarteEgale() {
        
        
        int comparaison = c3.comparateur(c3);
        boolean result = comparaison==0;

        assertTrue(result);
    }
    
}
