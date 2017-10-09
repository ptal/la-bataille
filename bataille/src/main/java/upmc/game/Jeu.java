package tp_bataille;

public class Jeu {
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	private Carte[] paquet;

	
	public Jeu(Joueur j1, Joueur j2) {
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.InitialiserPaquet();
		
		this.MélangerCartes();
		this.DonnerCartes();
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

	public void InitialiserPaquet() {
		this.paquet = new Carte[52];
		int c = 0;
		
		for (int i = 0; i < 4 ; i++) {
			for (int j = 0; j < 13 ; j++) {
				paquet[c] = new Carte (Carte.couleurs[i], Carte.valeurs[j]);
				c++;
			}
		}
	}
	
	public void MélangerCartes() {
		for (int i = 0; i < paquet.length; i++) {
	        int r = (int) (Math.random()*52);
	        Carte tmp = paquet[i];
	        paquet[i] = paquet[r];
	        paquet[r] = tmp;
	    }
	}
	
	public void DonnerCartes() {
		for (int i = 0 ; i < paquet.length; i++) {
			if (i < (paquet.length/2)) joueur1.ajouterCarte(paquet[i]);
			else joueur2.ajouterCarte(paquet[i]);
		}
	}
	
	public void LancerJeu() {
		int gagne1 = 0, gagne2 = 0;
		
		do {
			Carte c1 = joueur1.tireCarte();
			System.out.println("J1 tire la " + joueur1.toString(c1));
			Carte c2 = joueur2.tireCarte();
			System.out.println("J2 tire la " + joueur2.toString(c2));
			
			int score = c1.comparateur(c2);
			
			if(score == 1) {
				System.out.println("Le premier joueur un remporte la manche");
				gagne1++;
			} else if (score == 0) {
				System.out.println("Personne ne gagne.");
			} else {
				System.out.println("Le second joueur un remporte la manche");
				gagne2++;
			}
			System.out.println("Le score actuel est de " + gagne1 + " à "+ gagne2);

		
		} while (joueur1.compteur() > 0 && joueur2.compteur() > 0);
		
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
	
}
