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
    public LectureConsole(){

    }

    public ArrayList<String> lirePseudo() {
        ArrayList pseudos=new ArrayList();
        pseudos.add(nom_joueur());
        pseudos.add(nom_joueur());
        return pseudos;
    }
    
    private String nom_joueur(){
        Scanner sc=new Scanner(System.in);
        String str="";
        String test="";
        
        while(str.equals("") || str.length()>40){
            Bataille.affiche("Entrez le nom d'un joueur (40 caractères maximum) :");
            test=sc.nextLine();
            if(!test.equals("")){ // Permet d'éviter les fantômes
                while(test.charAt(0)==' ' && test.length()>1){
                    test=test.substring(1);
                }
            }
            if(!test.equals(" ")){
                str=test;     
            }else{
                str="";
            }
        }
        Bataille.affiche("Bienvenue "+str+" !");
        return str;
    
   }
    
}
