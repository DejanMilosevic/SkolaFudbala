package rs.np.milosevic_dejan_0098_2019.so.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;

class SOLoginTest {

	SOLogin so;

	@BeforeEach
	void setUp() throws Exception {
		so = new SOLogin();
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
	void testLoginNePostojiAdministrator() {
		Administrator a = new Administrator();
		a.setUsername("darko");
		a.setPassword("darko123");
	
		assertThrows(Exception.class, () -> so.templateExecute(a));
	}
	
	@Test
	void testLoginUspesnaRegistracija() {
		Administrator a = new Administrator();
		a.setUsername("deki");
		a.setPassword("deki123");
		
		try {
			so.templateExecute(a);
		} catch (Exception e) {
			fail("Greska prilikom konekcije na bazu podataka.");
		}
		
		assertEquals(a.getUsername(), so.getUlogovani().getUsername());
		assertEquals(a.getPassword(), so.getUlogovani().getPassword());
	}
}
