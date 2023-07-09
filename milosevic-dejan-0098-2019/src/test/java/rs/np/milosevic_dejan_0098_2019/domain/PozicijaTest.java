package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PozicijaTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado = new Pozicija();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testPozicija() {
		ado = new Pozicija(1l, "Golman");

		assertEquals(1l, ((Pozicija) ado).getPozicijaID());
		assertEquals("Golman", ((Pozicija) ado).getNazivPozicije());
	}

	@Test
	void testPozicijaID() {
		((Pozicija) ado).setPozicijaID(1l);

		assertEquals(1l, ((Pozicija) ado).getPozicijaID());
	}

	@Test
	void testNazivPozicije() {
		((Pozicija) ado).setNazivPozicije("Golman");

		assertEquals("Golman", ((Pozicija) ado).getNazivPozicije());
	}

	@Test
	void testToString() {
		ado = new Pozicija(1l, "Golman");

		String s = ado.toString();

		assertTrue(s.contains("Golman"));
	}

	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();

		assertTrue(s.toLowerCase().contains("pozicija"));
	}

	@Test
	void testAlijas() {
		String s = ado.alijas();

		assertTrue(s.toLowerCase().contains("p"));
	}

	@Test
	void testJoin() {
		assertEquals("", ado.join());
	}
	
	@Test
	void testKoloneZaInsert() {
		assertEquals("", ado.koloneZaInsert());
	}
	
	@Test
	void testPrimarniKljuc() {
		((Pozicija) ado).setPozicijaID(1l);

		String s = ado.vrednostZaPrimarniKljuc();

		assertTrue(s.contains("1"));
	}

	@Test
	void testVrednostiZaInsert() {
		assertEquals("", ado.vrednostiZaInsert());
	}

	@Test
	void testVrednostiZaUpdate() {
		assertEquals("", ado.vrednostiZaUpdate());
	}

	@Test
	void testUslov() {
		assertEquals("", ado.uslov());
	}

}
