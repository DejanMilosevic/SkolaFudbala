package rs.np.milosevic_dejan_0098_2019.so.clan;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Kategorija;
import rs.np.milosevic_dejan_0098_2019.domain.Pozicija;

class SOAddClanTest {

	SOAddClan so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOAddClan();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}
	
	@Test
	void testUspesnoDodatClan() {
		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
		int brojClanovaUBaziPreDodavanja = clanovi.size();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("11.11.2001");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Clan c = new Clan(null, "Zarko", "Zarkovic", "zarko@gmail.com", d, "0666666666", new Kategorija(1l, null),
				new Pozicija(1l, null));

		try {
			so.templateExecute(c);
		} catch (Exception e1) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}

		clanovi = vratiSveClanoveIzBaze();

		assertEquals(brojClanovaUBaziPreDodavanja + 1, clanovi.size());
		assertTrue(clanovi.contains(c));

		obrisiDodatogClanaIzBaze(c);
	}

	@Test
	void testNeuspesnaValidacijaDrugaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Administrator()));
	}

	@Test
	void testNeuspesnaValidacijaNull() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}
	
	@Test
	void testImeClanaNull() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2024");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		
		Clan c = new Clan(null, null, "Milic", "mile@gmail.com", d, "O65555555", new Kategorija(1l, null),
				new Pozicija(1l, null));
		
		assertThrows(Exception.class, () -> so.templateExecute(c));
	}

	@Test
	void testNeuspesnaValidacijaDatumRodjenjaUBuducnosti() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2024");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}
		
		Clan c = new Clan(null, "Mile", "Milic", "mile@gmail.com", d, "O65555555", new Kategorija(1l, null),
				new Pozicija(1l, null));

		assertThrows(Exception.class, () -> so.templateExecute(c));
	}

	@Test
	void testNeuspesnaValidacijaPostojiEmail() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			fail("Greska prilikom parsiranja datuma.");
		}
		Clan c = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888",
				new Kategorija(1l, null), new Pozicija(1l, null));
		
		String telPocetni = c.getTelefonClana();
		
		try {
			so.templateExecute(c);
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
		c.setTelefonClana("0607777777");

		assertThrows(Exception.class, () -> so.templateExecute(c));
		
		c.setTelefonClana(telPocetni);
		
		obrisiDodatogClanaIzBaze(c);
	}

	@Test
	void testNeuspesnaValidacijaPostojiTelefon() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			fail("Greska prilikom parsiranja datuma.");
		}
		Clan c = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888",
				new Kategorija(1l, null), new Pozicija(1l, null));
		
		String emailPocetni = c.getEmail();
		
		try {
			so.templateExecute(c);
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
		c.setEmail("nemanja123@gmail.com");

		assertThrows(Exception.class, () -> so.templateExecute(c));
		
		c.setEmail(emailPocetni);
		
		obrisiDodatogClanaIzBaze(c);
	}

	

	private ArrayList<Clan> vratiSveClanoveIzBaze() {
		try {
			return (ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(new Clan());
		} catch (SQLException e) {
			fail("Greska prilikom konekcije na bazu podataka.");
			return null;
		}
	}

	private void obrisiDodatogClanaIzBaze(Clan c) {
		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
		for (Clan clan : clanovi) {
			if (clan.equals(c)) {
				c.setClanID(clan.getClanID());
			}
		}
		try {
			DBBroker.getInstance().delete(c);
			DBBroker.getInstance().getConnection().commit();
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}

}
