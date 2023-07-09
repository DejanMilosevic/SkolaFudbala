package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClanTest extends AbstractDomainObjectTest {

	@BeforeEach
	void setUp() throws Exception {
		ado = new Clan();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testClan() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Kategorija k = new Kategorija(1l, "Junior");

		Pozicija p = new Pozicija(1l, "Golman");

		ado = new Clan(1l, "Pera", "Peric", "pera@gmail.com", d, "061213112", k, p);

		assertEquals(1l, ((Clan) ado).getClanID());
		assertEquals("Pera", ((Clan) ado).getImeClana());
		assertEquals("Peric", ((Clan) ado).getPrezimeClana());
		assertEquals("pera@gmail.com", ((Clan) ado).getEmail());
		assertEquals(d, ((Clan) ado).getDatumRodjenja());
		assertEquals(k, ((Clan) ado).getKategorija());
		assertEquals(p, ((Clan) ado).getPozicija());
	}

	@Test
	void testClanID() {
		((Clan) ado).setClanID(1l);

		assertEquals(1l, ((Clan) ado).getClanID());
	}

	@Test
	void testImeClana() {
		((Clan) ado).setImeClana("Pera");

		assertEquals("Pera", ((Clan) ado).getImeClana());
	}

	@Test
	void testPrezImeClana() {
		((Clan) ado).setPrezimeClana("Peric");

		assertEquals("Peric", ((Clan) ado).getPrezimeClana());
	}

	@Test
	void testEmail() {
		((Clan) ado).setEmail("pera@gmail.com");

		assertEquals("pera@gmail.com", ((Clan) ado).getEmail());
	}

	@Test
	void testDatumRodjenja() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		((Clan) ado).setDatumRodjenja(d);

		assertEquals(d, ((Clan) ado).getDatumRodjenja());
	}

	@Test
	void testTelefonClana() {
		((Clan) ado).setTelefonClana("061213112");

		assertEquals("061213112", ((Clan) ado).getTelefonClana());
	}

	@Test
	void testKategorijaClana() {
		Kategorija k = new Kategorija(1l, "Junior");

		((Clan) ado).setKategorija(k);

		assertEquals(k, ((Clan) ado).getKategorija());
	}

	@Test
	void testPozicija() {
		Pozicija p = new Pozicija(1l, "Golman");

		((Clan) ado).setPozicija(p);

		assertEquals(p, ((Clan) ado).getPozicija());
	}

	@Test
	void testToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2024");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Kategorija k = new Kategorija(1l, "Junior");

		Pozicija p = new Pozicija(1l, "Golman");

		ado = new Clan(1l, "Pera", "Peric", "pera@gmail.com", d, "061213112", k, p);

		String s = ado.toString();

		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
		assertTrue(s.contains("Junior"));
	}
	
	@Test
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
		"pera@gmail.com, 061213112, pera@gmail.com, 061213112, true",
		"pera@gmail.com, 061213112, pera@gmail.com, 067777777, true",
		"pera@gmail.com, 061213112, miki@gmail.com, 061213112, true",
		"pera@gmail.com, 061213112, miki@gmail.com, 067777777, false"
	})
	void testEqualsIsti(String email1, String tel1, String email2, String tel2, boolean isti) {
		Clan c1 = new Clan();
		c1.setEmail(email1);
		c1.setTelefonClana(tel1);
		
		Clan c2 = new Clan();
		c2.setEmail(email2);
		c2.setTelefonClana(tel2);
		
		assertEquals(isti, c1.equals(c2));
	}

	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();

		assertTrue(s.toLowerCase().contains("clan"));
	}

	@Test
	void testAlijas() {
		String s = ado.alijas();

		assertTrue(s.toLowerCase().contains("c"));
	}

	@Test
	void testJoin() {
		assertEquals(" JOIN KATEGORIJA K ON (K.KATEGORIJAID = C.KATEGORIJAID) "
				+ "JOIN POZICIJA P ON (P.POZICIJAID = C.POZICIJAID)", ado.join());
	}

	@Test
	void testKoloneZaInsert() {
		assertEquals(" (imeClana, prezimeClana, email, datumRodjenja, telefonClana, kategorijaID, pozicijaID) ",
				ado.koloneZaInsert());
	}

	@Test
	void testPrimarniKljuc() {
		((Clan) ado).setClanID(1l);

		String s = ado.vrednostZaPrimarniKljuc();

		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Clan) ado).setImeClana("Pera");
		((Clan) ado).setPrezimeClana("Peric");
		((Clan) ado).setEmail("pera@gmail.com");

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2024");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		((Clan) ado).setDatumRodjenja(d);

		((Clan) ado).setTelefonClana("061213112");

		Kategorija k = new Kategorija();
		k.setKategorijaID(1l);

		((Clan) ado).setKategorija(k);

		Pozicija p = new Pozicija();
		p.setPozicijaID(2l);

		((Clan) ado).setPozicija(p);

		String s = ado.vrednostiZaInsert();

		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
		assertTrue(s.contains("pera@gmail.com"));
		assertTrue(s.contains("2024-10-10"));
		assertTrue(s.contains("061213112"));
		assertTrue(s.contains("1"));
		assertTrue(s.contains("2"));
	}

	@Test
	void testVrednostiZaUpdate() {
		((Clan) ado).setEmail("pera@gmail.com");
		((Clan) ado).setTelefonClana("061213112");

		Kategorija k = new Kategorija();
		k.setKategorijaID(1l);

		((Clan) ado).setKategorija(k);

		Pozicija p = new Pozicija();
		p.setPozicijaID(2l);

		((Clan) ado).setPozicija(p);

		String s = ado.vrednostiZaUpdate();

		assertTrue(s.contains("pera@gmail.com"));
		assertTrue(s.contains("061213112"));
		assertTrue(s.contains("1"));
		assertTrue(s.contains("2"));
	}

	@Test
	void testUslovKategorijaNull() {
		((Clan) ado).setKategorija(null);

		assertEquals("", ado.uslov());
	}

	@Test
	void testUslovKategorija() {
		Kategorija k = new Kategorija();
		k.setKategorijaID(1l);

		((Clan) ado).setKategorija(k);

		String s = ado.uslov();

		assertTrue(s.contains("1"));
	}

}
