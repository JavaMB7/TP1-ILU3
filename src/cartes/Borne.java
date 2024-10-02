package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	
	public String toString() {
		return getKm() + " KM";
	}

	public int getKm() {
		return km;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Borne borne){
			 return km == borne.getKm();
		 }
		 return false;
	}

	
	@Override
	public int hashCode() {
	    return Integer.hashCode(km);
	}
}
