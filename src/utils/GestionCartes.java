package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	private GestionCartes() {
	}
	
	public static <T> T extraire(List<T> liste) {
			if (liste.isEmpty()) {
				throw new IllegalArgumentException("La liste ne doit pas Ãªtre vide.");
			}
			Random r = new Random();
			int index = r.nextInt(liste.size());
			return liste.remove(index);
		}

		public static <T> T extraireAvecIterator(List<T> liste) {
			if (liste.isEmpty()) {
				throw new IllegalArgumentException("La liste ne doit pas Ãªtre vide.");
			}
			ListIterator<T> iterator = liste.listIterator();
			Random r = new Random();
			int index = r.nextInt(liste.size());
			while (iterator.hasNext() && index > 0) {
				iterator.next();
				index--;
			}
			T element = iterator.next();
			iterator.remove();
			return element;
		}

		public static <T> List<T> melanger(List<T> liste) {
			Random random = new Random(106);
	        List<T> listeMelangee = new ArrayList<>();
	        
	        while (!liste.isEmpty()) {
	            T element = extraireAvecIterator(liste);
	            listeMelangee.add(element);
	        }
	        
	        return listeMelangee;
		}

		public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
			if (liste1.size() != liste2.size()) {
				return false;
			}
			for (T element : liste1) {
				if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
					return false;
				}
			}
			return true;
		}

		public static <T> List<T> rassembler(List<T> liste) {
			List<T> result = new ArrayList<>();
			if (liste.isEmpty()) {
				return result;
			}
			result.add(liste.get(0));
			for (int i = 1; i < liste.size(); i++) {
				if (!liste.get(i).equals(liste.get(i - 1))) {
					result.add(liste.get(i));
				}
			}
			return result;
		}

		public static <T> boolean verifierRassemblement(List<T> liste) {
			if (liste.isEmpty()) {
				return true;
			}
			Iterator<T> firstIterator = liste.iterator();
			Iterator<T> secondIterator = liste.iterator();
			secondIterator.next();
			while (secondIterator.hasNext()) {
				if (!firstIterator.next().equals(secondIterator.next())) {
					return false;
				}
			}
			return true;
		}
}


