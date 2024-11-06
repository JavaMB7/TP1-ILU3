package cartes;

public abstract class Carte {
	public abstract String toString();
	
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Carte carte) {
			return this.getClass()== carte.getClass();
		}
		return false;	
	}
	
}

