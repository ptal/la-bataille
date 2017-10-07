/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Scanner;

/**
 *
 * @author NICO
 */
public class Bataille {
    
public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Joueur j1 = new Joueur("joueur 1");
        Joueur j2 = new Joueur("IA joueur2");
        
        System.out.println("Vous jouez contre l'IA.");
        
        System.out.println("Joueur 1, saisissez votre nom :");
        j1.setNom(sc.nextLine());
        

        for(int i = 0; i < 52; i++){
            Carte c1 = j1.tireCarte();
            Carte c2 = j2.tireCarte();

            System.out.println(c1.toString());
            System.out.println(c2.toString());

            if(c1.compareTo(c2)){
                j1.gagnePoint();
            }
            else{
                j2.gagnePoint();
            }
        }
        System.out.println("================");
        System.out.println("SCORE :");
        System.out.println(j1.getNom()+" : "+j1.getPoint());
        System.out.println("IA joueur2: "+j2.getPoint());
        System.out.println("================");
    }
}
