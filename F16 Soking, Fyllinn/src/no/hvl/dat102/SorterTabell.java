package no.hvl.dat102;

public class SorterTabell {
	// Byter om a[i] og a[j]. Antar at både i og j er lovlege indeksar i tabellen.
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
	// Sorterer dei første n elmementa i tabellen. Kanskje litt uvanlig
	// Kunne også utelatt n og sortert heile tabellen.

	public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int minstePos = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j].compareTo(a[minstePos]) < 0) {
					minstePos = j;
				}
			}

			swap(a, i, minstePos);
		}
	}

	public static <T extends Comparable<? super T>> int minstePos(T[] a) {
		int minstePos = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[minstePos]) < 0) {
				minstePos = i;
			}
		}
		return minstePos;
	}

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting1(T[] a, int n) {
		sorteringVedInnsetting1(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting1(T[] a, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T tmp = a[i];
			int j = i - 1; // siste i sortert del
			boolean ferdig = false;

			while (!ferdig && j >= 0) {
				if (tmp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}

			a[j + 1] = tmp;
		}
	}

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting2(T[] a, int n) {
		sorteringVedInnsetting2(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting2(T[] a, int start, int slutt) {
		swap(a, 0, minstePos(a));
		for (int i = start + 1; i <= slutt; i++) {
			T tmp = a[i];
			int j = i - 1; // siste i sortert del
			boolean ferdig = false;

			while (!ferdig) {
				if (tmp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j + 1] = tmp;
		}
	}

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting3(T[] a, int n) {
		sorteringVedInnsetting3(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting3(T[] a, int start, int slutt) {
		swap(a, 0, minstePos(a));
		T tmp1;
		T tmp2;
		int j;
		for (int i = start + 2; i < slutt; i += 2) {
			// første i usortert del

			if (a[i].compareTo(a[i + 1]) < 0) {
				tmp1 = a[i];
				tmp2 = a[i + 1];
			} else {
				tmp1 = a[i + 1];
				tmp2 = a[i];
			}

			j = i - 1; // siste i sortert del
			boolean ferdig2 = false;
			boolean ferdig1 = false;

			while (!ferdig2) {
				if (tmp2.compareTo(a[j]) < 0) {
					a[j + 2] = a[j];
					j--;
				} else {
					ferdig2 = true;
				}
			}
			a[j + 2] = tmp2;

			while (!ferdig1) {
				if (tmp1.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {

					ferdig1 = true;
				}
			}
			a[j + 1] = tmp1;

		}

		if (a.length % 2 != 0) {
			tmp1 = a[a.length - 1];
			j = a.length - 2;

			while (tmp1.compareTo(a[j]) < 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = tmp1;
		}
	}
}
