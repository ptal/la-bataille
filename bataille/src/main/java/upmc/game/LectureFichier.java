/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureFichier {
    
    private ArrayList<String> pseudo = new ArrayList<String>(); 
    
    public ArrayList<String> lirePseudo() throws FileNotFoundException, IOException {
        
        
        System.out.println("Veuillez indiquer le nom du fichier .txt (à placer dans le dossier bataille, par défaut : test)");
        Scanner sc_nom_fichier = new Scanner(System.in);
        String nom_fichier = sc_nom_fichier.nextLine();
        
        File f = new File(nom_fichier+ ".txt");
        
        FileInputStream fis = null;
        
        //System.out.println("le fichier existe ? " +f.exists());
        //System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        
        if(f.exists()){ 
            System.out.println("Vous avez selectionné le fichier : " +nom_fichier+ ".txt");
            
            
            try {
                FileReader c = new FileReader(nom_fichier +".txt");
                BufferedReader r = new BufferedReader(c);

                String line = r.readLine();
                
                System.out.println("Les pseudos des joueurs sont : ");
                while (line != null) {
                    String[] decompose = line.split(";");
                    String a = decompose[0];
                    System.out.println(a);
                    this.pseudo.add(a);
                    line = r.readLine();
                }

                r.close();

            } catch (Exception e) {
                    throw new Error(e);
            }
        }else{
            System.out.println(nom_fichier + ".txt  n'existe pas"); 
            lirePseudo();
        }
        return this.pseudo;
    }   
}
