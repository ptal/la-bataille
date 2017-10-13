/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * LectureConsole permet de lire des pseudos depuis la console
 * @author Nicolas
 */
public class LectureConsole implements LecturePseudo {
    
    /**
     * Constructeur par défaut 
     */
    public LectureConsole(){}

    /**
     * Permets de lire les pseudos a partir de la console
     */
    public ArrayList<String> lirePseudo(boolean avecIA) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> tabPseudo= new ArrayList<String>();
        
        System.out.println("-----\nChoix des pseudos ! ");
        System.out.println("Entre le nom du Joueur 1 : ");
        tabPseudo.add(scan.nextLine());
        if(!avecIA) {
            System.out.println("Entre le nom du Joueur 2 : ");
            tabPseudo.add(scan.nextLine());
        }
        else {
            tabPseudo.add("IA");
        }
        
        return tabPseudo;
    }
    
}
