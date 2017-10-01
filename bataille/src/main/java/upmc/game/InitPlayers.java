package upmc.game;

import java.util.Scanner;

//Classe pour initialiser les joueurs
public class InitPlayers {
    public static String player1 = "Joueur 1"; //Valeur par défaut pour le premier joueur
    public static String player2 = "Joueur 2"; //Valeur par défaut pour le deuxième joueur

    //Ajouter le nom des joueurs
    public void addNamePlayers(){
        Scanner console = new Scanner(System.in);

        System.out.print("Entrez le nom du premier joueur : ");
        System.out.flush();

        player1 = console.nextLine();

        System.out.print("Entrez le nom du deuxième joueur : ");
        System.out.flush();
        player2 = console.nextLine();
    }


    public String toString() {
        return "Nom du joueur 1 : "+ player1 + "\nNom du joueur 2 : " + player2;
    }

}
