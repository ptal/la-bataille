/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author licence
 */
public class Partie {
    Scanner sc = new Scanner(System.in);
    ArrayList paquet =new ArrayList();
    char mode_automatique='A';
    int condition_de_victoire;
    int choix_menu=1;
    ArrayList<Carte> cartes_a_gagner=new ArrayList();
    
    Joueur joueur_1;
    Joueur joueur_2;
    
    
    public Partie(){
        
        Bataille.affiche("------------------------ LE JEU DE LA BATAILLE -------------------------------\n");
        this.paquet = generer_paquet(this.paquet); 
        this.paquet = melanger_paquet(this.paquet);
        
        while(mode_automatique!='O' && mode_automatique!='N' ){
            Bataille.affiche("Souhaitez-vous jouer en mode automatique ? O/N");
            mode_automatique=Bataille.test_scanner(sc); 
        }
        
        demande_condition_de_victoire(this.mode_automatique, this.sc);
        
        this.joueur_1=new Joueur(0, this.paquet, nom_joueur(this.sc));
        this.joueur_2=new Joueur(1, this.paquet, nom_joueur(this.sc));
        
        while((this.joueur_1.get_nombre_cartes_restantes() >0 || this.joueur_2.get_nombre_cartes_restantes() >0 ) && this.choix_menu == 1){
            if(this.mode_automatique=='N'){
                this.choix_menu=4;
                while(this.choix_menu!= 1 && this.choix_menu !=2){
                    this.choix_menu=choisir_menu();
                    if(this.choix_menu==3){
                        Bataille.affiche(joueur_1.compare_points(joueur_2, condition_de_victoire));
                    }
                }
            }
            if(this.choix_menu==1){
                joue_manche();            
            }
        }
        
        Bataille.affiche("\n" +joueur_1.compare_points(joueur_2, condition_de_victoire));

        
    }
    
    
    private ArrayList generer_paquet(ArrayList paquet){
        String couleurs[] = {"trefle", "pique", "carreau", "coeur"};
        for(int i=0; i<couleurs.length; i++){
            for(int j=2; j<15; j++){
                Carte c=new Carte(j, couleurs[i]);
                paquet.add(c);
            }
        }

        Bataille.affiche("Création d'un paquet de 52 cartes");
        return paquet;
    }
    
    private ArrayList melanger_paquet(ArrayList pPaquet){
        
        ArrayList paquet_melange=new ArrayList();
        while(pPaquet.size()>0){
            double random=Math.random()*pPaquet.size();
            int index=(int)random;
            
            paquet_melange.add(pPaquet.get(index));
            pPaquet.remove(index);
            
        }
            
        Bataille.affiche("On mélange !");
        return paquet_melange;
    }
    
    
    private void demande_condition_de_victoire(char mode_automatique, Scanner sc){
    
        if(mode_automatique=='N'){
            while(this.condition_de_victoire!=1 && this.condition_de_victoire!=2){
                Bataille.affiche("Choisissez votre condition de victoire");
                Bataille.affiche("1 - Les cartes gagnées sont mises de côté et comptées comme des points. Le jeu se termine lorsque les joueurs n'ont plus de cartes en main.");
                Bataille.affiche("2 - Les cartes gagnées s'ajoutent à la main du gagnant de la main. Le jeu se termine lorsqu'un des joueurs détient toutes les cartes (non disponible en mode automatique)");
                if(sc.hasNextInt()){
                    this.condition_de_victoire=sc.nextInt(); 
                }
                sc.nextLine();
            }
        }else{
            this.condition_de_victoire=1;
        }
    
    }
    
    private String nom_joueur(Scanner sc){
        String str="";
        String test="";
        
        while(str.equals("") || str.equals(null)|| str.length()>40){
            Bataille.affiche("Entrez le nom d'un joueur (40 caractères maximum) :");
            test=sc.nextLine();
            if(!test.equals("")){ // Permet d'éviter les fantômes
                while(test.charAt(0)==' ' && test.length()>1){
                    test=test.substring(1);
                }
            }
            if(!test.equals(" ")){
                str=test;
                      
            }else{
                str="";
            }
        }
        Bataille.affiche("Bienvenue "+str+" !");
        return str;
    
   }
    private int choisir_menu(){
        Bataille.affiche("Souhaitez vous : ");
        Bataille.affiche("1 - Tirer une nouvelle carte");
        Bataille.affiche("2 - Abandonner la partie");
        Bataille.affiche("3 - Connaitre le nombre de cartes des joueurs");

        if(sc.hasNextInt()){
            this.choix_menu = this.sc.nextInt();
        }else{
            this.choix_menu=4; 
        }
        sc.nextLine();
        
        return this.choix_menu;
    }
    private void joue_manche(){
        Bataille.affiche(" ");
        Carte c1 = this.joueur_1.joue();
        Carte c2 = this.joueur_2.joue();

        String resultat = c1.compare(c2, this.joueur_1, this.joueur_2, this.cartes_a_gagner, this.condition_de_victoire);
        Bataille.affiche(resultat);

        if(resultat.equals("BATAILLE !")){
            this.cartes_a_gagner.add(c1);
            this.cartes_a_gagner.add(c2);
        }else{
            this.cartes_a_gagner.clear();
        }
    }
    
}
