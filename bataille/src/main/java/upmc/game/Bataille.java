package upmc.game;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Bataille {
    public static void main(String[] args) throws IOException {
       
        //Choix du mode
        System.out.println("Bonjour, \n Choissisez un mode : \n (1) Jouez contre l'ordinateur \n (2) Mode 2 joueurs");
        Game game1 = new Game();
        game1.Mode();
              
        //TP2
        MenuPseudo menu_pseudo = new MenuPseudo();
        menu_pseudo.modeLecturePseudo(game1);
        
        
        
        //creation joueur
       /* System.out.println("Creation des joueurs ...");
        System.out.println("Votre nom : ");
        System.out.flush();
        Scanner sc_nom_1 = new Scanner(System.in);
        String nom_joueur_1 = sc_nom_1.nextLine();
        
        System.out.println("Votre nom de l'adversaire : ");
        System.out.flush();
        Scanner sc_nom_2 = new Scanner(System.in);  
        String nom_joueur_2 = sc_nom_2.nextLine();
        
        Joueur j1 = new Joueur(0);
        Joueur j2 = new Joueur(0); */
    }
}
