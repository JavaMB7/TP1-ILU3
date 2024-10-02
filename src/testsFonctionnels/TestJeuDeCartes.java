package testsFonctionnels;
import cartes.*;


public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jdc = new JeuDeCartes();
		System.out.println(jdc.affichageJeuDeCartes());
		Carte[] c = jdc.donnerCartes();
		for(int i =0; i<c.length; i++) {
			System.out.println(c[i]);
		}
		
		if (!jdc.checkCount()) {
            System.out.println("erreur de nombre");
        }
	}

}
