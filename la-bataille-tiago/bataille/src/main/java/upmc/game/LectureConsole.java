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
public class LectureConsole {
    
    
    public static ArrayList<String> lirePseudo() {
    ArrayList<String> pseudo = new ArrayList<String>();
    
    
    Scanner sc = new Scanner(System.in);
 
        System.out.println("Veuillez entrer un joueur 1 :");
        pseudo.add(sc.nextLine());
        
        
        System.out.println("Veuillez entrer un joueur 2 :");
        pseudo.add(sc.nextLine());
    
    return pseudo;
    }
    
    
}



