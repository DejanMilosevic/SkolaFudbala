package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja poziciju clana na terenu. Ima identifikator i naziv.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan
 * @since 1.1.0
 */
public class Pozicija extends AbstractDomainObject {

	/**
	 * Predstavlja identifikator pozicije kao Long
	 */
	private Long pozicijaID;

	/**
	 * Predstavlja naziv pozicije kao String
	 */
	private String nazivPozicije;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa pozicije na
	 * podrazumevane.
	 */
	public Pozicija() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa pozicije na osnovu unetih
	 * parametara.
	 * 
	 * @param pozicijaID    vrednost za identifikator pozicije
	 * @param nazivPozicije vrednost za naziv pozicije
	 */
	public Pozicija(Long pozicijaID, String nazivPozicije) {
		this.pozicijaID = pozicijaID;
		this.nazivPozicije = nazivPozicije;
	}

	/**
	 * Vraca identifikator pozicije.
	 * 
	 * @return identifikator pozicije kao Long
	 */
	public Long getPozicijaID() {
		return pozicijaID;
	}

	/**
	 * Postavlja vrednost za identifikator pozicije.
	 * 
	 * @param pozicijaID nova vrednost za identifikator pozicije
	 */
	public void setPozicijaID(Long pozicijaID) {
		this.pozicijaID = pozicijaID;
	}

	/**
	 * Vraca naziv pozicije.
	 * 
	 * @return naziv pozicije kao String
	 */
	public String getNazivPozicije() {
		return nazivPozicije;
	}

	/**
	 * Postavlja vrednost za naziv pozicije.
	 * 
	 * @param nazivPozicije nova vrednost za naziv pozicije
	 */
	public void setNazivPozicije(String nazivPozicije) {
		this.nazivPozicije = nazivPozicije;
	}

	/**
	 * Vraca String sa nazivom pozicije.
	 * 
	 * @return naziv pozicije kao String
	 */
	@Override
	public String toString() {
		return nazivPozicije;
	}

	@Override
	public String nazivTabele() {
		return " Pozicija ";
	}

	@Override
	public String alijas() {
		return " p ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();

		while (rs.next()) {
			Pozicija p = new Pozicija(rs.getLong("PozicijaID"), rs.getString("NazivPozicije"));

			lista.add(p);
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
		return " PozicijaID = " + pozicijaID;
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