package upmc.game;

import java.util.Scanner;

public class LectureConsole implements LecturePseudo{
	
	public static Scanner console = new Scanner( System.in );
	
	public LectureConsole() {
		
	}
	
	public String lirePseudo() {
		
        
        System.out.println( "Entrez le nom du joueur :" );
        System.out.flush();
        return console.nextLine();
        
	}


}
