package upmc.game;

import java.util.Scanner;

public class MenuPseudo{

	
	private static Scanner console;

	public static LecturePseudo modeLecturePseudo() {
		
		int choix;
		console = new Scanner( System.in );
		LecturePseudo pseudo;
		
		System.out.print( " (1: Ecrire dans console   2: Recuperer dans fichier)" );
		do {
			try {
				choix = Integer.parseInt( console.nextLine() );
			} catch( Exception except ) {
				choix = 0;
			}
		}
		while( !( ( choix == 1 ) || ( choix == 2 ) ) );		
		
		if( choix == 1 ) {
			
			pseudo = new LectureConsole();
			
		} else {
			
			pseudo = new LectureFichier();
			
		}
		
		return pseudo;
		
	}
}
