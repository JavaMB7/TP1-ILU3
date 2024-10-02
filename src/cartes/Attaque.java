package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		Type type = getType();
		return type.getAttaque();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Attaque attaque){
			 return getType() == attaque.getType();
		 }
		 return false;
	}
	
	@Override
	public int hashCode() {
	    return getType() != null ? getType().hashCode() : 0;
	}

}
