package rs.np.milosevic_dejan_0098_2019.so.trening;

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
import rs.np.milosevic_dejan_0098_2019.domain.Teren;
import rs.np.milosevic_dejan_0098_2019.domain.Trener;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import rs.np.milosevic_dejan_0098_2019.so.clan.SOAddClan;
import rs.np.milosevic_dejan_0098_2019.so.clan.SODeleteClan;
import rs.np.milosevic_dejan_0098_2019.so.clan.SOGetAllClan;

class SOGetAllTreningTest {

	SOGetAllTrening so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllTrening();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}
	
	@Test
	void testUspesnoVracenaListaTreninga() {
		ArrayList<Trening> treninzi = vratiSveTreningeIzBaze();
		int brojTreningaPreDodavanja = treninzi.size();

		Trening t = new Trening();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setDatumVreme(d);

		Kategorija k = new Kategorija(1l, "Junior");
		t.setKategorija(k);

		Trener tr = new Trener(3l, "Dejan", "Stankovic", 7, "0641235153");
		t.setTrener(tr);

		Teren te = new Teren(2l, "Marakana", 110.3, 73.1);
		t.setTeren(te);

		Administrator a = new Administrator(2l, "Stevan", "Stevanovic", "steva", "steva123");
		t.setAdministrator(a);

		ArrayList<Ucesce> ucesca = new ArrayList<>();

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
		Date dClana = null;
		try {
			dClana = sdf2.parse("10.10.2000");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Pozicija p = new Pozicija();
		p.setPozicijaID(1l);

		Clan c = new Clan(null, "Nemanja", "Nikic", "nemanja@gmail.com", dClana, "0618888888", k, p);

		Clan c2 = new Clan(null, "Zarko", "Zarkovic", "zarko@gmail.com", dClana, "0666666666", k, p);

		dodajClana(c);
		c.setClanID(vratiIDClana(c));

		Ucesce uc = new Ucesce(t, 1, "", c);
		ucesca.add(uc);

		dodajClana(c2);
		c2.setClanID(vratiIDClana(c2));

		Ucesce uc2 = new Ucesce(t, 2, "", c2);
		ucesca.add(uc2);

		t.setUcesca(ucesca);

		t.setMaxBrojClanova(5);

		dodajTrening(t);
		
		Trening t2 = new Trening();

		Date d2 = null;
		try {
			d2 = sdf.parse("11.11.2023 11:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<Ucesce> ucesca2 = new ArrayList<>();

		Ucesce uc3 = new Ucesce(t2, 1, "", c);
		ucesca2.add(uc3);

		Ucesce uc4 = new Ucesce(t2, 2, "", c2);
		ucesca2.add(uc4);

		t2.setDatumVreme(d2);
		t2.setMaxBrojClanova(7);
		t2.setKategorija(k);
		t2.setTeren(te);
		t2.setTrener(tr);
		t2.setAdministrator(a);
		t2.setUcesca(ucesca2);

		dodajTrening(t2);

		try {
			so.templateExecute(new Trening());
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(brojTreningaPreDodavanja + 2, so.getLista().size());
		assertTrue(so.getLista().contains(t));
		assertTrue(so.getLista().contains(t2));

		obrisiDodatiTreningIzBaze(t);
		obrisiDodatiTreningIzBaze(t2);
		obrisiDodatogClanaIzBaze(c);
		obrisiDodatogClanaIzBaze(c2);
	}
	
	@Test
	void testNeuspesnaValidacijaDrugaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Administrator()));
	}

	@Test
	void testNeuspesnaValidacijaNull() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}

	private void dodajTrening(Trening t) {
		try {
			(new SOAddTrening()).templateExecute(t);
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

	private Long vratiIDClana(Clan c) {
		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
		for (Clan clan : clanovi) {
			if (clan.equals(c)) {
				return clan.getClanID();
			}
		}
		return null;
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

	private void obrisiDodatogClanaIzBaze(Clan c) {
		ArrayList<Clan> clanovi = vratiSveClanoveIzBaze();
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

	private ArrayList<Trening> vratiSveTreningeIzBaze() {
		try {
			SOGetAllTrening so = new SOGetAllTrening();
			so.templateExecute(new Trening());
			return so.getLista();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void obrisiDodatiTreningIzBaze(Trening t) {
		ArrayList<Trening> treninzi = vratiSveTreningeIzBaze();
		for (Trening trening : treninzi) {
			if (trening.equals(t)) {
				t.setTreningID(trening.getTreningID());
			}
		}
		try {
			(new SODeleteTrening()).templateExecute(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
