package test.upmc.game; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import upmc.game.LectureFichier;

import java.util.Scanner;

/** 
* LectureFichier Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 14, 2017</pre> 
* @version 1.0 
*/ 
public class LectureFichierTest {

    LectureFichier lectureFichier;

@Before
public void before() throws Exception {
    this.lectureFichier = new LectureFichier();

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
}


/** 
* 
* Method: readFile() 
* 
*/ 
@Test
public void testReadFile() throws Exception { 
    assert (this.lectureFichier.readFile(new Scanner("joueurs.txt")).exists());
/* 
try { 
   Method method = LectureFichier.getClass().getMethod("readFile"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: addPseudos() 
* 
*/ 
@Test
public void testAddPseudos() throws Exception { 
/*
try { 
   Method method = LectureFichier.getClass().getMethod("addPseudos"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: checkFileExist(File file) 
* 
*/ 
@Test
public void testCheckFileExist() throws Exception { 
/*
try { 
   Method method = LectureFichier.getClass().getMethod("checkFileExist", File.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
