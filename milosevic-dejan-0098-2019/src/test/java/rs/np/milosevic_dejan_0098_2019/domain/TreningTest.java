package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TreningTest extends AbstractDomainObjectTest {

	@BeforeEach
	void setUp() throws Exception {
		ado = new Trening();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testTrening() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		Kategorija k = new Kategorija(1l, "Junior");
		Trener tr = new Trener(1l, "Dejan", "Stankovic", 7, "0633333333");
		Teren te = new Teren(1l, "Marakana", 105.1, 68.2);
		Administrator a = new Administrator(1l, "Stevan", "Stevanovic", "steva", "steva123");
		ArrayList<Ucesce> u = new ArrayList<>();
		Ucesce uc = new Ucesce();
		u.add(uc);

		ado = new Trening(1l, d, 5, k, tr, te, a, u);

		assertEquals(1l, ((Trening) ado).getTreningID());
		assertEquals(d, ((Trening) ado).getDatumVreme());
		assertEquals(k, ((Trening) ado).getKategorija());
		assertEquals(tr, ((Trening) ado).getTrener());
		assertEquals(te, ((Trening) ado).getTeren());
		assertEquals(a, ((Trening) ado).getAdministrator());
		assertEquals(u, ((Trening) ado).getUcesca());
	}

	@Test
	void testTreningID() {
		((Trening) ado).setTreningID(1l);

		assertEquals(1l, ((Trening) ado).getTreningID());
	}

	@Test
	void testDatumVreme() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		((Trening) ado).setDatumVreme(d);

		assertEquals(d, ((Trening) ado).getDatumVreme());
	}

	@Test
	void testMaxBrojClanova() {
		((Trening) ado).setMaxBrojClanova(5);

		assertEquals(5, ((Trening) ado).getMaxBrojClanova());
	}

	@Test
	void testTreningKategorija() {
		Kategorija k = new Kategorija(1l, "Junior");

		((Trening) ado).setKategorija(k);

		assertEquals(k, ((Trening) ado).getKategorija());
	}

	@Test
	void testTreningTrener() {
		Trener tr = new Trener(1l, "Dejan", "Stankovic", 7, "0633333333");

		((Trening) ado).setTrener(tr);

		assertEquals(tr, ((Trening) ado).getTrener());
	}

	@Test
	void testTreningTeren() {
		Teren te = new Teren(1l, "Marakana", 105.1, 68.2);

		((Trening) ado).setTeren(te);

		assertEquals(te, ((Trening) ado).getTeren());
	}

	@Test
	void testTreningAdministrator() {
		Administrator a = new Administrator(1l, "Stevan", "Stevanovic", "steva", "steva123");

		((Trening) ado).setAdministrator(a);

		assertEquals(a, ((Trening) ado).getAdministrator());
	}

	@Test
	void testTreningUcesca() {
		ArrayList<Ucesce> u = new ArrayList<>();
		Ucesce uc = new Ucesce();
		u.add(uc);

		((Trening) ado).setUcesca(u);

		assertEquals(u, ((Trening) ado).getUcesca());
	}

	@Test
	void testToString() {
		((Trening) ado).setTreningID(1l);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		((Trening) ado).setDatumVreme(d);
		
		((Trening) ado).setMaxBrojClanova(5);
		
		Kategorija k = new Kategorija(1l, "Junior");
		((Trening) ado).setKategorija(k);
		
		Trener tr = new Trener(1l, "Dejan", "Stankovic", 7, "0633333333");
		((Trening) ado).setTrener(tr);
		
		Teren te = new Teren(1l, "Marakana", 105.1, 68.2);
		((Trening) ado).setTeren(te);
		
		Administrator a = new Administrator(1l, "Stevan", "Stevanovic", "steva", "steva123");
		((Trening) ado).setAdministrator(a);
		
		String s = ado.toString();

		assertTrue(s.contains("1"));
		assertTrue(s.contains("Tue Oct 10 10:00:00 CEST 2023"));
		assertTrue(s.contains("5"));
		assertTrue(s.contains("Junior"));
		assertTrue(s.contains("Dejan Stankovic"));
		assertTrue(s.contains("Marakana"));
		assertTrue(s.contains("Stevan Stevanovic"));
	}

	void testEqualsNull() {
		assertFalse(ado.equals(null));
	}

	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(ado.equals(new Exception()));
	}

	@Test
	void testEqualsIstiObjekat() {
		assertTrue(ado.equals(ado));
	}

	@ParameterizedTest
	@CsvSource({
		"10.10.2023 10:00, 10.10.2023 10:00, true",
		"10.10.2023 10:00, 10.10.2023 12:00, false"
	})
	void testEqualsIsti(String datum1, String datum2, boolean isti) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date d = null;
		try {
			d = sdf.parse(datum1);
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		
		Date d2 = null;
		try {
			d2 = sdf.parse(datum2);
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Trening t1 = new Trening();
		t1.setDatumVreme(d);

		Trening t2 = new Trening();
		t2.setDatumVreme(d2);

		assertEquals(isti, t1.equals(t2));
	}
	
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();

		assertTrue(s.toLowerCase().contains("trening"));
	}

	@Test
	void testAlijas() {
		String s = ado.alijas();

		assertTrue(s.toLowerCase().contains("t"));
	}

	@Test
	void testJoin() {
		assertEquals(" JOIN KATEGORIJA K ON (K.KATEGORIJAID = T.KATEGORIJAID) "
				+ "JOIN TRENER TR ON (TR.TRENERID = T.TRENERID) "
				+ "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
				+ "JOIN TEREN TE ON (TE.TERENID = T.TERENID) ", ado.join());
	}

	@Test
	void testKoloneZaInsert() {
		assertEquals(" (datumVreme, maxBrojClanova, KategorijaID, trenerID, terenID, administratorID) ",
				ado.koloneZaInsert());
	}

	@Test
	void testPrimarniKljuc() {
		((Trening) ado).setTreningID(1l);

		String s = ado.vrednostZaPrimarniKljuc();

		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		((Trening) ado).setDatumVreme(d);

		((Trening) ado).setMaxBrojClanova(6);

		Kategorija k = new Kategorija(2l, "Junior");
		((Trening) ado).setKategorija(k);

		Trener tr = new Trener(3l, "Dejan", "Stankovic", 7, "0633333333");
		((Trening) ado).setTrener(tr);

		Teren te = new Teren(4l, "Marakana", 105.1, 68.2);
		((Trening) ado).setTeren(te);

		Administrator a = new Administrator(5l, "Stevan", "Stevanovic", "steva", "steva123");
		((Trening) ado).setAdministrator(a);

		String s = ado.vrednostiZaInsert();

		assertTrue(s.contains("2023-10-10 10:00:00.0"));
		assertTrue(s.contains("6"));
		assertTrue(s.contains("2"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("4"));
		assertTrue(s.contains("5"));
	}

	@Test
	void testVrednostiZaUpdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		((Trening) ado).setDatumVreme(d);

		Teren te = new Teren(2l, "Marakana", 105.1, 68.2);
		((Trening) ado).setTeren(te);

		String s = ado.vrednostiZaUpdate();

		assertTrue(s.contains("2023-10-10 10:00:00.0"));
		assertTrue(s.contains("2"));
	}

	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}

}
