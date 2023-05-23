package no.hvl.dat102;

public class Soeking {

	/** Søker i usortert tabell. */
	public static <T> boolean usortertTabell(T[] a, T element) {
		boolean funnet = false;
		int i = 0;
		int lengde = a.length;

		while (!funnet && (i < lengde)) {
			if (element.equals(a[i]))
				funnet = true;
			i++;
		}

		return funnet;
	}

	/** Søker i usortert kjede. */
	public static <T> boolean usortertKjede(LinearNode<T> forste, T element) {

		boolean funnet = false;
		LinearNode<T> p = forste;

		while (!funnet && p != null) {
			if (element.equals(p.getElement())) {
				funnet = true;
			} else {
				p = p.getNeste();
			}
		}

		return funnet;
	}

	/** Søker i sortert tabell. */
	public static <T extends Comparable<? super T>> boolean sortertTabell(T[] a, T element) {
		/*
		 * Merk at for å dra nytte av sorteringa må T implementere Comparable. Er ikkje
		 * nødvendig når vi søker i usortert tabell sidan vi da brukar equals.
		 */

		// fyll inn
//		if(a[a.length-1].equals(element))
//			return true;
		
		int i = 0;
		boolean funnet = false;

		while ((i < a.length) && element.compareTo(a[i]) >= 0) {
			if (element.equals(a[i])) {
				return true;
			} else {
				i++;
			}
		}
		return funnet;
	}

	/** Søker i sortert kjede. */
	public static <T extends Comparable<? super T>> boolean sortertKjede(LinearNode<T> forste, T element) {

		LinearNode<T> p = forste;

		while (p != null && element.compareTo(p.getElement()) < 0) {
			p = p.getNeste();
		}

		return p != null && element.equals(p.getElement());
	}

	/**
	 * Binærsøking. Tabell må vere sortert.
	 */
	public static <T extends Comparable<? super T>> boolean binaersoek(T[] data, T element) {
		return binaersoek(data, 0, data.length - 1, element);
	}

	private static <T extends Comparable<? super T>> boolean binaersoek(T[] data, int min, int maks, T element) {
		boolean funnet = false;
		// tom del å søke i -> basis
		if (min > maks) {
			funnet = false;
		} else {
			int midten = (min + maks) / 2;
			int resultat = element.compareTo(data[midten]);

			if (resultat == 0) { // basis
				funnet = true;
			} else {
				if (resultat < 0) { // leite i venstre del
					funnet = binaersoek(data, min, midten - 1, element);
				} else {
					funnet = binaersoek(data, midten + 1, maks, element);
				}
			}
		}

		return funnet;
	}

}
