package sabot;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes;
	private static final int NB_CARTES_MAX = 110;
	private int indiceIterateur = 0;
	private int nombreOperations;

	public Sabot(int nbCarte) {
		if(nbCarte > NB_CARTES_MAX) {
			throw new IllegalArgumentException("nbCarte > NB_CARTE_MAX");
		}
		this.cartes = new Carte[nbCarte];
		this.nbCartes = 0;
	}

	
	public int getNbCartes() {
		return nbCartes;
	}


	public boolean estVide() {
		return nbCartes == 0;
	}

	private void ajouterCarte(Carte carte) throws IllegalStateException {
		if (this.nbCartes == NB_CARTES_MAX) {
			throw new IllegalStateException("Le nombre de cartes dans le paquet est déjà atteinte");
		}
		this.cartes[nbCartes] = carte;
		this.nbCartes += 1;
		nombreOperations ++;
	}

	public void ajouterFamilleCarte(Carte[] cartes) throws IllegalStateException {
		for (int j = 0; j < cartes.length; j++) {
			for (int i = 0; i < cartes[j].getNombre(); i++) {
				ajouterCarte(cartes[j]);
			}
		}
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte c = it.next();
		it.remove();
		return c;
		
	}

	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return (Carte) carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--; // indice du prochain élément à visiter (s’il existe)
			nbCartes--;
			nombreOperations ++;
			nombreOperationsReference ++;
		}
		
		private void verificationConcurrence(){
			 if (nombreOperations != nombreOperationsReference)
			 throw new ConcurrentModificationException();
		}

		
	}

}
