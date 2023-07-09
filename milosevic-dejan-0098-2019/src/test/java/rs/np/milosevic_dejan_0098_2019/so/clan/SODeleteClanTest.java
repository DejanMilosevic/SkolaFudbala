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

class SODeleteClanTest {

	SODeleteClan so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SODeleteClan();
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
	void testUspesnoObrisanClan() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			fail("Greska prilikom parsiranja datuma.");
		}

		Clan c = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888", new Kategorija(1l, null),
				new Pozicija(1l, null));

		dodajClana(c);

		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
		int brojClanovaPreBrisanja = clanovi.size();
		
		for (Clan clan : clanovi) {
			if (c.equals(clan)) {
				c.setClanID(clan.getClanID());
			}
		}
		
		try {
			so.templateExecute(c);
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
		
		clanovi = vratiSveClanoveIzBaze();
		
		assertEquals(brojClanovaPreBrisanja - 1, clanovi.size());
		assertFalse(clanovi.equals(c));
	}

	private void dodajClana(Clan c) {
		try {
			DBBroker.getInstance().insert(c);
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

}
