package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UcesceTest extends AbstractDomainObjectTest {

	@BeforeEach
	void setUp() throws Exception {
		ado = new Ucesce();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testUcesce() {
		Trening t = new Trening();
		t.setTreningID(1l);
		Clan c = new Clan();
		c.setClanID(2l);

		ado = new Ucesce(t, 3, "Povredjeno koleno", c);

		assertEquals(t, ((Ucesce) ado).getTrening());
		assertEquals(3, ((Ucesce) ado).getRbUcesca());
		assertEquals("Povredjeno koleno", ((Ucesce) ado).getNapomena());
		assertEquals(c, ((Ucesce) ado).getClan());
	}

	@Test
	void testTreningUcesce() {
		Trening t = new Trening();
		t.setTreningID(1l);

		((Ucesce) ado).setTrening(t);

		assertEquals(t, ((Ucesce) ado).getTrening());
	}

	@Test
	void testRedniBroj() {
		((Ucesce) ado).setRbUcesca(1);

		assertEquals(1, ((Ucesce) ado).getRbUcesca());
	}

	@Test
	void testClanUcesce() {
		Clan c = new Clan();
		c.setClanID(2l);

		((Ucesce) ado).setClan(c);

		assertEquals(c, ((Ucesce) ado).getClan());
	}

	@Test
	void testNapomena() {
		((Ucesce) ado).setNapomena("Povredjeno koleno");

		assertEquals("Povredjeno koleno", ((Ucesce) ado).getNapomena());
	}

	@Test
	void testToString() {
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

		Trening t = new Trening(1l, d, 5, k, tr, te, a, u);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");

		Date dClana = null;
		try {
			d = sdf2.parse("10.10.2000");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Kategorija kClana = new Kategorija(1l, "Junior");

		Pozicija p = new Pozicija(1l, "Golman");

		Clan c = new Clan(1l, "Pera", "Peric", "pera@gmail.com", dClana, "061213112", kClana, p);

		ado = new Ucesce(t, 3, "Povredjeno koleno", c);

		String s = ado.toString();

		assertTrue(s.contains("1"));
		assertTrue(s.contains("Tue Oct 10 10:00:00 CEST 2023"));
		assertTrue(s.contains("5"));
		assertTrue(s.contains("Junior"));
		assertTrue(s.contains("Dejan Stankovic"));
		assertTrue(s.contains("Marakana"));
		assertTrue(s.contains("Stevan Stevanovic"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("Povredjeno koleno"));
		assertTrue(s.contains("Pera Peric"));
	}

	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();

		assertTrue(s.toLowerCase().contains("ucesce"));
	}

	@Test
	void testAlijas() {
		String s = ado.alijas();

		assertTrue(s.toLowerCase().contains("u"));
	}

	@Test
	void testJoin() {
		assertEquals(" JOIN TRENING T USING (TRENINGID) " + "JOIN CLAN C USING (CLANID) "
				+ "JOIN KATEGORIJA K ON (K.KATEGORIJAID = T.KATEGORIJAID) "
				+ "JOIN TRENER TR ON (TR.TRENERID = T.TRENERID) "
				+ "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
				+ "JOIN TEREN TE ON (TE.TERENID = T.TERENID) " + "JOIN POZICIJA P ON (P.POZICIJAID = C.POZICIJAID)",
				ado.join());
	}

	@Test
	void testKoloneZaInsert() {
		assertEquals(" (treningID, rbUcesca, napomena, clanID) ", ado.koloneZaInsert());
	}

	@Test
	void testPrimarniKljuc() {
		Trening t = new Trening();
		t.setTreningID(1l);

		((Ucesce) ado).setTrening(t);

		String s = ado.vrednostZaPrimarniKljuc();

		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		Trening t = new Trening();
		t.setTreningID(1l);
		Clan c = new Clan();
		c.setClanID(2l);

		ado = new Ucesce(t, 3, "Povredjeno koleno", c);

		String s = ado.vrednostiZaInsert();

		assertTrue(s.contains("1"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("Povredjeno koleno"));
		assertTrue(s.contains("2"));
	}

	@Test
	void testVrednostiZaUpdate() {
		assertEquals("", ado.vrednostiZaUpdate());
	}

	@Test
	void testUslov() {
		Trening t = new Trening();
		t.setTreningID(1l);

		((Ucesce) ado).setTrening(t);

		String s = ado.uslov();

		assertTrue(s.contains("1"));
	}
}
