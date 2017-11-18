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
                erreur_entree();
            }else{
                res=traitement_char(test); 
            }
            boolean ok=test_char_correct(res, valeurs_ok);
            if(!ok){
                res=valeur_defaut;
            }
        }
        
        return res;    
    }
    
    public static void affiche(String str){
        System.out.println(str);
    }

    public static String test_string() {
        Scanner sc=new Scanner(System.in);
        String str="";
        String test="";
        
        test=sc.nextLine();
        if(!test.equals("")){ // Permet d'éviter les fantômes
            test=traitement_string(test);
        }
        if(!test.equals(" ")){
            str=test;     
        }else{
            str="";
            erreur_entree();
        }
        return str;
    }

    public static int test_int(int defaut) {
        int i=defaut;
        Scanner sc=new Scanner(System.in);
        
        if(sc.hasNextInt()){
            i = sc.nextInt();
        }else{
            i=defaut; 
            erreur_entree();
        }
        sc.nextLine();
        return i;
    }

    private static void erreur_entree() {
        affiche("Vous devez une valeur valide.");
    }

    private static String traitement_string(String test) {
        while(test.charAt(0)==' ' && test.length()>1){
            test=test.substring(1);
        }
        return test;
    }

    private static char traitement_char(String test) {
        test=test.toUpperCase();
        char res=test.charAt(0);
        return res;
    }

    private static boolean test_char_correct(char res, char[] valeurs_ok) {
        boolean ok=false;
        for(int i=0;i<valeurs_ok.length; i++){
            if(res==valeurs_ok[i]){
               ok=true;
               break;
            }
        }
        return ok;
    }
}
