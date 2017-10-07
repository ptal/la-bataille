package upmc.game;

public class Carte {
    
    
    //Atributs
    public static String couleur[] = {"pique","carreau","trefle", "coeur"};
    private String coul;
    public static int valeur[] = {11, 12, 5, 6};
    private int val;
   
    //Constructeur
    public Carte(String couleur, int valeur) {
        this.coul = couleur;
        this.val = valeur;
    }
    
    //Accesseurs
    public String getCouleur(){
        return coul;
    }
    
    
    public int getValeur() {
        return val;
    }
    
    //Comparateur
   public boolean Comparateur(Carte c2){
        Carte c1 = this;
        if(c1.val > c2.val){
            return true;
        }
        return false;
   }
}

