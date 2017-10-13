/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Scanner;

/**
 * La classe menu pseudo propose un menu pour choisir une methode de lecture des pseudos
 * @author Nicolas
 */
public class MenuPseudo {
    /**
     * Constructeur par défaut 
     */
    public MenuPseudo(){}
    
    /**
     * Demande à l'utilisateur le mode de lecture des pseudos 
     */
    public LecturePseudo modeLecturePseudo() {
        Scanner scan = new Scanner(System.in);
        int choixLecture = 0;
        
        System.out.println("=====");
        while(choixLecture != 1 && choixLecture != 2) {
            System.out.println("Comment voulez-vous entrez les pseudos ?");
            System.out.println(" 1. Avec la console\n 2. Avec un fichier");
            System.out.println("Votre choix ? ");
            choixLecture = scan.nextInt();
        }
        System.out.println("=====");
        
        if(choixLecture == 1)
            return new LectureConsole();
        else
            return new LectureFichier();
    }
}
