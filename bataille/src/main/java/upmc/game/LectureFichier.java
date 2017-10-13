/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jerom
 */
public class LectureFichier {
    
    private ArrayList<String> pseudo = new ArrayList<String>(); 
    
    public ArrayList<String> lirePseudo() {
        
        
        System.out.println("Veuillez indiquer le nom du fichier .txt ");
        Scanner sc = new Scanner(System.in);
        this.pseudo.add(sc.nextLine());
        File f = new File(sc.nextLine()+ ".txt");
        System.out.println(f);
        
        
        
        /*for(int nbr_joueur = 1; nbr_joueur<=2; nbr_joueur++) {
            // traitement 
            System.out.println("Veuillez entrer le nom du joueur " + nbr_joueur);
            Scanner sc = new Scanner(System.in);
            this.pseudo.add(sc.nextLine()); 
        }*/
        return this.pseudo;
    }
    
    
    
    
}
