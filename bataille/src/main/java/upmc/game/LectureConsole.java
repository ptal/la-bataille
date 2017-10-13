<<<<<<< HEAD
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureConsole implements LecturePseudo{

   
        
          private ArrayList<String> pseudo = new ArrayList<String>(); 

        

    public ArrayList<String> lirePseudo() {

        

        Scanner sc = new Scanner(System.in); 

        int nbJoueur = 0; 

        while (sc.hasNextLine() && nbJoueur < 3) {

            // traitement 

            System.out.println("Veuillez entrer le nom du joueur " + nbJoueur); 

            this.pseudo.add(sc.nextLine()); 

        }

        

        return this.pseudo;

    }
    }
    
    
    
=======
package upmc.game;

import java.util.ArrayList;

public class LectureConsole implements LecturePseudo{

    public ArrayList<String> lirePseudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
>>>>>>> 397ecee32f693e8f17d4444b82b96b16173c1001
