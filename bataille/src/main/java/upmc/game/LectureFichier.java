package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antoine on 14/10/2017.
 */
public class LectureFichier implements LecturePseudo {

    private String fileName;

    public LectureFichier() {
        askFileName();
    }

    private String askFileName() {
        System.out.println("Entrez un nom de fichier a lire: ");
        // TODO Afficher la liste des fichiers
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    @Override
    public ArrayList<String> lirePseudo() {
        return null;
    }
}
