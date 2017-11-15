package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Bataille {

	public static void main(String[] args) {
		
	 /*	LectureConsole lc = new LectureConsole(); 
               ArrayList<String> tab = lc.lirePseudo(); 
                
                for(int i = 0; i < tab.size(); i++) {
                    if (i == 0) { 
                        joueur1 = new Joueur(tab.get(i));
                    }
                    else {
                        joueur2 = new Joueur(tab.get(i)); 
                    }
                }*/
                System.out.println("Bienvenue dans le jeu bataille UPMC!");
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez le nom du premier joueur");
                String j1 = sc.nextLine();
                System.out.println("Entrez le nom du second joueur");
                String j2 = sc.nextLine();
                Joueur joueur1 = new Joueur(j1); 
                Joueur joueur2 = new Joueur(j2);
		
		
		
		Jeu jeu1 = new Jeu(joueur1, joueur2);
		jeu1.lancerJeu();
		
                
		System.out.println("Le jeu est terminé, pour lancer une nouvelle partie, appuyez sur Run");
		
	}

}// redha aissaoui