package cartes;

public class Probleme extends Carte {

	public enum Type {FEU, ACCIDENT, ESSENCE, CREVAISON }
	private Type type;
	
	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
}
