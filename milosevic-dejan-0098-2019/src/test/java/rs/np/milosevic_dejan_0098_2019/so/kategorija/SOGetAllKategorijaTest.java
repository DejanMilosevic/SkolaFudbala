package rs.np.milosevic_dejan_0098_2019.so.kategorija;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Kategorija;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;

class SOGetAllKategorijaTest {

	SOGetAllKategorija so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllKategorija();
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
	void testUspesnoVracenaListaKategorija() {
		try {
			so.templateExecute(new Kategorija());
			ArrayList<Kategorija> ucitane = so.getLista();
			
			assertEquals(3, ucitane.size());
			assertTrue(ucitane.get(0).getNazivKategorije().equalsIgnoreCase("junior"));
			assertTrue(ucitane.get(1).getNazivKategorije().equalsIgnoreCase("medior"));
			assertTrue(ucitane.get(2).getNazivKategorije().equalsIgnoreCase("senior"));
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}

}
