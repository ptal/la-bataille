package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureConsole implements LecturePseudo{
    
    private ArrayList<String> pseudo = new ArrayList<String>(); 
        
    public ArrayList<String> lirePseudo() {
        
        for(int nbr_joueur = 1; nbr_joueur<=2; nbr_joueur++) {
            // traitement 
            System.out.println("Veuillez entrer le nom du joueur " + nbr_joueur);
            Scanner sc = new Scanner(System.in);
            this.pseudo.add(sc.nextLine());
        }
        return this.pseudo;
    }
}
