/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Tiago
 */
public class BatailleTest {
    private ArrayList<String> pseudo = new ArrayList<String>();

    @Test   
    public void testPseudoJoueur() {
        String nom = "";
        Joueur joueur = new Joueur(nom);
        pseudo.add("test");
        joueur.nom(pseudo.get(0));
        assertTrue((pseudo.get(0)) == "test");
    }   
}
