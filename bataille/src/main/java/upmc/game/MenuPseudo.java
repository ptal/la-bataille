package upmc.game;

import java.util.Scanner;

/**
 * Created by Antoine on 14/10/2017.
 */
public class MenuPseudo {

    public LecturePseudo modeLecturePseudo() {
        System.out.println("Choisissez le mode de lecture de pseudo:");
        System.out.println("1- Console");
        System.out.println("2- Fichier");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        while (!scanner.hasNextInt() && scanner.nextInt() < 3 && scanner.nextInt() > 0) {
            System.out.print("Entrez une valeur correcte:");
            scanner = new Scanner(System.in);
            choix = scanner.nextInt();
        }

        if (choix == 1) {
            return new LectureConsole();
        }
        else {
            return new LectureFichier();
        }
    }
}
