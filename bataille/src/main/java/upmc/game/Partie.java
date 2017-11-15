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
    private ArrayList<Carte> paquet =null;
    private ArrayList<Carte> cartes_a_gagner=new ArrayList();
    private ArrayList<String> pseudos=null;
    private char mode_automatique='A';
    private int condition_de_victoire=0;
    private int MENU_NULL=4;
    private int TIRER_CARTE=1;
    private int ABANDONNER=2;
    private int VOIR_POINT=3;
    
    private int choix_menu=1;
    private boolean campagne=false;
    
    private Joueur joueur_1=null;
    private Joueur joueur_2=null;
    
    
    public Partie(){

        
        Bataille.affiche("------------------------ LE JEU DE LA BATAILLE -------------------------------\n");
        
        // Questions à l'utilisateur 
        this.pseudos=choix_des_pseudos();
        if(!this.campagne){
            demande_enregistrement();
        }
        this.mode_automatique=demande_mode_de_jeu(this.mode_automatique);
        
        this.condition_de_victoire=demande_condition_de_victoire(this.mode_automatique, this.sc);
        
        
        // Génération du paquet de cartes et des joueurs
        this.paquet = generer_paquet(); 
        this.paquet = melanger_paquet(this.paquet);

        this.joueur_1=new Joueur(0, this.paquet, pseudos.get(0));
        this.joueur_2=new Joueur(1, this.paquet, pseudos.get(1));
        
        
        // Déroulement d'une manche :
        // - (si mode non automatique) choix_menu() => choix entre tirer une carte, abandonner et voir les scores en mode non automatique
        // - (si mode automatique ou choix de tirer une cartejoue, on joue la manche
        // - Si partie fini ou choix d'abandonner, on compare les points et la partie est finie.

        while(jeu_continu()){
            if(this.mode_automatique=='N'){
                this.choix_menu=MENU_NULL;
                while(this.choix_menu!= TIRER_CARTE && this.choix_menu !=ABANDONNER){
                    this.choix_menu=choisir_menu();
                    if(this.choix_menu==VOIR_POINT){ // Choix : voir les scores
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
    
    private ArrayList choix_des_pseudos(){
        
        LecturePseudo lecturepseudo=MenuPseudo.modeLecturePseudo();
        ArrayList<String> p = lecturepseudo.lirePseudo();
        
        if(lecturepseudo.getClass().getName().equals("upmc.game.LectureFichier")){
            this.campagne=true;
        }
        return p;
    }
    
    private ArrayList generer_paquet(){
        ArrayList<Carte> p=new ArrayList();
        String couleurs[] = {"trefle", "pique", "carreau", "coeur"};
        for(int i=0; i<couleurs.length; i++){
            for(int j=2; j<15; j++){
                Carte c=new Carte(j, couleurs[i]);
                p.add(c);
            }
        }

        Bataille.affiche("Création d'un paquet de 52 cartes");
        return p;
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
    
    
    private int demande_condition_de_victoire(char mode_automatique, Scanner sc){
        int c=3;
        // J'ai préféré désactivé le mode automatique si les cartes sont remises dans le tas (conditions de victoire 2), parce que c'est VRAIMENT trop long sinon
        if(mode_automatique=='N'){ 
            
            Bataille.affiche("Choisissez votre condition de victoire");
            Bataille.affiche("1 - Les cartes gagnées sont mises de côté et comptées comme des points. Le jeu se termine lorsque les joueurs n'ont plus de cartes en main.");
            Bataille.affiche("2 - Les cartes gagnées s'ajoutent à la main du gagnant de la main. Le jeu se termine lorsqu'un des joueurs détient toutes les cartes (non disponible en mode automatique)");
            
            while(c!=1 && c!=2){
                c=Bataille.test_int(3);
            }
            
        }else{
            c=1;
        }
        return c;
    
    }
    
    private int choisir_menu(){
        int choix=4;
        Bataille.affiche("\n");
        Bataille.affiche("Souhaitez vous : ");
        Bataille.affiche("1 - Tirer une nouvelle carte");
        Bataille.affiche("2 - Abandonner la partie");
        Bataille.affiche("3 - Connaitre le nombre de cartes des joueurs");
        while(choix!=1 && choix!=2 && choix!=3){
            choix=Bataille.test_int(4);
        }
        
        return choix;
    }
    private void joue_manche(){
        Bataille.affiche("\n ----------------- Manche\n");
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

    private char demande_mode_de_jeu(char mode_automatique) {
        Bataille.affiche("Souhaitez-vous jouer en mode automatique ? O/N");
        char[] valeurs_ok={'O', 'N'};
        mode_automatique=Bataille.test_char(valeurs_ok, '0'); 
       
        return mode_automatique;
    }

    private void demande_enregistrement() {
        char enregistrer='A';
        Bataille.affiche("Souhaitez-vous enregistrer ces pseudos ? O/N");
        char[] valeurs_ok={'O', 'N'};
        enregistrer=Bataille.test_char(valeurs_ok, '0'); 
        if(enregistrer=='O'){
            EcrireFichier.ecrire_fichier(this.pseudos);
        }
    }

    private boolean jeu_continu() {
        boolean continu=true;
        if(this.joueur_1.affiche_nombre_cartes_restantes()<=0){
            continu=false;
        }
        if(this.joueur_2.affiche_nombre_cartes_restantes() <=0){
            continu=false;
        }
        if(choix_menu!=1){
            continu=false;
        }
        return continu;
    }

  
}
