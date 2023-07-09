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

class SOGetAllClanTest {

	SOGetAllClan so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllClan();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
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
	void testUspesnoVracenaListaClanova() {
		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();

		int brojClanovaUBaziPreDodavanja = clanovi.size();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d1 = null;
		try {
			d1 = sdf.parse("10.10.2000");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Clan c1 = new Clan(null, "Zarko", "Zarkovic", "zarko@gmail.com", d1, "0666666666", new Kategorija(1l, null),
				new Pozicija(1l, null));

		dodajClana(c1);

		Date d2 = null;
		try {
			d2 = sdf.parse("11.11.2001");
		} catch (ParseException e) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Clan c2 = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d2, "0618888888",
				new Kategorija(1l, null), new Pozicija(1l, null));

		dodajClana(c2);

		try {
			so.templateExecute(new Clan());
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}

		assertEquals(brojClanovaUBaziPreDodavanja + 2, so.getLista().size());
		assertTrue(so.getLista().contains(c1));
		assertTrue(so.getLista().contains(c2));

		obrisiDodatogClanaIzBaze(c1, so.getLista());
		obrisiDodatogClanaIzBaze(c2, so.getLista());
	}

	private void obrisiDodatogClanaIzBaze(Clan c, ArrayList<Clan> clanovi) {
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

	private ArrayList<Clan> vratiSveClanoveIzBaze() {
		try {
			return (ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(new Clan());
		} catch (SQLException e) {
			fail("Greska prilikom konekcije na bazu podataka.");
			return null;
		}
	}

	private void dodajClana(Clan c) {
		try {
			DBBroker.getInstance().insert(c);
			DBBroker.getInstance().getConnection().commit();
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}
}
