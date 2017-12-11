package upmc.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adrien on 11/10/2017.
 */
public class ReadFile implements ReadPseudo {
    public ArrayList<String> readPseudo() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> pseudoList = new ArrayList<String>();

        System.out.print("Saisissez le fichier à lire : ");
        String fileName = "src/main/java/upmc/game/" + sc.nextLine();

        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = br.readLine();
                while (line != null) {
                    pseudoList.add(line);
                    line = br.readLine();
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture : " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
        }
        return pseudoList;
    }
}
