package upmc.game;

import java.util.Scanner;

/**
 * Pint the menu until the user make a rigth choice. Used of nextLine and not nextInt to deal with the errors. (check if it's a number..)
 * It will redirect to the right class
 */
public class MenuPseudo
{
    /**
     * @return the LecturePseudo by a console or a file. Same type from two methods
     */
    public LecturePseudo modeLecturePseudo(Scanner keyboardChoice)
    {
        String choice;
        do
        {
            System.out.println("(1) : Fichier");
            System.out.println("(2) : Console");
            choice = keyboardChoice.nextLine();
        } while (!WarUtility.isNumber(choice));

        switch (Integer.parseInt(choice)){
            case 1: return new LectureFichier();
            case 2: return new LectureConsole();
            default: return null;
        }
    }


}
