package upmc.game;

import java.util.Scanner;

public class Bataille{
    public static void main(String[] args){
        System.out.println("C'est le jeu de la bataille!\n");
        Carte c = new Carte(0,0);
        Carte d = new Carte(3,9);
        Carte e = new Carte(1,10);
        Carte f = new Carte(2,12);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
//        System.out.print("Veuillez entrer un choix : ");
//        System.out.flush();
//        Scanner console = new Scanner(System.in);
//        String choice = console.nextLine();
//        System.out.println("\nL'utilisateur a choisi : \"" + choice + "\"");
//        System.out.println("C'est terminé :-(\n\nIl n'y a pas beaucoup de fonctionnalités...");
    }
}
