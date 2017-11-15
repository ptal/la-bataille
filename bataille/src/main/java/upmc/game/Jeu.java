package upmc.game;

public class Jeu {

    private Joueur joueur1;
    private Joueur joueur2;
    int gagne1 = 0; 
    int gagne2 = 0;
    int score = 0; 
    private Carte[] paquet;

    public Jeu(Joueur j1, Joueur j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.initialiserPaquet();

        this.melangerCartes();
        this.donnerCartes();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Carte[] getPaquet() {
        return paquet;
    }

    public void initialiserPaquet() {
        this.paquet = new Carte[52];
        int c = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                paquet[c] = new Carte(Carte.couleurs[i], Carte.valeurs[j]);
                c++;
            }
        }
    }

    public void melangerCartes() {
        for (int i = 0; i < paquet.length; i++) {
            int r = (int) (Math.random() * 52);
            Carte tmp = paquet[i];
            paquet[i] = paquet[r];
            paquet[r] = tmp;
        }
    }

    public void donnerCartes() {
        for (int i = 0; i < paquet.length; i++) {
            if (i < (paquet.length / 2)) {
                joueur1.ajouterCarte(paquet[i]);
            } else {
                joueur2.ajouterCarte(paquet[i]);
            }
        }
    }

    public void lancerJeu() {
        

        do {
            Carte c1 = joueur1.tireCarte();
            System.out.println(joueur1.getNom() + " tire la " + joueur1.toString(c1));
            Carte c2 = joueur2.tireCarte();
            System.out.println(joueur2.getNom() + " tire la " + joueur2.toString(c2));

            score = c1.comparateur(c2);

            afficheGagnantManche(); 
            System.out.println("Le score actuel est de " + gagne1 + " à " + gagne2);
        } while (joueur1.compteur() > 0 && joueur2.compteur() > 0);
        
        afficheGagnant();
    }

    public void afficheGagnant() {
        if (gagne2 > gagne1) {
            System.out.println("Le second joueur a gagné.");
            System.out.println("Le premier joueur a perdu.");
        } else if (gagne1 > gagne2) {
            System.out.println("Le premier joueur a gagné.");
            System.out.println("Le second joueur a perdu.");
        } else {
            System.out.println("Personne n'a gagné !");
        }
    }
    
    public void afficheGagnantManche(){
        if (score == 1) {
                System.out.println("Le premier joueur un remporte la manche");
                gagne1++;
            } else if (score == 0) {
                System.out.println("Personne ne gagne.");
            } else {
                System.out.println("Le second joueur un remporte la manche");
                gagne2++;
            }   
    }
// redha aissaoui
}
