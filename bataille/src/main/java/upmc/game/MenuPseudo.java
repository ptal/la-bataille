/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
/**
 *
 * @author licence
 */
public class MenuPseudo {
    
    public static LecturePseudo modeLecturePseudo(){
        int mode_lecture=3;
        LecturePseudo lecture;
        
        Bataille.affiche("Choisissez le mode de récupération des pseudo :");
        Bataille.affiche("1 - Entrer de nouveux pseudos via la console");
        Bataille.affiche("2 - Selectionner un fichier");
        
        while(mode_lecture!=1 && mode_lecture!=2){
            mode_lecture=Bataille.test_int(3);
        }
        if(mode_lecture==1){
            lecture=new LectureConsole();
        }else{
            lecture=new LectureFichier();
        }
        return lecture;
    }
}
