package sabot;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot<C extends Carte> implements Iterable<C> {
	private Carte[] cartes;
	private int nbCartes;
	private static final int NB_CARTES_MAX = 110;

	public Sabot() {
		this.cartes = new Carte[NB_CARTES_MAX];
		this.nbCartes = 0;
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
	}

	public void ajouterFamilleCarte(Carte[] cartes) throws IllegalStateException {
		for (int j = 0; j < cartes.length; j++) {
			for (int i = 0; i < cartes[j].getNombre(); i++) {
				ajouterCarte(cartes[j]);
			}
		}
	}

	public Iterator<C> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<C> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public C next() {
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return (C) carte;
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
		}

	}

}
