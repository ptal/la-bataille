package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adrien on 11/10/2017.
 */
public class LectureConsole implements LecturePseudo {
    public ArrayList<String> lirePseudo() {
        ArrayList<String> listePseudo = new ArrayList<String>();
        listePseudo.add(this.saisiePseudo());
        listePseudo.add(this.choixAdversaire());
        return listePseudo;
    }

    public String choixAdversaire() {
        Scanner sc = new Scanner(System.in);
        int choix;
        String pseudo = null;
        do {
            System.out.println("Voulez vous jouer contre un autre joueur (1) ou l'IA (2) ?");
            choix = sc.nextInt();
            if (choix == 1) pseudo = saisiePseudo();
            else if (choix == 2) pseudo = "IA";
            else System.out.print("Erreur, ");
        } while (choix != 1 && choix != 2);
        return pseudo;
    }

    public String saisiePseudo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez votre pseudo : ");
        String pseudo = sc.nextLine();
        return pseudo;
    }
}
