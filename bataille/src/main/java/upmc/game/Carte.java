package upmc.game;

public class Carte {
    private int color;
    private int value;
    private int temp;
    private String val;
    private String card;
    public Carte(int couleur, int valeur){
        color=couleur;
        value=valeur;
    }
    public String toString(){
        if (value<9){
            temp=value;
            temp+=2;
            val=""+temp;
        }else if (value==9){
            val="Valet";
        }else if (value==10){
            val="Dame";
        }else if (value==11){
            val="Roi";
        }else if (value==12){
            val="As";
        }
        card = val+" de ";
        if(color==0) card+="coeur";
        if(color==1) card+="carreau";
        if(color==2) card+="pique";
        if(color==3) card+="trèfle";
        return card;
    }
    
    public int valeur(){
        return value;
    }
    
    public boolean compare(int valAComparer){
        return true;
    }

}
