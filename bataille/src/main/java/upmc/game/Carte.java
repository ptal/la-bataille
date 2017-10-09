/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author licence
 */
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

