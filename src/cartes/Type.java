package cartes;

public enum Type {
	ESSENCE (" Panne essence", " Bidon essence", " Citerne"), 
	CREVAISON (" Crevaison", " Roue Secours", " Increvable"), 
	ACCIDENT(" Accident", " Reparation", " As du volant"),
	FEU (" Feu rouge", " Feu vert", " Vehicule Prioritaire");
	
	private final String attaque;
	private final String parade;
	private final String botte;
	
	private Type(String attaque, String parade, String botte){
		this.attaque= attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
	
}
