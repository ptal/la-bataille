package upmc.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectureFichier implements LecturePseudo {

    private ArrayList<String> fichier = new ArrayList<String>();

    public ArrayList<String> lirePseudo() {

        try {

            File f = new File("fichier.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line = br.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }

                br.close();

                fr.close();

            }
           catch (IOException exception)
                        {
                            
                            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
                           
                        }
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(LectureFichier.class.getName()).log(Level.SEVERE, null, ex);
        }

           // Scanner scanner = new Scanner(f);
            //System.out.println(f.getAbsolutePath());

      
        Scanner sc = new Scanner(System.in);

        String fichier = null;

        System.out.println(fichier);

        this.fichier.add(sc.nextLine());

        return this.fichier;

    }

}