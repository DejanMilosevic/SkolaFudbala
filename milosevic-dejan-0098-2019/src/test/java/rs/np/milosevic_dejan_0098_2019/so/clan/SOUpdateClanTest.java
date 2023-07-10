package rs.np.milosevic_dejan_0098_2019.so.clan;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Kategorija;
import rs.np.milosevic_dejan_0098_2019.domain.Pozicija;

class SOUpdateClanTest {

	SOUpdateClan so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOUpdateClan();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}

	@Test
	void testUspesnoIzmenjenClan() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Clan c = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888", new Kategorija(1l, null),
				new Pozicija(1l, null));

		String emailPocetni = c.getEmail();
		String telPocetni = c.getTelefonClana();
		
		dodajClana(c);

		c.setEmail("nemanja123@gmail.com");
		c.setTelefonClana("0616666666");
		c.setKategorija(new Kategorija(2l, null));
		c.setPozicija(new Pozicija(3l, null));

		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
		for (Clan clan : clanovi) {
			if (c.equals(clan)) {
				c.setClanID(clan.getClanID());
			}
		}
		try {
			so.templateExecute(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		clanovi = vratiSveClanoveIzBaze();

		for (Clan clan : clanovi) {
			if (c.getClanID() == clan.getClanID()) {
				assertTrue(clan.getEmail().equals(c.getEmail()));
				assertTrue(clan.getTelefonClana().equals(c.getTelefonClana()));
				assertTrue(clan.getKategorija().getKategorijaID().equals(c.getKategorija().getKategorijaID()));
				assertTrue(clan.getPozicija().getPozicijaID().equals(c.getPozicija().getPozicijaID()));
				break;
			}
		}

		c.setEmail(emailPocetni);
		c.setTelefonClana(telPocetni);
		obrisiDodatogClanaIzBaze(c, clanovi);
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
	void testNeuspesnaValidacijaPostojiEmail() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Clan c1 = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888", new Kategorija(1l, null),
				new Pozicija(1l, null));

		String emailPocetni = c1.getEmail();

		dodajClana(c1);

		Clan c2 = new Clan(null, "Nesa", "Nesic", "nesa@gmail.com", d, "0607777777", new Kategorija(1l, null),
				new Pozicija(1l, null));

		dodajClana(c2);

		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();

		for (Clan clan : clanovi) {
			if (c1.equals(clan)) {
				c1.setClanID(clan.getClanID());
			}
		}
		c1.setEmail(c2.getEmail());

		assertThrows(Exception.class, () -> so.templateExecute(c1));

		c1.setEmail(emailPocetni);

		obrisiDodatogClanaIzBaze(c1, clanovi);
		obrisiDodatogClanaIzBaze(c2, clanovi);
	}

	@Test
	void testNeuspesnaValidacijaPostojiTelefon() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Date d = null;
		try {
			d = sdf.parse("10.10.2000");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Clan c1 = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", d, "0618888888", new Kategorija(1l, null),
				new Pozicija(1l, null));

		String telPocetni = c1.getTelefonClana();

		dodajClana(c1);

		Clan c2 = new Clan(null, "Nesa", "Nesic", "nesa@gmail.com", d, "0607777777", new Kategorija(1l, null),
				new Pozicija(1l, null));

		dodajClana(c2);

		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();

		for (Clan clan : clanovi) {
			if (c1.equals(clan)) {
				c1.setClanID(clan.getClanID());
			}
		}
		c1.setTelefonClana(c2.getTelefonClana());

		assertThrows(Exception.class, () -> so.templateExecute(c1));

		c1.setTelefonClana(telPocetni);

		obrisiDodatogClanaIzBaze(c1, clanovi);
		obrisiDodatogClanaIzBaze(c2, clanovi);
	}

	private ArrayList<Clan> vratiSveClanoveIzBaze() {
		try {
			SOGetAllClan so = new SOGetAllClan();
			so.templateExecute(new Clan());
			return so.getLista();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void obrisiDodatogClanaIzBaze(Clan c, ArrayList<Clan> clanovi) {
		for (Clan clan : clanovi) {
			if (clan.equals(c)) {
				c.setClanID(clan.getClanID());
			}
		}
		try {
			(new SODeleteClan()).templateExecute(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dodajClana(Clan c) {
		try {
			(new SOAddClan()).templateExecute(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
