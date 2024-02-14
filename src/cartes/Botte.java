package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	public String toString() {
		switch(type) {
		case FEU:
			return "Camion Prioritaire";
		
		case ACCIDENT:
			return "As du volant";
			
		case ESSENCE:
			return "Camion citerne";
		
		case CREVAISON:
			return "Increvable";
			
		default:
			return "Joker";
		}
	}
}
