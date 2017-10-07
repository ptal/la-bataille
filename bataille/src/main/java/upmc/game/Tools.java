package upmc.game;

import java.util.Scanner;

//Boite à outils de fonctions : morceau de code utilisé plusieurs fois (éviter les copier collé de code)
public class Tools {

    //Affichage du menu
    public String menu(String player) {
        Scanner console = new Scanner(System.in);

        if (player.equals("Ordinateur")) {
            return "";
        } else {
            System.out.print(player + ", que voulez vous faire ? \n (1) tirer une carte - appuyer sur entrée \n (2) Quitter le jeu - appuyer que q \n ");
            System.out.flush();

            String result = console.nextLine();

            if (!result.equals("q")){
                return "error";
            }

            return result ;
        }
    }
}
