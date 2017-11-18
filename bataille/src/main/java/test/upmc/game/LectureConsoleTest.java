package test.upmc.game; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 
* LectureConsole Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 15, 2017</pre> 
* @version 1.0 
*/ 
public class LectureConsoleTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: lirePseudo() 
* 
*/ 
@Test
public void testLirePseudo() throws Exception { 
    ArrayList<String> alPseudos;
    Scanner keyboardChoice = new Scanner("tim;test");
    do
    {
        System.out.println("Entrez les noms ( >= 2 ) des joueurs séparés par ';' :");
        alPseudos = new ArrayList<String>();
        Collections.addAll(alPseudos, keyboardChoice.nextLine()
                .trim()
                .split(";"));
    } while (alPseudos.size() < 2);

    assert (alPseudos.size() == 2);
} 


} 
