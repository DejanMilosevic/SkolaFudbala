package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja teren na kojem se odrzava trening. Ima identifikator, naziv, kao
 * i duzinu i sirinu u metrima.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Teren extends AbstractDomainObject {

	/**
	 * Identifikator terena kao Long
	 */
	private Long terenID;

	/**
	 * Naziv terena kao String
	 */
	private String nazivTerena;

	/**
	 * Duzina terena u metrima kao Double
	 */
	private double duzina;

	/**
	 * Sirina terena u metrima kao Double
	 */
	private double sirina;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa terena na podrazumevane.
	 */
	public Teren() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa terena na osnovu unetih
	 * parametara.
	 * 
	 * @param terenID     vrednost za identifikator terena
	 * @param nazivTerena vrednost za naziv terena
	 * @param duzina      vrednost za duzinu terena u metrima
	 * @param sirina      vrednost za sirinu terena u metrima
	 */
	public Teren(Long terenID, String nazivTerena, double duzina, double sirina) {
		this.terenID = terenID;
		this.nazivTerena = nazivTerena;
		this.duzina = duzina;
		this.sirina = sirina;
	}

	/**
	 * Vraca identifikator terena.
	 * 
	 * @return identifikator terena kao Long
	 */
	public Long getTerenID() {
		return terenID;
	}

	/**
	 * Postavlja vrednost za identifikator terena.
	 * 
	 * @param terenID nova vrednost za identifikator terena
	 */
	public void setTerenID(Long terenID) {
		this.terenID = terenID;
	}

	/**
	 * Vraca naziv terena.
	 * 
	 * @return naziv terena kao String
	 */
	public String getNazivTerena() {
		return nazivTerena;
	}

	/**
	 * Postavlja vrednost za naziv terena.
	 * 
	 * @param nazivTerena nova vrednost za naziv terena
	 */
	public void setNazivTerena(String nazivTerena) {
		this.nazivTerena = nazivTerena;
	}

	/**
	 * Vraca duzinu terena u metrima.
	 * 
	 * @return duzina terena u metrima kao Double
	 */
	public double getDuzina() {
		return duzina;
	}

	/**
	 * Postavlja vrednost za duzinu terena u metrima.
	 * 
	 * @param duzina nova vrednost za duzinu terena u metrima
	 */
	public void setDuzina(double duzina) {
		this.duzina = duzina;
	}

	/**
	 * Vraca sirinu terena u metrima.
	 * 
	 * @return sirina terena u metrima kao Double
	 */
	public double getSirina() {
		return sirina;
	}

	/**
	 * Postavlja vrednost za sirinu terena u metrima.
	 * 
	 * @param sirina nova vrednost za sirinu terena u metrima
	 */
	public void setSirina(double sirina) {
		this.sirina = sirina;
	}

	/**
	 * Vraca String sa nazivom terena.
	 * 
	 * @return naziv terena kao String
	 */
	@Override
	public String toString() {
		return nazivTerena;
	}

	@Override
	public String nazivTabele() {
		return " Teren ";
	}

	@Override
	public String alijas() {
		return " t ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();

		while (rs.next()) {
			Teren t = new Teren(rs.getLong("TerenID"), rs.getString("NazivTerena"), rs.getDouble("Duzina"),
					rs.getDouble("Sirina"));

			lista.add(t);
		}
		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return "";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " TerenID = " + terenID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "";
	}

	@Override
	public String vrednostiZaUpdate() {
		return "";
	}

	@Override
	public String uslov() {
		return "";
	}
}
