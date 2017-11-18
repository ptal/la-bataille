package upmc.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bataille {

    public static void main(String[] args) {


        System.out.println("Bonjour , bienvenue dans le jeu de la bataille.");

        System.out.println("Tapez sur 1 pour commencer une nouvelle partie .");
        System.out.println("Tapez sur 2 pour quitter");
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        menu = sc.nextInt();
        switch (menu) {
            case 1:
                System.out.println("Que le meilleur gagne ! Mais surtout que la chance soit avec toi ;) ");
                break;
            default:
            case 2:
                System.out.println("En espérant vous revoir bientôt.");
                sc.nextLine();
                int code = 0;
                System.exit(code);
                break;

        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Veuillez saisir votre prénom Joueur 1 :");
        String str = sc2.nextLine();
        System.out.println("Votre nom est  : " + str);
       
        System.out.println("Veuillez saisir votre prénom Joueur 2 :");
        String str1 = sc2.nextLine();
        System.out.println("Votre nom est  : " + str1);
        Joueur joueur1 = new Joueur(str);
        Joueur joueur2 = new Joueur(str1);

        ArrayList<Carte> paquet = new ArrayList<Carte>();

        for (int i = 0; i < Carte.tabCouleur.length; i++) {
            for (int j = 0; j < Carte.tabValeur.length; j++) {
                Carte carte = new Carte(Carte.tabCouleur[i], Carte.tabValeur[j]);
                paquet.add(carte);
            }
        }

        Collections.shuffle(paquet);

        for (int k = 0; k < paquet.size(); k = k + 2) {
            joueur1.ajouteUneCarte(paquet.get(k));
            joueur2.ajouteUneCarte(paquet.get(k + 1));
        }

        boolean joueur1continu = true;
        boolean joueur2continu = true;

        while (joueur1.getCarte().size() != 0 && joueur2.getCarte().size() != 0 && joueur1continu == true && joueur2continu == true) {

            Scanner sc3 = new Scanner(System.in);

            System.out.println("Voulez vous continuez la partie ? :");
            System.out.println("Tapez O pour continuer");
            System.out.println("Tapez N pour interrompre la partie");
            String str3 = sc3.nextLine();
            if (str3.equals("O")) {

                Carte carteJ1 = joueur1.getCarte().get(0);
                joueur1.tireUneCarte(carteJ1);

                Carte carteJ2 = joueur2.getCarte().get(0);
                joueur2.tireUneCarte(carteJ2);

                if (carteJ1.comparateur(carteJ2) == 1) {
                    System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
                    joueur1.ajouteUneCarte(carteJ1);
                    joueur1.ajouteUneCarte(carteJ2);
                    joueur1.gagner();
                    System.out.println(joueur1.getNom() + " gagné ! Score : " + joueur1.getScore());
                    System.out.println(joueur2.getNom() + " perdu ! Score : " + joueur2.getScore());
                } else if (carteJ1.comparateur(carteJ2) == 0) {
                    System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
                    joueur2.ajouteUneCarte(carteJ2);
                    joueur2.ajouteUneCarte(carteJ1);
                    joueur2.gagner();
                    System.out.println(joueur1.getNom() + " perdu ! Score : " + joueur1.getScore());
                    System.out.println(joueur2.getNom() + " gagné ! Score : " + joueur2.getScore());
                } else {
                    System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
                    System.out.println("** Egalité ! ");

                }
                

                System.out.println();

            } else if (str3.equals("N")) {

                joueur1continu = false;
                joueur2continu = false;

                System.out.println("La partie est interrompue ,à bientôt !");
            }

        }

        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println(joueur1.getNom() + " remporte la partie ! ");
        } else if (joueur2.getScore() > joueur1.getScore()) {
            System.out.println(joueur2.getNom() + " remporte la partie  ! ");
        } else {
            System.out.println("Egalité ! ");
        }
    }

}