/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LectureConsole permet de lire des pseudos depuis le fichier
 * @author Nicolas
 */
public class LectureFichier implements LecturePseudo {

    /**
     * Constructeur par défaut 
     */
    public LectureFichier(){}
    
    /**
     * Permets de lire les pseudos a partir d'un fichier dont on donne le nom
     */
    public ArrayList<String> lirePseudo(boolean avecIA) {
        Scanner scan = new Scanner(System.in);
        String nomFichier = "";
        ArrayList<String> tabPseudo= new ArrayList<String>();
        
        System.out.println("-----\nChoix des pseudos ! ");
        while(nomFichier == "" || !nomFichier.contains(".txt")) {
            System.out.println("Entrez le nom d'un fichier a lire avec son extension (.txt) : ");
            nomFichier = scan.nextLine();
        }
        
        tabPseudo = lireFichier(nomFichier);
        tabPseudo.set(1, tabPseudo.get(1)+"(IA)");
        
        System.out.println("Les noms des joueurs sont : "+tabPseudo.get(0)+" et "+tabPseudo.get(1));
        System.out.println("Appuyez sur entree ..\n");
        scan.nextLine();
        
        return tabPseudo;
    }
    
    /**
     * Lis les informations d'un fichier à partir du nom  en parametre
     */
    public ArrayList<String> lireFichier(String nomFichier) {
        ArrayList<String> tabResult = new ArrayList<String>();
        
        try {
            //Initialisation
            File file = new File("./src/files/"+nomFichier);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                    tabResult.add(line);
            }
            fileReader.close(); //close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tabResult;
    }
    
}
