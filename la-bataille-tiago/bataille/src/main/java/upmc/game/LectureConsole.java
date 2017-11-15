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
    
    
    public static ArrayList<String> lirePseudo(int y) {
    ArrayList<String> pseudo = new ArrayList<String>();
    int nbrjoueur = 1;
    
    for (int x=1; x<3; x++) {
        System.out.println("Veuillez entrer un joueur " + nbrjoueur);
        Scanner sc = new Scanner(System.in);
        pseudo.add(sc.nextLine());
        nbrjoueur++;
    }
    return pseudo;
    }
    
    
}



