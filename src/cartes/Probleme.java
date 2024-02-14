package cartes;

public class Probleme extends Carte {

	enum Type {FEU, ACCIDENT, ESSENCE, CREVAISON }
	Type type;
	
	public Probleme(int numero, Type type) {
		super(numero);
		this.type = type;
	}

}
