package rs.np.milosevic_dejan_0098_2019.so.ucesce;

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
import rs.np.milosevic_dejan_0098_2019.so.trening.SOAddTrening;
import rs.np.milosevic_dejan_0098_2019.so.trening.SODeleteTrening;
import rs.np.milosevic_dejan_0098_2019.so.trening.SOGetAllTrening;

class SOGetAllUcesceTest {

	SOGetAllUcesce so;
	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllUcesce();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}

	@Test
	void testUspesnoVracenaListaUcesca() {
		Trening t = new Trening();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date d = null;
		try {
			d = sdf.parse("10.10.2023 10:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setDatumVreme(d);

		Kategorija k = new Kategorija();
		k.setKategorijaID(1l);
		t.setKategorija(k);

		Trener tr = new Trener();
		tr.setTrenerID(1l);
		t.setTrener(tr);

		Teren te = new Teren();
		te.setTerenID(1l);
		t.setTeren(te);

		Administrator a = new Administrator();
		a.setAdministratorID(1l);
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
		
		try {
			so.templateExecute(uc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(2, so.getLista().size());
		assertTrue(uc.getTrening().equals(so.getLista().get(0).getTrening())
				&& uc.getClan().equals(so.getLista().get(0).getClan()));
		assertTrue(uc2.getTrening().equals(so.getLista().get(1).getTrening())
				&& uc2.getTrening().equals(so.getLista().get(1).getTrening()));

		obrisiDodatiTreningIzBaze(t);
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
}
