package rs.np.milosevic_dejan_0098_2019.so.administrator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;

class SOGetAllAdministratorTest {

	SOGetAllAdministrator so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOGetAllAdministrator();
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
	void testUspesnoVracenaListaAdministratora() {
		try {
			so.templateExecute(new Administrator());
			ArrayList<Administrator> ucitani = so.getLista();

			assertEquals(2, ucitani.size());
			assertTrue(ucitani.get(0).getUsername().equalsIgnoreCase("deki") && 
					ucitani.get(0).getPassword().equalsIgnoreCase("deki123"));
			assertTrue(ucitani.get(1).getUsername().equalsIgnoreCase("steva") && 
					ucitani.get(1).getPassword().equalsIgnoreCase("steva123"));
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
	}

}
