package upmc.game;

import java.util.Scanner;

public class Bataille{
	
	public static Scanner console = new Scanner( System.in );
	
	private static Joueur J1;
	private static Joueur J2;
	
	private static int choice;

	private static int nCartes = 52;
	private static String mode = "points";
	

    public static void main( String[] args ) {
    	
        System.out.println( "Bienvenue sur ce jeu de la bataille !\n" );
        
        //Creation des joueurs
        initPlayers();
        
        //Menu du jeu
        initGame();
        
    }

    //Initialisation des joueurs
	private static void initPlayers() {
		
        System.out.print( "   *~* Pseudo du 1er joueur *~*" );
        J1 = new Joueur( MenuPseudo.modeLecturePseudo().lirePseudo() );
        System.out.println();
        System.out.print( "   *~* Pseudo du 2nd joueur *~*" );
        J2 = new Joueur( MenuPseudo.modeLecturePseudo().lirePseudo() );
        	
	}
	
	//Options de la partie
	private static void initGame() {
				
		System.out.println();
		System.out.println( "Joueurs : "+J1+ " et "+J2+". Parametres actuels : "+nCartes+" cartes, vainqueur par "+mode);
		
		System.out.println( "Que voulez-vous faire ?   Jouer :1   Parametres :2   Quitter :3" );
		System.out.flush();
		choice = choix(3);
		
		switch ( choice ) {
		
			//Debuter le jeu
			default:
				startGame();
				break;
		
			//Changer parametres
			case 2 :
				System.out.println( "Que voulez-vous modifier ?   Nb de cartes :1   Noms des joueurs :2   Mode de jeu :3   Retour :4" );
				System.out.flush();
				choice = choix(4);
				
				switch ( choice ) {
				
					//Changer nombre de cartes
					case 1 :
						System.out.println( "Jeu de combien de cartes ?   32 cartes :1   52 cartes :2   54 cartes :3" );
						System.out.flush();
						choice = choix(3);
						
						if ( choice == 1 ) nCartes = 32;
						else if (choice == 3 ) nCartes = 54;
						else nCartes =52;
						
						initGame();						
						break;
						
					//Changer de joueurs
					case 2 :
						initPlayers();
						initGame();	
						break;
						
					case 3 :
						System.out.println( "Comment souhaitez-vous gagner ?   Nb de cartes (lent) :1   Nb de points (rapide) :2" );
						System.out.flush();
						choice = choix(2);
						
						if ( choice == 1 ) mode = "cartes";
						else mode = "points";
						
						initGame();						
						break;
						
					//Retour menu
					default:
						initGame();
						break;				
				}
				
			//Quitter le jeu	
			case 3 :
				System.exit(0);
				break;
				
		}		
	}
	
	private static void startGame() {
        //Creation de la partie
        new Game( J1, J2, nCartes, mode );        

        //Restart
        System.out.println( "Voulez-vous rejouez ?   Oui :1   Quitter :2   Retour menu :3" );
        System.out.flush();
        choice = choix(3);
        switch ( choice ) {
        	case 1:
        		startGame();
        		break;
        	case 3:
        		initGame();
        		break;
        	default:
        		break;
        		
        }
	}
	
	//Boucle tant que pas de reponse valable
	private static int choix(int nbChoix) {
		int choix;
		do {
			try {
				choix = Integer.parseInt( console.nextLine() );
			} catch( Exception except ) {
				choix = 0;
			}
		}
		while( !( ( choix < nbChoix+1 ) && ( choix > 0 ) ) );		
		return choix;
	}
	
	
	
	//TODO : A faire marcher
	//Nettoyage de la console
/*	private static void clearScreen() {
		
		try {
	
			//Win7 et antérieur
			if( System.getProperty( "os.name" ).startsWith( "Windows" ) ) {
				
				Runtime.getRuntime().exec( "cls" );
				
			//Unix
			} else {
		
			    Runtime.getRuntime().exec( "clear" );
			    
			}
			
		//A l'arrache
		} catch( Exception except ) {

			for( int i = 0 ; i < 30 ; i++ ) System.out.println(); 
			System.out.flush();
			
		}
	}*/
}
