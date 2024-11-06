package cartes;

public abstract class Probleme extends Carte {

	private Type type;

	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Probleme probleme && super.equals(obj) ) {
			return getType() == probleme.getType();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getType() != null ? getType().hashCode() : 0;
	} 

}
