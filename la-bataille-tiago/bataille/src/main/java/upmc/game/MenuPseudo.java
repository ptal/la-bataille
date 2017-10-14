/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.util.Scanner;

/**
 *
 * @author lepor
 */
public class MenuPseudo {
    public LecturePseudo modeLecturePseudo() {
        //Demande le choix à l'utilisateur
        System.out.println("(1) Lecture console");
        System.out.println("(2) Lecture fichier"); 
       
        Scanner sc = new Scanner(System.in); 
        int choice = sc.nextInt();
      
        //Cas console
        if (choice == 1) {
            LectureConsole console = new LectureConsole();     
        }
        
        //Cas fichier
        else {
            LectureFichier fichier = new LectureFichier();
        }
        return null;
    }  
}
