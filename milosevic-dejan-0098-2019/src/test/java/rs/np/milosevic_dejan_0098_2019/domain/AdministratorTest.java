package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministratorTest extends AbstractDomainObjectTest {

	@BeforeEach
	void setUp() throws Exception {
		ado = new Administrator();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testAdministrator() {
		ado = new Administrator(1l, "Stevan", "Stevanovic", "steva", "steva123");

		assertEquals(1l, ((Administrator) ado).getAdministratorID());
		assertEquals("Stevan", ((Administrator) ado).getIme());
		assertEquals("Stevanovic", ((Administrator) ado).getPrezime());
		assertEquals("steva", ((Administrator) ado).getUsername());
		assertEquals("steva123", ((Administrator) ado).getPassword());
	}

	@Test
	void testAdministratorID() {
		((Administrator) ado).setAdministratorID(1l);

		assertEquals(1l, ((Administrator) ado).getAdministratorID());
	}

	@Test
	void testUsername() {
		((Administrator) ado).setUsername("steva");

		assertEquals("steva", ((Administrator) ado).getUsername());
	}

	@Test
	void testPassword() {
		((Administrator) ado).setPassword("steva123");

		assertEquals("steva123", ((Administrator) ado).getPassword());
	}

	@Test
	void testIme() {
		((Administrator) ado).setIme("Stevan");

		assertEquals("Stevan", ((Administrator) ado).getIme());
	}

	@Test
	void testPrezime() {
		((Administrator) ado).setPrezime("Stevanovic");

		assertEquals("Stevanovic", ((Administrator) ado).getPrezime());
	}
	
	@Test
	void testToString() {
		ado = new Administrator(1l, "Stevan", "Stevanovic", "steva", "steva123");
		
		String s = ado.toString();

		assertTrue(s.contains("Stevan"));
		assertTrue(s.contains("Stevanovic"));
	}
	
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("administrator"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("a"));
	}
	
	@Test
	void testJoin() {
		assertEquals("", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals(" (Ime, Prezime, Username, Password) ", ado.koloneZaInsert());
	}
	
	@Test
	void testPrimarniKljuc() {
		((Administrator) ado).setAdministratorID(1l);

		String s = ado.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		((Administrator) ado).setUsername("steva");
		((Administrator) ado).setPassword("steva123");
		((Administrator) ado).setIme("Stevan");
		((Administrator) ado).setPrezime("Stevanovic");

		String s = ado.vrednostiZaInsert();
		
		assertTrue(s.contains("steva"));
		assertTrue(s.contains("steva123"));
		assertTrue(s.contains("Stevan"));	
		assertTrue(s.contains("Stevanovic"));
	}

	@Test
	void testVrednostiZaUpdate() {
		((Administrator) ado).setUsername("steva");
		((Administrator) ado).setPassword("steva123");
		((Administrator) ado).setIme("Stevan");
		((Administrator) ado).setPrezime("Stevanovic");

		String s = ado.vrednostiZaUpdate();
		
		assertTrue(s.contains("steva"));
		assertTrue(s.contains("steva123"));
		assertTrue(s.contains("Stevan"));	
		assertTrue(s.contains("Stevanovic"));
	}
	
	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}
}
