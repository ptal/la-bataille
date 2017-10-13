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
    private Scanner sc = new Scanner(System.in);
    private ArrayList paquet =new ArrayList();
    private char mode_automatique='A';
    private int condition_de_victoire;
    private int choix_menu=1;
    private ArrayList<Carte> cartes_a_gagner=new ArrayList();
    
    private Joueur joueur_1;
    private Joueur joueur_2;
    
    
    public Partie(){
        
        Bataille.affiche("------------------------ LE JEU DE LA BATAILLE -------------------------------\n");
        
        // Questions à l'utilisateur 
        while(mode_automatique!='O' && mode_automatique!='N' ){
            Bataille.affiche("Souhaitez-vous jouer en mode automatique ? O/N");
            mode_automatique=Bataille.test_scanner(sc); 
        }
        demande_condition_de_victoire(this.mode_automatique, this.sc);
        
        LecturePseudo lecturepseudo=MenuPseudo.modeLecturePseudo();
        ArrayList<String> pseudos = lecturepseudo.lirePseudo();
        
        
        // Génération du paquet de cartes et des joueurs
        this.paquet = generer_paquet(this.paquet); 
        this.paquet = melanger_paquet(this.paquet);

        this.joueur_1=new Joueur(0, this.paquet, pseudos.get(0));
        this.joueur_2=new Joueur(1, this.paquet, pseudos.get(1));
        
        
        // Déroulement d'une manche :
        // - (si mode non automatique) choix_menu() => choix entre tirer une carte, abandonner et voir les scores en mode non automatique
        // - (si mode automatique ou choix de tirer une cartejoue, on joue la manche
        // - Si partie fini ou choix d'abandonner, on compare les points et la partie est finie.

        while((this.joueur_1.affiche_nombre_cartes_restantes() >0 || this.joueur_2.affiche_nombre_cartes_restantes() >0 ) && this.choix_menu == 1){
            if(this.mode_automatique=='N'){
                this.choix_menu=4;
                while(this.choix_menu!= 1 && this.choix_menu !=2){
                    this.choix_menu=choisir_menu();
                    if(this.choix_menu==3){ // Choix : voir les scores
                        Bataille.affiche(joueur_1.compare_points(joueur_2, condition_de_victoire));
                    }
                }
            }
            if(this.choix_menu==1){  // Choix tirer une carte, ou jeu en mode automatique
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
        
        // J'ai préféré désactivé le mode automatique si les cartes sont remises dans le tas (conditions de victoire 2), parce que c'est VRAIMENT trop long sinon
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

        if(resultat.equals("BATAILLE !")){ //en cas de batailles, on ajoutes les cartes jouées dans le paquet de carte_a_gagner remis en jeu à la manche suivante
            this.cartes_a_gagner.add(c1); 
            this.cartes_a_gagner.add(c2);
        }else{
            this.cartes_a_gagner.clear();
        }
    }
    
}
