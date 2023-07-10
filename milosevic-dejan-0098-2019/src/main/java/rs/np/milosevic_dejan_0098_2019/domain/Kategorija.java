package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

/**
 * Predstavlja kategoriju treninga kojoj pripada clan. Ima identifikator i
 * naziv.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Kategorija extends AbstractDomainObject {

	/**
	 * Predstavlja identifikator kategorije kao Long
	 */
	private transient Long kategorijaID;

	/**
	 * Predstavlja naziv kategorije kao String
	 */
	@SerializedName("Naziv")
	private String nazivKategorije;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa kategorije na
	 * podrazumevane.
	 */
	public Kategorija() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa kategorije na osnovu unetih
	 * parametara.
	 * 
	 * @param kategorijaID    vrednost za identifikator kategorije
	 * @param nazivKategorije vrednost za naziv kategorije
	 */
	public Kategorija(Long kategorijaID, String nazivKategorije) {
		this.kategorijaID = kategorijaID;
		this.nazivKategorije = nazivKategorije;
	}

	/**
	 * Vraca identifikator kategorije.
	 * 
	 * @return identifikator kategorije kao Long
	 */
	public Long getKategorijaID() {
		return kategorijaID;
	}

	/**
	 * Postavlja vrednost za identifikator kategorije.
	 * 
	 * @param kategorijaID nova vrednost za identifikator kategorije
	 */
	public void setKategorijaID(Long kategorijaID) {
		this.kategorijaID = kategorijaID;
	}

	/**
	 * Vraca naziv kategorije.
	 * 
	 * @return naziv kategorije kao String
	 */
	public String getNazivKategorije() {
		return nazivKategorije;
	}

	/**
	 * Postavlja vrednost za naziv kategorije.
	 * 
	 * @param nazivKategorije nova vrednost za naziv kategorije
	 */
	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	/**
	 * Vraca String sa nazivom kategorije.
	 * 
	 * @return naziv kategorije kao String
	 */
	@Override
	public String toString() {
		return nazivKategorije;
	}

	@Override
	public String nazivTabele() {
		return " Kategorija ";
	}

	@Override
	public String alijas() {
		return " K ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();

		while (rs.next()) {
			Kategorija k = new Kategorija(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));

			lista.add(k);
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
		return " KategorijaID = " + kategorijaID;
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
