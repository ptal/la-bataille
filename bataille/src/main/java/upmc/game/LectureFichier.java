/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author licence
 */
public class LectureFichier implements LecturePseudo{


    public ArrayList<String> lirePseudo() {
        ArrayList pseudos=litFichier(fichier_selectionne());
        return pseudos;
    }
    
    private File fichier_selectionne(){
        File f=new File("Fichiers"); 
        ArrayList<File> liste_fichiers=new ArrayList();
        Scanner sc=new Scanner(System.in);
        int num_fichier=-1;
        
        Bataille.affiche("Choississez un fichier :");
        
        //Affichage des fichiers disponibles
        int i=0;
        for(File fichier : f.listFiles()){
            i++;
            liste_fichiers.add(fichier);
            Bataille.affiche(i+" - "+fichier.getName());
        }
        // Selection du fichier
        while(num_fichier>i || num_fichier<1){
            num_fichier=Bataille.test_int(-1);
        }
        f=liste_fichiers.get(num_fichier-1);
        
        Bataille.affiche("Vous avez choisis le fichier "+f.getName());
        return f;
    }
    
    private ArrayList<String> litFichier(File fichier){
        BufferedReader  lire=null;
        ArrayList pseudos=new ArrayList();
        
        try{
            String chemin=fichier.getAbsolutePath();
            lire = new BufferedReader(new FileReader(chemin));
            String ligne="";
            
            while((ligne = lire.readLine())!=null){
                pseudos.add(ligne);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            if(lire!=null){
                try {
                    lire.close();
                } catch (IOException ex) {
                    Logger.getLogger(LectureFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pseudos;
    }
}
