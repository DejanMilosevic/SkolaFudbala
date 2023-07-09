package rs.np.milosevic_dejan_0098_2019.so.trener;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Trener;

class SOGetAllTrenerTest {

	SOGetAllTrener so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllTrener();
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
	void testUspesnoVracenaListaTrenera() {
		try {
			so.templateExecute(new Trener());
			ArrayList<Trener> ucitani = so.getLista();

			assertEquals(3, ucitani.size());
			assertTrue(ucitani.get(0).getImeTrenera().equalsIgnoreCase("pep")
					&& ucitani.get(0).getPrezimeTrenera().equalsIgnoreCase("gvardiola"));
			assertTrue(ucitani.get(1).getImeTrenera().equalsIgnoreCase("jose")
					&& ucitani.get(1).getPrezimeTrenera().equalsIgnoreCase("mourinho"));
			assertTrue(ucitani.get(2).getImeTrenera().equalsIgnoreCase("dejan")
					&& ucitani.get(2).getPrezimeTrenera().equalsIgnoreCase("stankovic"));
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}

}
