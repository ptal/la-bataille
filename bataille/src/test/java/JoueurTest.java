/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import junit.framework.TestCase;
import upmc.game.Carte;
import upmc.game.Joueur;

/**
 *
 * @author Laura
 */
public class JoueurTest extends TestCase {
    private Joueur j;
    private Carte c;
    private ArrayList paquet=new ArrayList();
    
    public JoueurTest(String testName) {
        super(testName);
        this.c=new Carte(8, "coeur");
        this.paquet.add(this.c);
        this.paquet.add(new Carte(9, "coeur"));
        this.j=new Joueur(0, paquet , "test");
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
    
    public void test_joue(){
       Carte result=j.joue();
       assertTrue(result.equals(this.c));
       assertTrue(this.j.affiche_nombre_cartes_restantes()==0);
    }
    public void test_gagne_cartes(){
        ArrayList cartes_a_gagner=new ArrayList();
        cartes_a_gagner.add(this.c);
        int[] conditions_victoire={1,2};
        int[] result_attendu={1,2};
        
        this.j.gagne_cartes(cartes_a_gagner, 1);
        assertTrue(this.j.affiche_nombre_cartes_restantes()==1);
    }
    
}
