package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Bataille {

	public static void main(String[] args) {
		
		LectureConsole lc = new LectureConsole(); 
                ArrayList<String> tab = lc.lirePseudo(); 
                Joueur joueur1 = null; 
                Joueur joueur2 = null; 
                for(int i = 0; i < tab.size(); i++) {
                    if (i == 0) { 
                        joueur1 = new Joueur(tab.get(i));
                    }
                    else {
                        joueur2 = new Joueur(tab.get(i)); 
                    }
                }
		
		System.out.println("Bienvenue dans le jeu bataille UPMC!");
		
		Jeu jeu1 = new Jeu(joueur1, joueur2);
		jeu1.LancerJeu();
		
		System.out.println("Le jeu est terminé, pour relancer la partie appuyez sur Run");
		
	}

}