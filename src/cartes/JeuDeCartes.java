package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = {
		new Configuration(new Borne(25), 10),
		new Configuration(new Borne(50), 10),
		new Configuration(new Borne(75), 10),
		new Configuration(new Borne(100), 12),
		new Configuration(new Borne(200), 4),
		new Configuration(new Parade(Type.FEU), 14),
		new Configuration(new Parade(Type.ESSENCE), 6),
		new Configuration(new Parade(Type.CREVAISON), 6),
		new Configuration(new Parade(Type.ACCIDENT), 6),
		new Configuration(new Attaque(Type.ACCIDENT), 3),
		new Configuration(new Attaque(Type.CREVAISON), 3),
		new Configuration(new Attaque(Type.ESSENCE), 3),
		new Configuration(new Attaque(Type.FEU), 5),
		new Configuration(new Botte(Type.ACCIDENT), 1),
		new Configuration(new Botte(Type.FEU), 1),
		new Configuration(new Botte(Type.CREVAISON), 1),
		new Configuration(new Botte(Type.ESSENCE), 1),
		new Configuration(new DebutLimite(), 4),
		new Configuration(new FinLimite(), 6)
	};
	
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
		for(int i = 0; i<typesDeCartes.length; i++) {
			string.append(typesDeCartes[i].nbExemplaires + typesDeCartes[i].getCarte().toString());
			string.append("\n");
		}
		return string.toString();
	}
	
	public Carte[] donnerCartes() {
		
		int count = 0;
		for(int i = 0; i<typesDeCartes.length; i++) {
			count += typesDeCartes[i].nbExemplaires;
		}
		
		Carte[] cartes = new Carte[count];
		for(int i = 0, c = 0; i<typesDeCartes.length; i++) {
			for(int j=0; j<typesDeCartes[i].nbExemplaires;j++) {
				cartes[c] = typesDeCartes[i].carte;
				c ++;
			}
		}
		
		return cartes;
	}
	
	public boolean checkCount() {
		int countParade = 0;
		int countAttaque = 0;
		int countBorne = 0;
		int countBotte =0;
		for(Carte carte : donnerCartes()) {
			if(carte instanceof Attaque || carte instanceof DebutLimite) {
				countAttaque++;
			}else if (carte instanceof Parade || carte instanceof FinLimite) {
				countParade++;
			}else if(carte instanceof Borne) {
				countBorne++;
			}else if(carte instanceof Botte) {
				countBotte++;
			}
		}
		return countAttaque==18 && countParade==38 && countBorne==46 && countBotte==4;
	}



}
