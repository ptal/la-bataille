package upmc.game;

import java.util.Scanner;

public class Bataille {

	public static void main(String[] args) {
		
	//	Scanner sc = new Scanner(System.in);
		
	//	System.out.println("Entrez le nom du premier joueur");
	//	String nom_j1 = sc.nextLine();
		
	//	System.out.println("Entrez le nom du second joueur");
		
		
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		
		System.out.println("Bienvenue dans le jeu bataille UPMC!");
		
		Jeu jeu1 = new Jeu(joueur1, joueur2);
		jeu1.LancerJeu();
		
		System.out.println("Le jeu est termin�, pour relancer la partie appuyez sur Run");
		
	}

}