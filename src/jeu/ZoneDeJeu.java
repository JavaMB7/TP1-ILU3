package jeu;

import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import cartes.*;


public class ZoneDeJeu {
    
	private List<Limite> pileLimitesVitesse = new LinkedList<>();
	private List<FinLimite> pileFinLimites = new LinkedList<>();
    private List<Bataille> pileBataille = new LinkedList<>();
    private Collection<Borne> collectionBornes = new LinkedList<>();
    private Set<Botte> ensembleBottes = new HashSet<>();
	
    public List<Limite> getPileLimitesVitesse() {
		return pileLimitesVitesse;
	}
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	
	public List<FinLimite> getPileFinLimites() {
		return pileFinLimites;
	}
	
	public Collection<Borne> getCollectionBornes() {
		return collectionBornes;
	}
	public Set<Botte> getEnsembleBottes() {
		return ensembleBottes;
	}

	public boolean deposer(Carte carte) {
	    if (carte instanceof Borne borne) {
	        return collectionBornes.add(borne);
	    } else if (carte instanceof Bataille bataille) {
	        return pileBataille.add(bataille);
	    } else if (carte instanceof Limite limite) {
	        return pileLimitesVitesse.add(limite);
	    } else if (carte instanceof Botte botte) {
	        return ensembleBottes.add(botte);
	    } else {
	        throw new IllegalArgumentException("Invalid card type: " + carte);
	    }
	}
	
	public int donnerKmParcourus() {
        int kmParcourus = 0;
        for (Borne borne : collectionBornes) {
            kmParcourus += borne.getKm();
        }
        return kmParcourus;
    }
	
	public int donnerLimitationVitesse() {
        
        if (pileLimitesVitesse.isEmpty() || pileLimitesVitesse.get(pileLimitesVitesse.size() - 1) instanceof FinLimite) {
            return 200;
        }
        
        for (Carte bottes : ensembleBottes) {
            if (bottes instanceof Botte botte &&  botte.getType().equals(Type.FEU)) {
                return 200;
            }
        }

        return 50; 
    }
	
	public boolean estPrioritaire() {
		for(Botte botte : ensembleBottes) {
			if(botte.getType() ==  Type.FEU) {
				return true;
			}
		}
		return false;
	}	
	
	public boolean peutAvancer() {
	    if (!pileBataille.isEmpty()) {
	        Carte carteSommet = pileBataille.get(pileBataille.size()-1);
	        if(carteSommet.equals(Cartes.FEU_VERT) && carteSommet instanceof Parade) {
	        	return true;
	        }
	    }
	    return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
	    if (pileBataille.isEmpty()) {
	        return true;
	    }

	    Carte carteSommet = pileBataille.get(pileBataille.size()-1);
	    return carteSommet.equals(Cartes.FEU_ROUGE) || (carteSommet instanceof Parade && !carteSommet.equals(Cartes.FEU_VERT));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
	    if (!peutAvancer()) {
	        return false;
	    }

	    if (borne.getKm() > donnerLimitationVitesse()) {
	        return false;
	    }

	    int sommeVitesseBornes = donnerKmParcourus();
	    return sommeVitesseBornes + borne.getKm() <= 1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite && (pileLimitesVitesse.isEmpty()) || pileLimitesVitesse.size() <= pileFinLimites.size()) {
			return true;
		}
		if(limite instanceof FinLimite && pileLimitesVitesse.size() >= pileFinLimites.size()) {
			return true;
		}
		return false;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
        if (bataille instanceof Attaque && peutAvancer())
            return true;
        if (bataille instanceof Parade) {
            if (bataille.getType()==Type.FEU) {
                return estDepotFeuVertAutorise();
            }
            else {
                return (!pileBataille.isEmpty() 
                        && (pileBataille.get(pileBataille.size()-1)instanceof Attaque && pileBataille.get(pileBataille.size()-1).getType()==bataille.getType()));
            }
        }
        return false;
    }
	
	public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne) {
            return estDepotBorneAutorise((Borne) carte);
        } else if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        } else if (carte instanceof Bataille) {
            return estDepotBatailleAutorise((Bataille) carte);
        } else {
            throw new IllegalArgumentException("Type de carte invalide");
        }
    }
}