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
        
        String str="";
        
        Bataille.affiche("Entrez le nom d'un joueur (40 caractères maximum) :");
        
        while(str.equals("") || str.length()>40){
            str=Bataille.test_string();
        }
        Bataille.affiche("Bienvenue "+str+" !");
        
        return str;
    
   }
    
}
