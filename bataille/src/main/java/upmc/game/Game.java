/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jerom
 */
public class Game {
    private int mode_partie;
    private int round = 0;
    
    public Game(){
        
    }
    
    //Choix du mode du jeux mode_partie
    public void Mode(){ 
        Scanner sc = new Scanner(System.in);   
        int mode = sc.nextInt();

        if(mode==1){
            System.out.println("Vous avez séléctioné le mode contre l'ordinateur");
            this.mode_partie = mode;
        }else if(mode==2){
            System.out.println("Vous avez séléctioné le mode local");
            this.mode_partie = mode;
        }else{
            System.out.println("Il y a un probleme de séléction \n Veuillez saisir 1 ou 2");
            Mode();
        }
    }
    
    //verifie qui gagne
    public void Verifie(String nom_joueur_1, String nom_joueur_2, Joueur j1, Joueur j2){
        if(j1.VoirCarteValeur(round)<j2.VoirCarteValeur(round)){
            System.out.println(nom_joueur_2 + " gagne");
            j2.AjoutScore(1);
        }else if (j1.VoirCarteValeur(round)>j2.VoirCarteValeur(round)){
            System.out.println(nom_joueur_1 + " gagne");
            j1.AjoutScore(1);
        }else{
            System.out.println("Egalité");
        } 
    }
    
    //affiche le tableau des scores
    public void TableauScore(String nom_joueur_1, String nom_joueur_2, Joueur j1, Joueur j2){
        System.out.println("---------------------------------------------------------");
        System.out.println("   Round numero " + round);
        System.out.println("Le joueur " + nom_joueur_1 + " a pour score : " +j1.Score()); 
        System.out.println("Le joueur " + nom_joueur_2 + " a pour score : " +j2.Score()); 
        Menu(nom_joueur_1, nom_joueur_2, j1, j2);
    }
    
    //compte les rounds et affiche la fin
    public void Point(String nom_joueur_1, String nom_joueur_2, Joueur j1, Joueur j2){
        if(round<24){  // 52/3
            round=round+1;
            Menu(nom_joueur_1, nom_joueur_2, j1, j2);
        }else{ //fin
            System.out.println("---------------------------------------------------------");
            System.out.println("Fin de la partie \n"+ nom_joueur_1 +" a "+ j1.Score() + " point(s) \n"+ nom_joueur_2 +" a "+ j2.Score() + " point(s)");
            if(j1.Score()<j2.Score()){
                System.out.println(nom_joueur_2 + " a gagné ! ");
            }else if(j1.Score()>j2.Score()){
                System.out.println(nom_joueur_1 + " a gagné ! ");
            }else{
                System.out.println("Le résultat final se termine par une égalité ! ");
            }  
            System.out.println("---------------------------------------------------------");   
        }
    }
    public void ProblemeSelection(String nom_joueur_1, String nom_joueur_2, Joueur j1, Joueur j2){
        System.out.println("Il y a un probleme de séléction \n Veuillez saisir 1, 2 ou 3");
        Menu(nom_joueur_1, nom_joueur_2, j1, j2);
    }
    
    public void Menu(String nom_joueur_1, String nom_joueur_2, Joueur j1, Joueur j2){
        
        if(mode_partie == 1){
            System.out.println("(1) Tirer la prochaine carte     (2) Score   (3) Quitter");
            Scanner sc_menu = new Scanner(System.in);
            String menu1 = sc_menu.nextLine();
            
            if("1".equals(menu1) || "".equals(menu1)){ //choix enter ou 1
                //a chaque round
                System.out.println("---------------------------------------------------------");
                //montre les cartes
                System.out.println(nom_joueur_1 + " tire la carte : ");
                j1.VoirCarte(round);
                System.out.println(nom_joueur_2 + " tire la carte : ");
                j2.VoirCarte(round);     

                //verifie la meilleur
                Verifie(nom_joueur_1, nom_joueur_2, j1, j2);
                  
                //comptabilise les rounds
                Point(nom_joueur_1, nom_joueur_2, j1, j2);
            
            }else if("2".equals(menu1)){
                TableauScore(nom_joueur_1, nom_joueur_2, j1, j2);
            }else if("3".equals(menu1)){
                System.exit(0);
            }else{
                ProblemeSelection(nom_joueur_1, nom_joueur_2, j1, j2);
            }

            
            
        }else{ //2 Joueur
            
            
            //Premier Joueur
            System.out.println("---------------------------------------------------------");
            System.out.println("-> A " + nom_joueur_1 +" de jouer \n (1) Tirer la prochaine carte     (2) Score   (3) Quitter");
            Scanner sc_menu_j1 = new Scanner(System.in);   
            String menu_j1 = sc_menu_j1.nextLine();

            if("1".equals(menu_j1) || "".equals(menu_j1)){
                //montre la carte
                System.out.println(nom_joueur_1 + " tire la carte : ");
                j1.VoirCarte(round);
            }else if("2".equals(menu_j1)){
                TableauScore(nom_joueur_1, nom_joueur_2, j1, j2);
            }else if("3".equals(menu_j1)){
                System.exit(0);
            }else{
                System.out.println("---------------------------------------------------------");
                ProblemeSelection(nom_joueur_1, nom_joueur_2, j1, j2);
            }  
            
            
            
            
            //Deuxieme Joueur
            System.out.println("-> A " + nom_joueur_2+" de jouer\n (1) Tirer la prochaine carte     (2) Score   (3) Quitter");
            Scanner sc_menu_j2 = new Scanner(System.in);   
            String menu_j2 = sc_menu_j2.nextLine();
               
            if("1".equals(menu_j2) || "".equals(menu_j2)){
                //montre la carte
                System.out.println(nom_joueur_2 + " tire la carte : "); 
                j2.VoirCarte(round);
                
                //verifie la meilleur
                Verifie(nom_joueur_1, nom_joueur_2, j1, j2);
                  
                //comptabilise les rounds
                Point(nom_joueur_1, nom_joueur_2, j1, j2); //ne peut pas faire réduire pour cette instruction
                
            }else if("2".equals(menu_j2)){
                TableauScore(nom_joueur_1, nom_joueur_2, j1, j2);
            }else if("3".equals(menu_j2)){
                System.exit(0);
            }else{
                ProblemeSelection(nom_joueur_1, nom_joueur_2, j1, j2);
            }
        }
    }
}
