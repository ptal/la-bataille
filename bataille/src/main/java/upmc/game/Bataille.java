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
      
        Scanner sc=new Scanner(System.in);
        char rejouer='O';
        
        while(rejouer== 'O'){
            
            Partie partie = new Partie();
            
            rejouer= ' ';
            while(rejouer!='O' && rejouer!='N'){
                affiche("Souhaitez vous rejouer ? O/N");
                rejouer=test_scanner(sc);
            }
        }
        affiche("A la prochaine !");       
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
    
    public static void affiche(String str){
        System.out.println(str);
    }
}
