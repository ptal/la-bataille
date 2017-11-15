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

import java.util.Scanner;

public class Bataille
{
  public static void main(String[] args)
  {
        char rejouer='O';
        
        while(rejouer== 'O'){
            
            Partie partie = new Partie();
            
            rejouer= ' ';
            
            affiche("Souhaitez vous rejouer ? O/N");
            
            char[] valeurs_ok={'O', 'N'};
            rejouer=test_char(valeurs_ok, '0');
            
        }
        affiche("A la prochaine !");       
    }
    
    public static char test_char(char[] valeurs_ok, char valeur_defaut){
        Scanner sc=new Scanner(System.in);
        
        char res=valeur_defaut;
        while(res==valeur_defaut){
            String test=sc.nextLine();
            if(test.equals("")){
                res=valeur_defaut;
                System.out.println("Vous devez rentrer O ou N.");
            }else{
                test=test.toUpperCase();
                res=test.charAt(0); 
            }
            for(int i=0;i<valeurs_ok.length; i++){
                if(res==valeurs_ok[i]){
                    res=valeur_defaut;
                }
            }
        }
        
        return res;    
    }
    
    public static void affiche(String str){
        System.out.println(str);
    }

    static String test_string() {
        Scanner sc=new Scanner(System.in);
        String str="";
        String test="";
        
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
            affiche("Veuillez entrer un nom valide");
        }
        return str;
    }

    static int test_int(int defaut) {
        int i=defaut;
        Scanner sc=new Scanner(System.in);
        
        if(sc.hasNextInt()){
            i = sc.nextInt();
        }else{
            i=defaut; 
            affiche("Veuillez entrer un chiffre valide");
        }
        sc.nextLine();
        return i;
    }
}
