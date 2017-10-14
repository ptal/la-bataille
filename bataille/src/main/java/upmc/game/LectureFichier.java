package upmc.game;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class LectureFichier implements LecturePseudo {
	
	public static Scanner console = new Scanner( System.in );
	
	private BufferedReader buffer;
	
	public ArrayList<String> pseudoList = new ArrayList<>();

	public LectureFichier() {
		
	}
	
	public String lirePseudo() {
		
		//Choix du fichier
		
		System.out.println( "Quel fichier ouvrir ? (dossier : /pseudos)" );
		
		File[] Fichiers;
		try {
			Fichiers = listFiles();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		
		//Sécurité
		
		int choix;
		do {
			try {
				choix = Integer.parseInt( console.nextLine() );
			} catch( Exception except ) {
				choix = -1;
			}
		}
		while( ( choix >= Fichiers.length ) || ( choix < 0 ) );
		
		//Choix du pseudo
		
		System.out.println( "Que choisissez vous ?" );
		int ligne = listPseudo( Fichiers, choix );
		
		do {
			try {
				choix = Integer.parseInt( console.nextLine() );
			} catch( Exception except ) {
				choix = -1;
			}
		}
		while( ( choix > ligne ) || ( choix < 0 ) );
		
		
		//Selectionne le pseudo
		if( pseudoList.size() > 0 ) {
			return pseudoList.get(choix);
		}
		
		return "";		
	}
	
	//Fonction pour lister le dossier
	private File[] listFiles() throws IOException {
	    File directory = new File( System.getProperty( "user.dir" ) + "/pseudos" );
	    File[] list = directory.listFiles();
	    
	    if( ( list != null ) && ( list.length > 0 ) ) {
	    	
	    	for( int i = 0 ; i < list.length ; i++ ) {
	    		
		    	System.out.println( i + ": " + list[i].getName() );
		    }
	    } else {
	    	
	    //Si pas de fichiers, on en créé un vide
	        Writer output = null;
	        File file = new File(directory.getAbsolutePath() + "/ListePseudo.txt");
	        output = new BufferedWriter(new FileWriter(file));
	        output.close();
	        
	        list = directory.listFiles();
	        System.out.println( "0: ListePseudo.txt" );
	    }
	    return list;
	}
	
	//Fonction pour lire le fichier txt
	private int listPseudo( File[] fichiers, int n ) {
		int ligne = 0;
		
		try {
			
			buffer = new BufferedReader( new FileReader( fichiers[n] ) );
			String line;
			
			while( ( line = buffer.readLine() ) != null )
			{
				  System.out.println ( ligne + ": " + line );
				  ligne++;
				  pseudoList.add(line.substring(0));
			}
			buffer.close();
			
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
		//par defaut si pas de pseudo ecrit
		if ( ligne == 0 ) {
			System.out.println( "0:" );
		}
		
		//On retourne le nombre de ligne
		return ligne;
		

	}
}
