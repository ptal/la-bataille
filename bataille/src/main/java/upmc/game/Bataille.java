package upmc.game;

/**
 * Bataille est la classe qui contient la fonction principale du jeu de bataille
 *
 * @author Nicolas BOULLET
 */
public class Bataille {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        
        jeu.initialisation();
        jeu.jouer();
    }   
}


