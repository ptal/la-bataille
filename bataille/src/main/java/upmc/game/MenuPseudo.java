package upmc.game;

import java.util.Scanner;

/**
 * Created by Adrien on 11/10/2017.
 */
public class MenuPseudo {

    public ReadPseudo readPseudoMode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("De quelle manière voulez-vous lire les pseudos ? Fichier (1) ou Console(2)");
        int choixMenu = sc.nextInt();
        if (choixMenu == 1) return new ReadFile();
        return new ReadConsole();
    }
}
