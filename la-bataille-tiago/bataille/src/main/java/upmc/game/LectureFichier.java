/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lepor
 */
public class LectureFichier implements LecturePseudo{
     
    private ArrayList<String> file = new ArrayList<String>();
    public ArrayList<String> lirePseudo() {
       
    //Création du fichier texte
    File f = new File("fichier.txt");
      
    try {
        FileReader fread = new FileReader(f); //Lire le contenu des fichiers
        BufferedReader bread = new BufferedReader(fread); //Lire les caractères
        String line = bread.readLine();
    
        while (line != null) { //Tant qu'il y a quelque chose dans le fichier
            System.out.println(line);
            line = bread.readLine();
        }
        
        bread.close();
        fread.close();
    
    }   catch (IOException ex) {   
            Logger.getLogger(LectureFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    return file;
    }
}
