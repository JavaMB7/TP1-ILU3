package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		switch(getType()) {
		case FEU:
			return "Feu Rouge";
		
		case ACCIDENT:
			return "Accident";
			
		case ESSENCE:
			return "Panne d'essence";
		
		case CREVAISON:
			return "Crevaison";
			
		default:
			return "Attaque";
		}
	}

}
