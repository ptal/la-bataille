package upmc.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to run the game and its methods
 * @author Nicolas
 */
public class Jeu {
    //attributs
    private Scanner scan = new Scanner(System.in);
    private int modeJeu = 0;
    private int resultatCombat = 0;
    private boolean bataille = false;
    private Deck deckTempo = new Deck(false);
    private Deck deck = new Deck(true);
    private Joueur joueur1 = new Joueur("Default1");
    private Joueur joueur2 = new Joueur("Default2");
    private Carte carte1;
    private Carte carte2;
    
    /**
     * Explicite
     */
    public void initialisation() {
        //Initialisation du jeu
        msgInitJeuEtMelange(deck);
        //Choix du mode de jeu
        modeJeu = choixModeJeu(modeJeu);
        //Choix du nom des joueurs
        choixPseudoJoueur(joueur1, joueur2, modeJeu);
        //Distribution égale des cartes entre les deux joueurs
        distributionCartes(joueur1, joueur2, deck);
    }
    
    /**
     * Fais tourner le jeu
     */
    public void jouer() {
        //Boucle principale
        while(!joueur1.deckVide() && !joueur2.deckVide() && !joueur1.boolAbandon() && !joueur2.boolAbandon()) {
            piocheCartes();
            //Si on est pas en mode de jeu rapide
            if(modeJeu != 3) {
                jeuNormal();
            }
            else {
                jeuRapide();
            }
        }
        
        //Affiche le gagnant
        afficheGagnant(joueur1, joueur2);
    }
    
    /**
     * Pioche une carte pour chaque joueur et les ajoutent à un deck temporaire
     */
    public void piocheCartes() {
        carte1 = joueur1.tireCarte();
        deckTempo.ajouterCarte(carte1);
        carte2 = joueur2.tireCarte();
        deckTempo.ajouterCarte(carte2);
    }
    
    /**
     * Mode de jeu normal
     */
    public void jeuNormal() {
        compareCartesNormal();
        switchResultatNormal();
        
        //si bataille on passe cette etape
        if(!bataille) {
            //Demande si les joueurs veulent continuer, abandonner ou afficher des stats
            choixSuiteJoueur(joueur1, joueur2);
            //Si c'est un mode de jeu a 2 joueurs
            if(modeJeu == 1 && !joueur1.boolAbandon()) {
                choixSuiteJoueur(joueur2, joueur1);
            }
        }
    }
    
    /**
     * Mode de jeu rapide
     */
    public void jeuRapide() {
        resultatCombat = carte1.compare(carte2);
        switchResultatRapide();
        
        //Si bataille
        if(bataille)
            System.out.println("Bataille !");
        
        System.out.println(joueur1.toString()+"\n"+joueur2.toString());
    }
    
    /**
     * Explicite, mode de jeu normal
     */
    public void compareCartesNormal() {
        if(!bataille)
            System.out.println("\n------");
        System.out.println(carte1.toString()+"("+joueur1.afficheNom()+") VS "+carte2.toString()+"("+joueur2.afficheNom()+")");
        resultatCombat = carte1.compare(carte2);
    }
    
    /**
     * Affiche le resultat de la manche et ajoute le score et les cartes au gagnant
     */
    public void switchResultatNormal() {
        switch (resultatCombat) {
            case 1:
                actionMancheNormal(joueur1);
                break;
            case -1:
                actionMancheNormal(joueur2);
                break;
            default:
                actionBatailleNormal();
                break;
        }
    }
    
    /**
     * Ajoute le score et les cartes au gagnant
     */
    public void switchResultatRapide() {
        switch (resultatCombat) {
            case 1:
                actionMancheRapide(joueur1);
                break;
            case -1:
                actionMancheRapide(joueur2);
                break;
            default:
                actionBatailleRapide();
                break;
        }
    }
    
    /**
     * Explicite, mode normal
     */
    public void actionMancheNormal(Joueur joueur) {
        System.out.println(joueur.afficheNom()+" gagne le combat\n");
        joueur.gagnePoint();
        //Le joueur gagne les cartes
        while(!deckTempo.estVide())
            joueur.ajouterCarte(deckTempo.derniereCarte());
        bataille = false;
    }
    
    /**
     * Explicite, mode rapide
     */
    public void actionMancheRapide(Joueur joueur) {
        joueur.gagnePoint();
        //Le joueur gagne les cartes
        while(!deckTempo.estVide())
            joueur.ajouterCarte(deckTempo.derniereCarte());
        bataille = false;
    }
    
    /**
     * Action si un cas de bataille apparait, mode normal
     */
    public void actionBatailleNormal() {
        System.out.println("Bataille !\n");
        //Les deux joueurs posent une carte en plus et on revient au debut de la boucle
        //avec cette fois plus de cartes dans le deck tempo jusqu'a qu'un joueur gagne
        if(!joueur1.deckVide())
            deckTempo.ajouterCarte(joueur1.tireCarte());
        if(!joueur2.deckVide())
            deckTempo.ajouterCarte(joueur2.tireCarte());
        bataille = true;
    }
    
    /**
     * Action si un cas de bataille apparait, mode rapide
     */
    public void actionBatailleRapide() {
        if(!joueur1.deckVide())
            deckTempo.ajouterCarte(joueur1.tireCarte());
        if(!joueur2.deckVide())
            deckTempo.ajouterCarte(joueur2.tireCarte());
        bataille = true;
    }
    
    /**
     * Affiche le message d'explication au debut et melange le deck de cartes
     */
    public static void msgInitJeuEtMelange(Deck deck) {
        System.out.println("Jeu de la bataille!\n");
        System.out.println("Le jeu se joue en tour durant lesquels les deux joueurs jouent leurs cartes en meme temps.");
        System.out.println("Quand un des deux joueurs n'a plus de cartes ou se rend, le jeu s'arrete.");
        deck.melange();
    }
    
    /**
     * Demande recursivement au joueur le mode de jeu qu'il veut
     */
    public static int choixModeJeu(int modeJeu) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nChoisissez votre mode de jeu parmis les 2 suivants :");
        System.out.println(" 1. Deux joueurs\n 2. Contre IA\n 3. Mode rapide contre IA");
        try {
            System.out.println("Votre choix : ");
            modeJeu = scan.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.print("(!) Choisissez un nombre !\n");
            scan.nextLine();
        }
        
        if(modeJeu != 1 && modeJeu != 2 && modeJeu != 3)
            modeJeu = choixModeJeu(modeJeu);
        
        return modeJeu;
    }
    
    /**
     * Récupère le pseudo des joueurs en passant par un menu et les attribue
     */
    public static void choixPseudoJoueur(Joueur joueur1, Joueur joueur2, int modeJeu) {
        MenuPseudo menu = new MenuPseudo();
        LecturePseudo lecturePseudo;
        ArrayList<String> pseudos;
        
        lecturePseudo = menu.modeLecturePseudo();
        if(modeJeu == 1)
            pseudos = lecturePseudo.lirePseudo(false); //Sans IA
        else
            pseudos = lecturePseudo.lirePseudo(true); //Avec IA
        attribuePseudo(joueur1, joueur2, pseudos);
    }
    
    /**
     * Distribue toute les cartes d'un deck aux deux joueurs de maniere egale
     */
    public static void distributionCartes(Joueur joueur1, Joueur joueur2, Deck deck) {
        while(!deck.estVide()) {
            if(deck.nbCartes()%2==0)
                joueur1.ajouterCarte(deck.derniereCarte());
            else
                joueur2.ajouterCarte(deck.derniereCarte());
        }
    }
    
    /**
     * Demande au joueur ce qu'il veut faire pour la suite et agit en consequence
     */
    public static void choixSuiteJoueur(Joueur joueur, Joueur autreJoueur) {
        Scanner scanChoix = new Scanner(System.in);
        String choix = "undefined";
        
        System.out.println("Chaque joueur peut maintenant quoi faire :");
        System.out.println(" - entree : continuer\n - q+entree : abandonner\n - s+entree : afficher ses stats");

        while(!choix.equals("") && !choix.equals("q")) {
            System.out.println(joueur.afficheNom()+" : Que voulez-vous faire ? ");
            choix = scanChoix.nextLine();

            System.out.println("Choix : "+choix);
            //abandonne
            if(choix.equals("q")) {
                joueur.abandonne();
                System.out.println("Le joueur "+joueur.afficheNom()+" abandonne !");
            }
            //Affiche les stats
            else if(choix.equals("s")) {
                System.out.println(joueur.toString());
                System.out.println(autreJoueur.toString());
            }
        }
    }
    
    /**
     * Attribue les noms aux différents joueurs
     */
    public static void attribuePseudo(Joueur joueur1, Joueur joueur2, ArrayList<String> tabPseudo) {
        joueur1.setNom(tabPseudo.get(0));
        joueur2.setNom(tabPseudo.get(1));
    }

    /**
     * Affiche le gagnant
     */
    public static void afficheGagnant(Joueur joueur1, Joueur joueur2) {
        //Si abandon
        if(joueur1.boolAbandon())
            System.out.println(joueur1.afficheNom()+" a perdu par abandon ! "+joueur2.afficheNom()+" a gagné !");
        else if(joueur2.boolAbandon())
            System.out.println(joueur2.afficheNom()+" a perdu par abandon ! "+joueur1.afficheNom()+" a gagné !");
        //Si plus de cartes
        else if(joueur1.deckVide())
            System.out.println(joueur2.afficheNom()+" a gagné car, "+joueur1.afficheNom()+" n'a plus de cartes !");
        else if(joueur2.deckVide())
            System.out.println(joueur1.afficheNom()+" a gagné car, "+joueur2.afficheNom()+" n'a plus de cartes !");

        System.out.println("===================");
        System.out.println("Score final : ");
        System.out.println(joueur1.toString()+" | "+joueur2.toString());
        System.out.println("===================");
    }
}
