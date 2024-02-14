package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	public String toString() {
		switch(type) {
		case FEU:
			return "Feu Vert";
		
		case ACCIDENT:
			return "Reparation";
			
		case ESSENCE:
			return "Station essence";
		
		case CREVAISON:
			return "Roue de secours";
			
		default:
			return "Parade";
		}
	}
}
