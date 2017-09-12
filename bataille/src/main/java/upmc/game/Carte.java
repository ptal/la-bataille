/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author licence
 */
public class Carte {
    private int num;
    static String couleur[]={"trefle", "coeur", "carreau", "pique"};
    
    public Carte(int num, int indexCouleur){
        this.num=num;
        this.couleur[indexCouleur];
    }
    
    public String toString(){
        return "Numero de carte = " + num ;
    }
}
