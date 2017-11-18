package upmc.game;
public class Carte {
    
    private String color;
    private String valor; // string car 01  
    
    public Carte(String color, String valor){
        this.color = color;
        this.valor = valor;
    }  
    
    public String toString(){
        return valor + " " + color;
    }
}

