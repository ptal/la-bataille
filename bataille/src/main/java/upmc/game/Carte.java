package upmc.game;

public class Carte {

	public static String[] couleurs = { "Coeur","Pique", "Carreau",  "Trefle" };
	public static int[] valeurs = { 1,2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13 };
	
	
	
	private String couleur;
	private int valeur;

	public Carte(String couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int comparateur(Carte carte) {
            
		if (carte.getValeur() == this.getValeur()) return 0;
		if (carte.getValeur() > this.getValeur()) return -1;
		return 1;
	}  
}
// redha aissaoui
     
