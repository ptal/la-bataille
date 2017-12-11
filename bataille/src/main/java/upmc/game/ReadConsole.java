package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adrien on 11/10/2017.
 */
public class ReadConsole implements ReadPseudo {
    public ArrayList<String> readPseudo() {
        ArrayList<String> pseudoList = new ArrayList<String>();
        pseudoList.add(this.inputPseudo());
        pseudoList.add(this.choiceOpponent());
        return pseudoList;
    }

    public String choiceOpponent() {
        Scanner sc = new Scanner(System.in);
        int choice;
        String pseudo = null;
        do {
            System.out.println("Voulez vous play contre un autre joueur (1) ou l'IA (2) ?");
            choice = sc.nextInt();
            if (choice == 1) pseudo = inputPseudo();
            else if (choice == 2) pseudo = "IA";
            else System.out.print("Erreur, ");
        } while (choice != 1 && choice != 2);
        return pseudo;
    }

    public String inputPseudo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez votre pseudo : ");
        String pseudo = sc.nextLine();
        return pseudo;
    }
}
