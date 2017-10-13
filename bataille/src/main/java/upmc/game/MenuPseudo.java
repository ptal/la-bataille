/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Scanner;

/**
 *
 * @author jerom
 */
public class MenuPseudo {
    
    
    
    public LecturePseudo modeLecturePseudo(){
        System.out.println("Renseigner les pseudos par \n   (1) Console \n   (2) Fichier");
        
        Scanner sc = new Scanner(System.in);   
        int mode = sc.nextInt();

        if(mode==1){
            System.out.println("Vous avez séléctioné le mode console");

            return new LectureConsole();
        }else if(mode==2){
            System.out.println("Vous avez séléctioné le mode fichier");
            
        }else{
            System.out.println("Il y a un probleme de séléction \n Veuillez saisir 1 ou 2");
            modeLecturePseudo();
        }
        
        
        
        
        return null;
        
        
        
    }
}
