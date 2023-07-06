package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja administratora sistema. Ima identifikator, ime, prezime,
 * korisnicko ime i lozinku.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 *
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Administrator extends AbstractDomainObject {

	/**
	 * Identifikator administratora kao Long
	 */
	private Long administratorID;

	/**
	 * Ime administratora kao String
	 */
	private String ime;

	/**
	 * Prezime administratora kao String
	 */
	private String prezime;

	/**
	 * Korisnicko ime administratora kao String
	 */
	private String username;

	/**
	 * Lozinka administratora kao String
	 */
	private String password;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa administratora na
	 * podrazumevane.
	 */
	public Administrator() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa administratora na osnovu unetih
	 * parametara.
	 * 
	 * @param administratorID vrednost za identifikator administratora
	 * @param ime             vrednost za ime administratora
	 * @param prezime         vrednost za prezime administratora
	 * @param username        vrednost za korisnicko ime administratora
	 * @param password        vrednost za lozinku administratora
	 */
	public Administrator(Long administratorID, String ime, String prezime, String username, String password) {
		this.administratorID = administratorID;
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
	}

	/**
	 * Vraca identifikator administratora.
	 * 
	 * @return identifikator administratora kao Long
	 */
	public Long getAdministratorID() {
		return administratorID;
	}

	/**
	 * Postavlja vrednost za identifikator administratora.
	 * 
	 * @param administratorID nova vrednost za identifikator administratora
	 */
	public void setAdministratorID(Long administratorID) {
		this.administratorID = administratorID;
	}

	/**
	 * Vraca korisnicko ime administratora.
	 * 
	 * @return korisnicko ime administratora kao String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Postavlja vrednost za korisnicko ime administratora.
	 * 
	 * @param username nova vrednost za korisnicko ime administratora
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Vraca lozinku administratora.
	 * 
	 * @return lozinka administratora kao String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Postavlja vrednost za lozinku administratora.
	 * 
	 * @param password nova vrednost za lozinku administratora
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Vraca ime administratora.
	 * 
	 * @return ime administratora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja vrednost za ime administratora.
	 * 
	 * @param ime nova vrednost za ime administratora
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * Vraca prezime administratora.
	 * 
	 * @return prezime administratora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja vrednost za prezime administratora.
	 * 
	 * @param prezime nova vrednost za prezime administratora
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * Vraca String sa imenom i prezimenom administratora.
	 * 
	 * @return ime i prezime administratora kao String
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}

	@Override
	public String nazivTabele() {
		return " administrator ";
	}

	@Override
	public String alijas() {
		return " a ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();

		while (rs.next()) {
			Administrator a = new Administrator(rs.getLong("AdministratorID"), rs.getString("Ime"),
					rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));

			lista.add(a);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (Ime, Prezime, Username, Password) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " AdministratorID = " + administratorID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + ime + "', '" + prezime + "', " + "'" + username + "', '" + password + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " Ime = '" + ime + "', Prezime = '" + prezime + "', " + "Username = '" + username + "', Password = '"
				+ password + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}

}
