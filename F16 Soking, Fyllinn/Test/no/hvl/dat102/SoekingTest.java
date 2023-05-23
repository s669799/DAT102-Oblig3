package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class SoekingTest {
	Integer[] tab = { 7, 123, 4, 15, 9, 5, 19, 12, 16, 182, 10 };

	static Random tilfeldig = new Random();
	static int n = 128000;

	static Integer[] a = new Integer[n];

	private static Integer iTabFoerst = 2;
	private static Integer iTabMidt = 2500000;
	private static Integer iTabSlutt = 5000000;
	private static Integer mindreEnn = 1;
	private static Integer stoerreEnn = 5000001;

	@BeforeAll
	public static void setUp() throws Exception {
		for (int i = 0; i < n; i++) {
			a[i] = tilfeldig.nextInt(5000000 + 1 - 2) + 2;
		}
		a[0] = iTabFoerst;
		a[n / 2] = iTabMidt;
		a[n - 1] = iTabSlutt;
	}

	@Test
	@Order(1)
	void testUsortertTabell() {
		System.out.println("--------------------------------------------------");

		long start1Usort = System.nanoTime();
		assertTrue(Soeking.usortertTabell(a, iTabFoerst));
		long slutt1Usort = System.nanoTime();

		long start2Usort = System.nanoTime();
		assertTrue(Soeking.usortertTabell(a, iTabSlutt));
		long slutt2Usort = System.nanoTime();

		long start3Usort = System.nanoTime();
		assertTrue(!Soeking.usortertTabell(a, mindreEnn));
		long slutt3Usort = System.nanoTime();

		long start4Usort = System.nanoTime();
		assertTrue(!Soeking.usortertTabell(a, stoerreEnn));
		long slutt4Usort = System.nanoTime();

		System.out.print("Element først i usort tab: ");
		System.out.print(slutt1Usort - start1Usort);
		System.out.println(" nanosek.");

		System.out.print("Element sist i usort tab: ");
		System.out.print(slutt2Usort - start2Usort);
		System.out.println(" nanosek.");

		System.out.print("Element før usort tab(ikke i tab): ");
		System.out.print(slutt3Usort - start3Usort);
		System.out.println(" nanosek.");

		System.out.print("Element etter usort tab(ikke i tab): ");
		System.out.print(slutt4Usort - start4Usort);
		System.out.println(" nanosek.");
		System.out.println();

//		for (int i = 0; i < n; i++) {
//			System.out.print(a[i] + " ");
//		}
	}

	@Test
	@Order(2)
	void testUsortertKjede() {
		fail("Not yet implemented");
	}

	@Test
	@Order(3)
	void testSortertTabell() {
		long sortering1 = System.currentTimeMillis();
		SorterTabell.sorteringVedInnsetting3(a, 128000);
		long sortering2 = System.currentTimeMillis();

		long start1Sort = System.nanoTime();
		assertTrue(Soeking.sortertTabell(a, iTabFoerst));
		long slutt1Sort = System.nanoTime();

		assertTrue(Soeking.sortertTabell(a, iTabMidt));

		long start2Sort = System.nanoTime();
		assertTrue(Soeking.sortertTabell(a, iTabSlutt));
		long slutt2Sort = System.nanoTime();

		long start3Sort = System.nanoTime();
		assertTrue(!Soeking.sortertTabell(a, mindreEnn));
		long slutt3Sort = System.nanoTime();

		long start4Sort = System.nanoTime();
		assertTrue(!Soeking.sortertTabell(a, stoerreEnn));
		long slutt4Sort = System.nanoTime();

		System.out.print("Sortering(ms): ");
		System.out.print(sortering2 - sortering1);
		System.out.println(" millisek.");

		System.out.print("Element først i sort tab(ns): ");
		System.out.print(slutt1Sort - start1Sort);
		System.out.println(" nanosek.");
		
		System.out.print("Element sist i sort tab(ns): ");
		System.out.print(slutt2Sort - start2Sort);
		System.out.println(" nanosek.");

		System.out.print("Element før sort tab(ikke i tab)(ns): ");
		System.out.print(slutt3Sort - start3Sort);
		System.out.println(" nanosek.");

		System.out.print("Element etter sort tab(ikke i tab)(ns): ");
		System.out.print(slutt4Sort - start4Sort);
		System.out.println(" nanosek.");

		System.out.println();

//		b = a.clone();
	}

	@Test
	@Order(4)
	void testSortertKjede() {
		fail("Not yet implemented");
	}

	@Test
	@Order(5)
	void testBinaersoek() {
		long sortering1 = System.currentTimeMillis();
		SorterTabell.sorteringVedInnsetting3(a, 128000);
		long sortering2 = System.currentTimeMillis();
		

		long start1Binaer = System.nanoTime();
		assertTrue(Soeking.binaersoek(a, iTabFoerst));
		long slutt1Binaer = System.nanoTime();

		long start2Binaer = System.nanoTime();
		assertTrue(Soeking.binaersoek(a, iTabSlutt));
		long slutt2Binaer = System.nanoTime();

		long start3Binaer = System.nanoTime();
		assertTrue(!Soeking.binaersoek(a, mindreEnn));
		long slutt3Binaer = System.nanoTime();

		long start4Binaer = System.nanoTime();
		assertTrue(!Soeking.binaersoek(a, stoerreEnn));
		long slutt4Binaer = System.nanoTime();

		System.out.print("Sortering 2(ms): ");
		System.out.println(sortering2 - sortering1);
		System.out.println(" millisek.");

		System.out.print("Element først i binSort tab(ns): ");
		System.out.print(slutt1Binaer - start1Binaer);
		System.out.println(" nanosek.");

		System.out.print("Element sist i binSort tab(ns): ");
		System.out.print(slutt2Binaer - start2Binaer);
		System.out.println(" nanosek.");

		System.out.print("Element før binSort tab(ikke i tab)(ns): ");
		System.out.print(slutt3Binaer - start3Binaer);
		System.out.println(" nanosek.");

		System.out.print("Element etter binSort tab(ikke i tab)(ns): ");
		System.out.print(slutt4Binaer - start4Binaer);
		System.out.println(" nanosek.");

		System.out.println();
	}

}
