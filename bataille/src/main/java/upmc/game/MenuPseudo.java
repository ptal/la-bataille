/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jerom
 */
public class MenuPseudo {
    
    
    
    public LecturePseudo modeLecturePseudo(Game game1) throws IOException{
        System.out.println("Renseigner les pseudos par \n   (1) Console \n   (2) Fichier");
        
        Scanner sc = new Scanner(System.in);   
        int mode = sc.nextInt();

        if(mode==1){
            System.out.println("Vous avez séléctioné le mode console");
            
            LectureConsole lc = new LectureConsole(); 
        
            ArrayList<String> tab_console = lc.lirePseudo(); 

            Joueur j1 = new Joueur(tab_console.get(0));
            Joueur j2 = new Joueur(tab_console.get(1)); 
            Lancement(j1, j2, game1);


        }else if(mode==2){
            System.out.println("Vous avez séléctioné le mode Fichier");
            
            LectureFichier lf = new LectureFichier(); 
        
            ArrayList<String> tab_fichier = lf.lirePseudo(); 

            Joueur j1 = new Joueur(tab_fichier.get(0));
            Joueur j2 = new Joueur(tab_fichier.get(1)); 
            
            
            
            Lancement(j1, j2, game1);
            
        }else{
            System.out.println("Il y a un probleme de séléction \n Veuillez saisir 1 ou 2");
            modeLecturePseudo(game1);
        }
        
        
        
        
        return null;
    }
    
    
    public void Lancement(Joueur j1, Joueur j2, Game game1){
        
        System.out.println("Création des cartes ...");
        //TimeUnit.SECONDS.sleep(1);
        //crea un deck
        Deck deck1 = new Deck();
        
        //distribution
        deck1.Distribution(j1,j2);
        //deck1.VoirDeck();    
  
        //lancement du menu
        game1.Menu(j1.VoirNomJoueur(), j2.VoirNomJoueur(), j1, j2);
    }
    
    
    
}
