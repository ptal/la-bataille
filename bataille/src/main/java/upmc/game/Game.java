package upmc.game;

import java.util.Scanner;

public class Game {
	
	private Joueur J1;
	private Joueur J2;
	
	private Joueur winner;
	private boolean win;
	private boolean joker = false;
	public Scanner console = new Scanner( System.in );
	
	private int nbCartes;

	private Paquet jeuDeCarte = new Paquet();
	
	public Game( Joueur Player1, Joueur Player2, int nombreC, String modeplay ) {
		
		//Assignation des joueurs et du nombre de carte
		J1 = Player1;
		J2 = Player2;
		if( nombreC == 54 ) {
			
			joker = true;
			nombreC -= 2 ;
			
		}
		nbCartes = nombreC;
		
		//Creation du paquet de carte
		
        for( int i = 0 ; i < 4 ; i++ ) {							//4 Couleurs
        	
            for( int j = 13 - ( nbCartes / 4 ) ; j < 13 ; j++ ) { 		//13 cartes dans un paquet de 52, 8 dans un de 32
            	
                jeuDeCarte.addCard( new Carte( j, i ) );
                
            }
        }
        
        if( joker ) {												//2 Joker du paquet de 54
        	jeuDeCarte.addCard(new Carte(13,5));
        	jeuDeCarte.addCard(new Carte(13,5));
        	nbCartes += 2;
        }
		
		win = false;
		
		//Creation des decks joueur
		//Pour reinitialiser les mains des joueurs en cas de restart
		J1.createPaquet();
		J2.createPaquet();

        
        //Melange des cartes
		jeuDeCarte.melange();
		
		
		//Attribution des cartes en boucle inversee (plus rapide)
		for( int i = nbCartes - 1 ; i >= 0 ; i-- ) {
			
			if( i > ( nbCartes / 2 -1 ) ) {
				
				J1.deck.addCard( jeuDeCarte.getCard( i ) );
				
			} else {
				
				J2.deck.addCard( jeuDeCarte.getCard( i ) );
				
			}
		}
		
		System.out.println( "Appuyer sur entree pour retourner une carte chacun ('exit' pour quitter le jeu)" );
		
		if( modeplay == "points" ) {
			modePts();
		} else {
			modeCartes();
		}
		
		System.out.print( "\nET LE GAGNANT EST : " + winner );
		if ( modeplay == "points" ) System.out.print( " avec " + winner.nbPts() + " points" );
		System.out.println( " !!!" );
		
	}
	
	
	//Tour de jeu mode points
	
	private void modePts() {
		do {
			System.out.flush();
			if ( console.nextLine().equals( "exit" ) )	System.exit( 0 );
			System.out.println( J1 + "(" + J1.nbPts() + "pts) : " + J1.deck.getCard( 0 ) + " VS " + J2.deck.getCard( 0 ) + " : " + J2 + "(" + J2.nbPts() + "pts)" );
			if( J1.deck.getCard( 0 ).compare( J2.deck.getCard( 0 ) ) != 0){
				switch( J1.deck.getCard( 0 ).compare( J2.deck.getCard( 0 ) ) ) {
					case 1:
						J1.addPts();
						winner = J1;
						break;
					case 2:
						J2.addPts();
						winner = J2;
						break;
				}
				System.out.println( winner + " gagne 1 point -> total:" + winner.nbPts() );
			}else{
				System.out.println( "Bataille ! 2 points chacun" );
				J1.addPts(); J1.addPts();
				J2.addPts(); J2.addPts();
			}
			J1.deck.removeCard( J1.deck.getCard( 0 ) );
			J2.deck.removeCard( J2.deck.getCard( 0 ) );
			if( J1.deck.nbCard() == 0 ) {
				win=true;
				winner = new Joueur( "Egalite parfaite ! Incroyable" );
				if( J1.nbPts() > J2.nbPts() ) winner = J1;
				if( J2.nbPts() > J1.nbPts() ) winner = J2;
			}
		}
		while ( !win );
	}
	
	
	
	//Tour de jeu mode carte
	private void modeCartes() {
		do {
			//Pour des raisons de facilite, les paquets sont melanges a chaque tirage
			J1.deck.melange();
			J2.deck.melange();
			
			System.out.flush();
			if ( console.nextLine().equals( "exit" ) )	System.exit( 0 );
			System.out.println( J1 + "(" + J1.deck.nbCard() + ") : " + J1.deck.getCard( 0 ) + " VS " + J2.deck.getCard( 0 ) + " : " + J2 + "(" + J2.deck.nbCard() + ")" );
			
			//Resultat de manche
			resultCarte( J1.deck.getCard( 0 ).compare( J2.deck.getCard( 0 ) ) );
			if( J1.deck.nbCard() == 0 ) {
				winner = J2;
				win = true;
			}
			if( J2.deck.nbCard() == 0 ) {
				winner = J1;
				win = true;
			}
		}
		while( !win );
	}
	
	
	//Algo du tour pour mode carte
	private void resultCarte( int res ) {
		switch( res ) {
			//J1 gagne
			case 1:
				System.out.println( J1 + "(" + ( J1.deck.nbCard() + 1 ) + ") remporte la carte de " + J2 + "(" + ( J2.deck.nbCard() - 1 ) + ") !\n" );
				J1.deck.addCard( J2.deck.getCard( 0 ) );
				J2.deck.removeCard( J2.deck.getCard( 0 ) );
				break;
			//J2 gagne
			case 2:
				System.out.println( J1 + "(" + ( J1.deck.nbCard() - 1 ) + ") offre sa carte a  " + J2 + "(" + ( J2.deck.nbCard() + 1 ) + ") !\n" );
				J2.deck.addCard( J1.deck.getCard( 0 ) );
				J1.deck.removeCard( J1.deck.getCard( 0 ) );
				break;
			//Bataille
			case 0:
				int i = 0;
				while( J1.deck.getCard( i ).compare( J2.deck.getCard( i ) ) == 0 ) {
					if( J1.deck.nbCard() < i + 2 ) {
						System.out.println( J1 + "n'a plus assez de cartes" );
						winner=J2;
						win=true;
						return;
					}
					if( J1.deck.nbCard() < i + 2 ) {
						System.out.println( J2 + "n'a plus assez de cartes" );
						winner=J1;
						win=true;
						return;
					}
					System.out.println( "BATAILLE !\n" + J1 + "(" + J1.deck.nbCard() + ") : Carte cachee --- Carte cachee : " + J2 + "(" + J2.deck.nbCard() + ")" );
					System.out.println( J1 + "(" + J1.deck.nbCard() + ") : " + J1.deck.getCard( i+2 ) + " VS " + J2.deck.getCard( i+2 ) + " : " + J2 + "(" + J2.deck.nbCard() + ")" );
					i += 2;
				}
				if( J1.deck.getCard( i ).compare( J2.deck.getCard( i ) ) == 1 ){
					winner = J1;
					for( int j = 0; j <= i; j++ ) {
						J1.deck.addCard( J2.deck.getCard( j ) );
						J2.deck.removeCard( J2.deck.getCard( j ) );
					}
				}else{
					winner = J2;
					for( int j = 0; j <= i; j++ ) {
						J2.deck.addCard( J1.deck.getCard( j ) );
						J1.deck.removeCard( J1.deck.getCard( j ) );
					}
				}
				System.out.println( winner + " gagne cette petite bataille et remporte " + ( i + 1 ) + " cartes !\n" );
				break;
		}
	}
}
