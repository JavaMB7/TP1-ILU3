package cartes;

public class Probleme extends Carte {

	enum Type {FEU, ACCIDENT, ESSENCE, CREVAISON }
	Type type;
	
	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

}
