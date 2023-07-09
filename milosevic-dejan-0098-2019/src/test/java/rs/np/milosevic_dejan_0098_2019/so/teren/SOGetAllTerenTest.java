package rs.np.milosevic_dejan_0098_2019.so.teren;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Teren;

class SOGetAllTerenTest {

	SOGetAllTeren so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllTeren();
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
	void testUspesnoVracenaListaTerena() {
		try {
			so.templateExecute(new Teren());
			ArrayList<Teren> ucitani = so.getLista();

			assertEquals(4, ucitani.size());
			assertTrue(ucitani.get(0).getNazivTerena().equalsIgnoreCase("old trafford"));
			assertTrue(ucitani.get(1).getNazivTerena().equalsIgnoreCase("marakana"));
			assertTrue(ucitani.get(2).getNazivTerena().equalsIgnoreCase("camp nou"));
			assertTrue(ucitani.get(3).getNazivTerena().equalsIgnoreCase("anfield"));
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}
}
