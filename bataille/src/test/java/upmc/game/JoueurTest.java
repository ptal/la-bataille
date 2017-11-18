package upmc.game;

import java.util.Optional;
import static org.junit.Assert.*;

import org.junit.*;

public class JoueurTest {
    private Joueur joueur;
  
    @Before
    public void CreationJeu() {
      joueur = new Joueur("Joueur test");
    }
  
    @Test
    public void testDeckVideDebut() { 
        boolean result = joueur.deckVide();
        
        assertTrue(result);
    }
    
    @Test
    public void testAbandon() { 
        joueur.abandonne();
        boolean result = joueur.boolAbandon();
        
        assertTrue(result);
    }
    
    @Test
    public void testAjoutCarte() {
        joueur.ajouterCarte(new Carte(2, Carte.COULEURS[3]));
        
        boolean result = joueur.deckVide();
        
        assertFalse(result);
    }
    
    @Test
    public void testSupprCarteDeckVide() {
        joueur.tireCarte(); //Tire une carte sur deck vide
        
        boolean result = joueur.deckVide();
        
        assertTrue(result);
    }
    
    @Test
    public void testSupprCarte() {
        joueur.ajouterCarte(new Carte(2, Carte.COULEURS[3])); //ajout d'une carte pour la supprimer
        joueur.tireCarte(); //Tire une carte
        
        boolean result = joueur.deckVide();
        
        assertTrue(result);
    }
}
