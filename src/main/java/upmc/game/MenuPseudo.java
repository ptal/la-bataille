package upmc.game;


import java.util.Scanner;

public class MenuPseudo {

    public LecturePseudo lirePseudo() {

        LecturePseudo lecture;

        Scanner sc4 = new Scanner(System.in);

        System.out.println("Bonjour , veuillez choisir le mode de lecture.");
        System.out.println("Tapez  1 pour LectureFichier");
        System.out.println("Tapez 2  pour LectureConsole");

        String str3 = sc4.nextLine();
        if (str3.equals("1")) {
            lecture = new LectureFichier();

        } else {
            lecture = new LectureConsole();
        }
        return (LecturePseudo) lecture.lirePseudo();

    }

}
