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
    Scanner sc=new Scanner(System.in);
        char rejouer='O';
        char mode_automatique='A';
        int condition_de_victoire=3;
        
        while(rejouer == 'O'){
            ArrayList cartes_a_gagner= new ArrayList();
            rejouer = ' ';
  
        
            System.out.println("------------------------ LE JEU DE LA BATAILLE -------------------------------\n");
            
            while(mode_automatique!='O' && mode_automatique!='N' ){
                System.out.println("Souhaitez-vous jouer en mode automatique ? O/N");
                mode_automatique=test_scanner(sc); 
            }
            
            if(mode_automatique=='N'){
                while(condition_de_victoire!=1 && condition_de_victoire!=2){
                    System.out.println("Choisissez votre condition de victoire");
                    System.out.println("1 - Les cartes gagnées sont mises de côté et comptées comme des points. Le jeu se termine lorsque les joueurs n'ont plus de cartes en main.");
                    System.out.println("2 - Les cartes gagnées s'ajoutent à la main du gagnant de la main. Le jeu se termine lorsqu'un des joueurs détient toutes les cartes (non disponible en mode automatique)");
                    if(sc.hasNextInt()){
                        condition_de_victoire=sc.nextInt(); 
                    }
                    
                    sc.nextLine();
                }
            }else{
                condition_de_victoire=1;
            }
            
            
            
            String nom_joueur_1 = nom_joueur(sc);
            System.out.println("");
            String nom_joueur_2 = nom_joueur(sc);
            System.out.println("");

            ArrayList paquet = generer_paquet();
            paquet = melanger_paquet( paquet );

            Joueur joueur_1 = new Joueur(0, paquet, nom_joueur_1);
            Joueur joueur_2 = new Joueur(1, paquet, nom_joueur_2);

            int continuer =1;
             
            while((joueur_1.get_nombre_cartes_restantes() >0 || joueur_2.get_nombre_cartes_restantes() >0 ) && continuer == 1){
                    if(mode_automatique=='N'){
                        continuer =3;
                    }
                    while(continuer!= 1 && continuer !=2){
                        System.out.println("Souhaitez vous : ");
                        System.out.println("1 - Tirer une nouvelle carte");
                        System.out.println("2 - Abandonner la partie");
                        System.out.println("3 - Connaitre le nombre de cartes des joueurs");
                            
                        continuer = sc.nextInt();
                        sc.nextLine();
                        if(continuer==3){
                            System.out.println(joueur_1.compare_points(joueur_2, condition_de_victoire));
                        }
                    }
                    if(continuer==1){
                        System.out.println(" ");
                        Carte c1 = joueur_1.joue();
                        Carte c2 = joueur_2.joue();

                        String resultat = c1.compare(c2, joueur_1, joueur_2, cartes_a_gagner, condition_de_victoire);
                        System.out.println(resultat);

                        if(resultat.equals("BATAILLE !")){
                            cartes_a_gagner.add(c1);
                            cartes_a_gagner.add(c2);
                        }else{

                            cartes_a_gagner.clear();
                        }
                    }
                    
                        
            }
            
            System.out.println(" ");
            System.out.println(joueur_1.compare_points(joueur_2, condition_de_victoire));
            
            
            while(rejouer!='O' && rejouer!='N'){
                
                System.out.println("Souhaitez vous rejouer ? O/N");
                rejouer=test_scanner(sc);
                mode_automatique=' ';
                condition_de_victoire=3;
            }
            
            
            
        }  
        
        System.out.println("A la prochaine !");
        
    }
    
    public static char test_scanner(Scanner sc){
                String test=sc.nextLine();
                char res=' ';
                if(test.equals("")){
                    res='B';
                    System.out.println("Vous devez rentrer O ou N.");
                }else{
                    test=test.toUpperCase();
                    res=test.charAt(0); 
                }
                return res;    
    }
    
    public static ArrayList generer_paquet(){
        ArrayList paquet = new ArrayList();
        
        int numero_carte=2;
        int nb_cartes_par_couleur=52/4;
        String couleur="trèfle";
        
        for(int i=0; i<52; i++){
            
            if(i==nb_cartes_par_couleur){
                numero_carte=2;
                couleur="pique";
            }
            if(i==nb_cartes_par_couleur*2){
                numero_carte=2;
                couleur="coeur";
            }
            if(i==nb_cartes_par_couleur*3){
                numero_carte=2;
                couleur="carreau";
            }
           
            Carte c=new Carte(numero_carte, couleur);
            paquet.add(c);
            
            numero_carte++;
   
        }
        System.out.println("Création d'un paquet de 52 cartes");
        return paquet;
    }
    
    public static ArrayList melanger_paquet(ArrayList pPaquet){
        
        ArrayList paquet_melange=new ArrayList();
        while(pPaquet.size()>0){
            double random=Math.random()*pPaquet.size();
            int index=(int)random;
            
            paquet_melange.add(pPaquet.get(index));
            pPaquet.remove(index);
            
        }
            
        System.out.println("On mélange !");
        return paquet_melange;
    }
    
    public static String nom_joueur(Scanner sc){
        String str="";
        String test="";
        
        while(str.equals("") || str.equals(null)|| str.length()>40){
            System.out.println("Entrez le nom d'un joueur (40 caractères maximum) :");
            test=sc.nextLine();
            if(!test.equals("")){ // Permet d'éviter les fantômes
                while(test.charAt(0)==' ' && test.length()>1){
                    test=test.substring(1);
                }
            }
            if(!test.equals(" ")){
                str=test;
                      
            }else{
                str="";
            }
        }
        System.out.println("Bienvenue "+str+" !");
        return str;
    
   }
}
