/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jerom
 */
public class Joueur{
    
    private int score;
    private List joueur_deck = new LinkedList();
    private String nom;
    
    public Joueur(String nom){
        this.nom = nom;
    }
    
    public String VoirNomJoueur(){
        return nom;
    }
    
    public void AjoutScore(int score){
        this.score+=score;
    }
    
    public void AjoutCarte(String carte){
        joueur_deck.add(carte);
    }
    

    
    public void VoirCarte(int numero){
        if("11".equals(joueur_deck.get(numero).toString().substring(0, 2))){
            System.out.println("J " + VoirCarteColor(numero));
        }else if ("12".equals(joueur_deck.get(numero).toString().substring(0, 2))){
            System.out.println("D " + VoirCarteColor(numero));
        }else if ("13".equals(joueur_deck.get(numero).toString().substring(0, 2))){
            System.out.println("K " + VoirCarteColor(numero));
        }else{
            System.out.println(joueur_deck.get(numero));
        }
        
    }
    
    public int VoirCarteValeur(int numero){
        String valor = joueur_deck.get(numero).toString().substring(0, 2);
        return  Integer.parseInt(valor);
    }
    public String VoirCarteColor(int numero){
        String color = joueur_deck.get(numero).toString().substring(3, 4);
        return  color;
    }

    public int Score(){
        return score;
    }
    public String toString(){
        return "score = " + score;
    }
}
