package test;

import org.junit.Before;
import org.junit.Test;
import upmc.game.Carte;

import javax.smartcardio.Card;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 18/11/2017.
 */
public class CarteTest {

    @Test
    public void getValue() {
        Carte card = new Carte();

        assertNotNull(card.getValue());
    }

}