package upmc.game;

public class Carte {
    private int color;
    private int value;
    private String nameCard;
    
    //Creation de la carte
    public Carte( int val, int couleur ) {
    	 color = couleur;							
         value = val;									//Attribution des valeurs
         
    	 if( value < 9 ) {							
    		 nameCard = String.valueOf( value + 2 );   	//0 à 8 => 2 à 10
         } else if( value == 9 ){
        	 nameCard="Valet";					  	//9 => Valet
         }else if (value==10){
        	 nameCard="Dame";						//10 => Dame
         }else if (value==11){
        	 nameCard="Roi";						//11 => Roi
         }else if (value==12){
        	 nameCard="As";							//12 => As
         }else if (value==13) {
        	 nameCard="Joker";						//13 => Joker
         }
         if (color != 5) nameCard += " de ";						//Attribution des couleurs
         if(color==0) nameCard+="coeur";
         if(color==1) nameCard+="carreau";
         if(color==2) nameCard+="pique";
         if(color==3) nameCard+="trefle";
    	
    }
    
    //Affichage du nom de la carte
    public String toString(){
        return nameCard;						
    }
    
    //Comparaison des cartes
    public int compare(Carte CardToCompare){
        if (value>CardToCompare.value) return 1;
        if (value<CardToCompare.value) return 2;
        return 0;
    }
}
