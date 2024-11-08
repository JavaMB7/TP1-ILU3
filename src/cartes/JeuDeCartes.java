package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.ACCIDENT), 3), new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ESSENCE), 3), new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new Botte(Type.ACCIDENT), 1), new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new DebutLimite(), 4), new Configuration(new FinLimite(), 6) };

	private static class Configuration {

		private Carte carte;
		private int nbExemplaires;

		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}

	public String affichageJeuDeCartes() {

		StringBuilder string = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			string.append(typesDeCartes[i].nbExemplaires + typesDeCartes[i].getCarte().toString());
			string.append("\n");
		}
		return string.toString();
	}

	public Carte[] donnerCartes() {

		int countExemplaire = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			countExemplaire += typesDeCartes[i].nbExemplaires;
		}

		Carte[] cartes = new Carte[countExemplaire];
		for (int i = 0, j = 0; i < typesDeCartes.length; i++) {
			for (int k = 0; k < typesDeCartes[i].nbExemplaires; k++, j++) {
				cartes[j] = typesDeCartes[i].carte;
			}
		}

		return cartes;
	}

	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for(int i=0; i<cartes.length; i = i+counterCarte(cartes, cartes[i])) {
			System.out.println(counterCarte(cartes, cartes[i]));
			System.out.println(counterTypeCartes(cartes[i]) + "\n");
			if(counterCarte(cartes, cartes[i]) != counterTypeCartes(cartes[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public int counterCarte(Carte[] cartes, Carte carte) {
		int nb = 0;
		for(int i=0; i<cartes.length; i++) {
			if(cartes[i].equals(carte)) {
				nb++;
			}
		}
		return nb;
	}
	
	public int counterTypeCartes(Carte carte) {
		int nb = 0;
		for(int i=0; i<typesDeCartes.length; i++) {
			if(carte.equals(typesDeCartes[i].getCarte()))
				nb = typesDeCartes[i].getNbExemplaires() ;
		}
		return nb;
	}

}
