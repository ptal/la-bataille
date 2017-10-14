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
    
    private ArrayList<String> pseudo = new ArrayList<String>();
    public ArrayList<String> lirePseudo() {
       
    int nbrjoueur = 0;

    System.out.println("Veuillez entrer un joueur " + nbrjoueur);
    Scanner sc = new Scanner(System.in);
    pseudo.add(sc.nextLine());
       
    return pseudo;
    }
}



