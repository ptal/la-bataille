/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lepor
 */
public class MenuPseudo {
    public static int modeLecturePseudo(int choice) {
        //Demande le choix à l'utilisateur
        
        System.out.println("[1] Jouer contre un joueur");
        System.out.println("[2] Jouer contre l'ordinateur"); 
       
        Scanner sc = new Scanner(System.in); 
        choice = sc.nextInt();
      
        
        return choice;
    }  
    
    
}
