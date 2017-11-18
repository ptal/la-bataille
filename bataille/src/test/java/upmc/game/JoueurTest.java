package upmc.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author jerom
 */
public class JoueurTest extends TestCase {
    
    public JoueurTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    @Test
    public void testScore(){
        Joueur j1 = new Joueur("test");
        int result = j1.Score();
        assertTrue(result==0);
    }
  
  
    @Test
    public void testVoirCarteValeur(){
       Joueur j1 = new Joueur("test"); 
       Carte carte = new Carte("t", "01");
       String carte_string = carte.toString();
       j1.AjoutCarte(carte_string);
       int num = 0;

       int result = j1.VoirCarteValeur(num);
       assertTrue(result==01);
    }
    
    @Test
    public void testVoirCarteCouleur(){
       Joueur j1 = new Joueur("test"); 
       Carte carte = new Carte("t", "01");
       String carte_string = carte.toString();
       j1.AjoutCarte(carte_string);
       int num = 0;

       String result = j1.VoirCarteColor(num);
       assertTrue(result.equals("t"));
    }
    
    @Test
    public void testVoirCarte(){
       Joueur j1 = new Joueur("test"); 
       Carte carte = new Carte("t", "01");
       String carte_string = carte.toString();
       j1.AjoutCarte(carte_string);
       int num = 0;

        assertTrue((j1.VoirCarte(num)).equals("01 t"));
    }
    
}
