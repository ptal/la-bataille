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
 * @author licence
 */
public class LectureConsole implements LecturePseudo{
        
        private ArrayList<String> pseudo = new ArrayList<String>(); 
        
    public ArrayList<String> lirePseudo() {
        
        Scanner sc = new Scanner(System.in); 
        int nbJoueur = 0; 
        while (sc.hasNextLine() && nbJoueur < 3) {
            // traitement 
            System.out.println("Veuillez entrer le nom du joueur " + nbJoueur); 
            this.pseudo.add(sc.nextLine()); 
        }
        
        return this.pseudo;
    }
    
}// redha aissaoui
