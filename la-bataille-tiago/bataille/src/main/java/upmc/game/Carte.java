package upmc.game;

public class Carte {
    
    
    //Atributs
    private String couleur;
    private int valeur;

   
    
    
    //Constructeur
    public Carte(int coul, int valeur) {
        this.valeur = valeur;
        switch (coul) {
            case 1 : couleur = "carreau"; break;
            case 2 : couleur = "pique"; break;
            case 3 : couleur = "coeur"; break;
            case 4 : couleur = "trefle"; break;
        }
    }
    
    
    
    //Accesseurs
    public String getCouleur(){
        return couleur+valeur;
    }
    
    
    public int getValeur() {
        return valeur;
    }
    
    
   
    public boolean comparateur(Carte c2){
        Carte c1 = this;
        if(c1.valeur > c2.valeur){
            return true;
        }
        return false;
   }
   
   public int comparateurvaleur(Carte c2){
        Carte c1 = this;
        if(c1.valeur == c2.valeur){
            return 1;
        }
        
        else if (c1.valeur > c2.valeur) {
            return 2;
        }
        else {
            return 3;
        }
       
   }
}

