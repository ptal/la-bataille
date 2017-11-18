package upmc.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerom
 */
public class DeckTest {
    
    @Test
    public void testDistribution(){
        Deck deck = new Deck();
        Joueur j1 = new Joueur("test");
        Joueur j2 = new Joueur("test");
        deck.Distribution(j1, j2);
        j1.VoirCarte(0);
    }
}
