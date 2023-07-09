package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TerenTest extends AbstractDomainObjectTest{

	@BeforeEach
	void setUp() throws Exception {
		ado = new Teren();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testTeren() {
		ado = new Teren(1l, "Marakana", 105.1, 68.2);
		
		assertEquals(1l, ((Teren) ado).getTerenID());
		assertEquals("Marakana", ((Teren) ado).getNazivTerena());
		assertEquals(105.1, ((Teren) ado).getDuzina());
		assertEquals(68.2, ((Teren) ado).getSirina());
	}
	
	@Test
	void testTerenID() {
		((Teren) ado).setTerenID(1l);

		assertEquals(1l, ((Teren) ado).getTerenID());
	}
	
	@Test
	void testNazivTerena() {
		((Teren) ado).setNazivTerena("Marakana");

		assertEquals("Marakana", ((Teren) ado).getNazivTerena());
	}
	
	@Test
	void testDuzina() {
		((Teren) ado).setDuzina(105.1);

		assertEquals(105.1, ((Teren) ado).getDuzina());
	}
	
	@Test
	void testSirina() {
		((Teren) ado).setSirina(68.2);

		assertEquals(68.2, ((Teren) ado).getSirina());
	}
	
	@Test
	void testToString() {
		ado = new Teren(1l, "Marakana", 105.1, 68.2);
		
		String s = ado.toString();
		
		assertTrue(s.contains("Marakana"));
	}
	
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("teren"));
	}
	
	@Test
	void testAlijas() {
		String s = ado.alijas();
		
		assertTrue(s.toLowerCase().contains("t"));
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
		((Teren) ado).setTerenID(1l);

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
