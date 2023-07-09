package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KategorijaTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado = new Kategorija();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testKategorija() {
		ado = new Kategorija(1l, "Junior");
		
		assertEquals(1l, ((Kategorija) ado).getKategorijaID());
		assertEquals("Junior", ((Kategorija) ado).getNazivKategorije());
	}
	
	@Test
	void testKategorijaID() {
		((Kategorija) ado).setKategorijaID(1l);

		assertEquals(1l, ((Kategorija) ado).getKategorijaID());
	}
	
	@Test
	void testNazivKategorije() {
		((Kategorija) ado).setNazivKategorije("Junior");

		assertEquals("Junior", ((Kategorija) ado).getNazivKategorije());
	}
	
	@Test
	void testToString() {
		ado = new Kategorija(1l, "Junior");
		
		String s = ado.toString();
		
		assertTrue(s.contains("Junior"));
	}
	
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("kategorija"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("k"));
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
		((Kategorija) ado).setKategorijaID(1l);

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
