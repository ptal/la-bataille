package upmc.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adrien on 11/10/2017.
 */
public class LectureFichier implements LecturePseudo {
    public ArrayList<String> lirePseudo() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listePseudo = new ArrayList<String>();
        String pseudo;

        System.out.print("Saisissez le fichier à lire : ");
        String nomFichier = "src/main/java/upmc/game/"+sc.nextLine();

        try {
            File f = new File(nomFichier);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String ligne = br.readLine();
                while(ligne != null) {
                    listePseudo.add(ligne);
                    ligne = br.readLine();
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture : "+e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
        }
        return listePseudo;
    }
}
