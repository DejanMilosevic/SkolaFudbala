package rs.np.milosevic_dejan_0098_2019.so.pozicija;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Pozicija;

class SOGetAllPozicijaTest {

	SOGetAllPozicija so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllPozicija();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}

	@Test
	void testNeuspesnaValidacijaDrugaKlasa() {
		assertThrows(Exception.class, () -> so.templateExecute(new Clan()));
	}

	@Test
	void testNeuspesnaValidacijaNull() {
		assertThrows(Exception.class, () -> so.templateExecute(null));
	}

	@Test
	void testUspesnoVracenaListaPozicija() {
		try {
			so.templateExecute(new Pozicija());
			ArrayList<Pozicija> ucitane = so.getLista();

			assertEquals(6, ucitane.size());
			assertTrue(ucitane.get(0).getNazivPozicije().equalsIgnoreCase("golman"));
			assertTrue(ucitane.get(1).getNazivPozicije().equalsIgnoreCase("stoper"));
			assertTrue(ucitane.get(2).getNazivPozicije().equalsIgnoreCase("bek"));
			assertTrue(ucitane.get(3).getNazivPozicije().equalsIgnoreCase("vezni"));
			assertTrue(ucitane.get(4).getNazivPozicije().equalsIgnoreCase("krilo"));
			assertTrue(ucitane.get(5).getNazivPozicije().equalsIgnoreCase("napadac"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
