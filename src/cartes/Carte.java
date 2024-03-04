package cartes;

public abstract class Carte {
	
	private int nombre;
	
	public Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == getClass()) {
			Carte c = (Carte) obj;
			return c.equals(obj);
		}
		return false;
	}

}
