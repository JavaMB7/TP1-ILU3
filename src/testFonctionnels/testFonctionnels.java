package testFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme;
import cartes.Probleme.Type;
import sabot.Sabot;


public class testFonctionnels {
	public static void main(String []args) {
		Sabot sabot = new Sabot(100);
		Botte bt = new Botte(1, Type.ACCIDENT);
		Parade pr = new Parade(3, Type.ACCIDENT);
		Attaque at = new Attaque(3, Type.ACCIDENT);
		Carte[] c = new Carte[20];
		for(int i=0;i<at.getNombre();i++) {
			c[i]=at;
		}
		for(int i=at.getNombre();i<pr.getNombre();i++) {
			c[i]=pr;
		}
		for(int i=pr.getNombre();i<bt.getNombre();i++) {
			c[i]=bt;
		}
		sabot.ajouterFamilleCarte(c);
		//for(int i = 0; i<sabot.getNbCartes(); i++) {
		//	sabot.piocher();
		//}
		Iterator<Carte> it = sabot.iterator();
		/*for(int i =0; i<c.length;i++) {
			it.next();
			it.remove();
		}*/
		
		for(int i =0; i<c.length;i++) {
			it.next();
			it.remove();
			sabot.piocher();
		}
	}
}
 