package cartes;

public class Borne extends Carte {
	
	private int km;
	
	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}
	
	public String toString() {
		return this.km + " km";
	}

	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == getClass()) {
			Borne b = (Borne) obj;
			return b.equals(obj);
		}
		return false;
	}
}
