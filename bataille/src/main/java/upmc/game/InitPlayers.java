package upmc.game;

import java.util.Scanner;

//Classe pour initialiser les joueurs
public class InitPlayers {
    public static String player1 = "Joueur 1"; //Valeur par défaut pour le premier joueur
    public static String player2 = "Joueur 2"; //Valeur par défaut pour le deuxième joueur


    //Choisir si on joue contre un adversaire ou un ordinateur
    public int choose_type_player(){
        Scanner console = new Scanner(System.in);
        System.out.flush();
        System.out.print("Choisissez votre mode de jeu : \n (1) Jouer avec l'ordinateur - appuer sur 1 \n (2) Jouer avec un ami - appuyer sur 2 \n");
        System.out.flush();
        String choice = console.nextLine();

        if (!choice.equals("1") && !choice.equals("2")){
            System.out.println("Le résultat saisie n'est pas correct !");
            return 0;
        }
        else if(choice.equals("1")){
            return 1;
        }
        else {
            return 2;
        }

    }

    //Ajouter le nom des joueurs
    public void add_name_players(int nblayers){
        Scanner console = new Scanner(System.in);

        System.out.print("Entrez le nom du premier joueur : ");
        System.out.flush();
        player1 = console.nextLine();

        if (nblayers == 2){
            System.out.print("Entrez le nom du deuxième joueur : ");
            System.out.flush();
            player2 = console.nextLine();
        }
        else{
            player2 = "Ordinateur";
        }

    }


    public String toString() {
        return "Nom du joueur 1 : "+ player1 + "\nNom du joueur 2 : " + player2;
    }

}
