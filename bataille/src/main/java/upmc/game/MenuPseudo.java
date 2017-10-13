/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.util.Scanner;
/**
 *
 * @author licence
 */
public class MenuPseudo {
    
    public static LecturePseudo modeLecturePseudo(){
        Scanner sc=new Scanner(System.in);
        int modeLecture=3;
        LecturePseudo lecture;
        
        while(modeLecture!=1 && modeLecture!=2){
            Bataille.affiche("Choisissez le mode de récupération des pseudo :");
            Bataille.affiche("1 - Entrer de nouveux pseudos via la console");
            Bataille.affiche("2 - Selectionner un fichier");

            if(sc.hasNextInt()){
                modeLecture=sc.nextInt(); 
            }else{
                modeLecture=3;
            }
            sc.nextLine();
        }
        if(modeLecture==1){
            lecture=new LectureConsole();
        }else{
            lecture=new LectureFichier();
        }
        return lecture;
    }
}
