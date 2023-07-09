package rs.np.milosevic_dejan_0098_2019.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrenerTest extends AbstractDomainObjectTest {
	
	@BeforeEach
	void setUp() throws Exception {
		ado = new Trener();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
	}

	@Test
	void testTrener() {
		ado = new Trener(1l, "Dejan", "Stankovic", 7, "0633333333");

		assertEquals(1l, ((Trener) ado).getTrenerID());
		assertEquals("Dejan", ((Trener) ado).getImeTrenera());
		assertEquals("Stankovic", ((Trener) ado).getPrezimeTrenera());
		assertEquals(7, ((Trener) ado).getGodineIskustva());
		assertEquals("0633333333", ((Trener) ado).getTelefonTrenera());
	}

	@Test
	void testTrenerID() {
		((Trener) ado).setTrenerID(1l);

		assertEquals(1l, ((Trener) ado).getTrenerID());
	}

	@Test
	void testImeTrenera() {
		((Trener) ado).setImeTrenera("Dejan");

		assertEquals("Dejan", ((Trener) ado).getImeTrenera());
	}

	@Test
	void testPrezimeTrenera() {
		((Trener) ado).setPrezimeTrenera("Stankovic");

		assertEquals("Stankovic", ((Trener) ado).getPrezimeTrenera());
	}
	
	@Test
	void testGodineIskustva() {
		((Trener) ado).setGodineIskustva(7);

		assertEquals(7, ((Trener) ado).getGodineIskustva());
	}
	
	@Test
	void testTelefonTrenera() {
		((Trener) ado).setTelefonTrenera("0633333333");;

		assertEquals("0633333333", ((Trener) ado).getTelefonTrenera());
	}
	
	@Test
	void testToString() {
		ado = new Trener(1l, "Dejan", "Stankovic", 7, "0633333333");

		String s = ado.toString();

		assertTrue(s.contains("Dejan Stankovic"));
	}
	
	@Test
	void testNazivTabele() {
		String s = ado.nazivTabele();

		assertTrue(s.toLowerCase().contains("trener"));
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
		((Trener) ado).setTrenerID(1l);

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
