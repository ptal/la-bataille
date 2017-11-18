/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Tiago
 */
public class CarteTest {
    
    @Test
    public void testGetValeur() {
        int x=1;
        Carte c = new Carte(1,x); //Creation d'une carte
        c.getValeur();
        assertTrue(c.getValeur()== x);
    }

    @Test
    public void testComparateurValeur() {
        Carte c1 = new Carte(2,2); 
        Carte c2 = new Carte(1,1); 
        assertTrue(c1.comparateurValeur(c2));
    } 

    @Test
    public void testComparateurBataille() {
        Carte c1 = new Carte(1,1); 
        Carte c2 = new Carte(1,1); 
        assertTrue(c1.comparateurBataille(c2) == 1);
    } 
  
}
