/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class EcrireFichier {
    
    public static void ecrire_fichier(ArrayList<String> pseudos){
        
        FileWriter nouveau_fichier=null;
        BufferedWriter ecriture_fichier=null;
        try{
            nouveau_fichier=new FileWriter(demander_nom_fichier());
            ecriture_fichier=new BufferedWriter(nouveau_fichier);
            
            for(int i=0; i<2 ; i++){
                ecriture_fichier.write(pseudos.get(i)+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                ecriture_fichier.flush();
                ecriture_fichier.close();
                nouveau_fichier.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    private static String demander_nom_fichier(){
        String nom_campagne="";
        
        Bataille.affiche("Choississez le nom de votre campagne : (max 40 caractères)");
        while(nom_campagne.equals("") || nom_campagne.length()>40){
            nom_campagne=Bataille.test_string(); 
        }
        
        Bataille.affiche("Création du fichier "+nom_campagne);
        
        nom_campagne="Fichiers\\"+nom_campagne;
        return nom_campagne;
    }
}
