// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Bataille
{
  public static void main(String[] args)
  {
     
      
    // Création joueur N°1
    System.out.print("Veuillez entrer un nom pour le Joueur 1: ");
    System.out.flush();
    Scanner console = new Scanner(System.in);
    String j1 = console.nextLine();
        
    Joueur joueur1 = new Joueur (j1);
       
    // Création joueur N°2
    System.out.print("Veuillez entrer un nom pour le Joueur 2: ");
    System.out.flush();
    new Scanner(System.in);
    String j2 = console.nextLine();
    
    Joueur joueur2 = new Joueur (j2);
  
    //Tableau de carte
    ArrayList<Carte> jeu = new ArrayList<Carte>();
    
    //Création d'une carte
    Carte c = new Carte("carreau",3);
    System.out.println("C'est le jeu de la bataille!\n");
    
    
    for(int i = 0; i < 52; i++){
            Carte c1 = joueur1.tireCarte(c); //Joueur 1 tire une carte
            Carte c2 = joueur2.tireCarte(c); //Joueur 2 tire une carte

            System.out.println(c1.toString());
            System.out.println(c2.toString());

            if(c1.Comparateur(c2)){ //Comparaison des deux cartes
                joueur1.gagnePoint(); // Joueur 1 gagne le point
            }
            
            else{
                joueur2.gagnePoint(); //Jueur 2 gagne le point
            }
        }
        System.out.println("joueur1: "+joueur1.getPoint());
        System.out.println("joueur2: "+joueur2.getPoint());
    }
    
   
    
  }


