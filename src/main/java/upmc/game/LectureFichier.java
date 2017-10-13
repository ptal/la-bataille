
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;


public class LectureFichier implements LecturePseudo{

        private ArrayList<String> fichier = new ArrayList<String>();

    
    public ArrayList<String> lirePseudo() {
        
        
         Scanner sc = new Scanner(System.in);

        String fichier = null;

        System.out.println(fichier);

        this.fichier.add(sc.nextLine());
   
        
        
        return this.fichier;
    }
    
}
